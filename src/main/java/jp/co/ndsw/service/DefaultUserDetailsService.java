package jp.co.ndsw.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.ndsw.entites.User;
import jp.co.ndsw.repository.UserRepository;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
            .findByNo(username)
            .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        Collection<GrantedAuthority> authority =
            Arrays.stream(user.getRoles().split(","))
                .map((role) -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            user.getNo(),
            user.getPassword(),
            authority
        );
    }
    
}