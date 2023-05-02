package jp.co.ndsw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.ndsw.entites.User;
import jp.co.ndsw.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // ユーザー登録用API
    public User createUser(String no, String email, String rawPassword, String[] roles) {
        User user = new User();
        user.setNo(no);
        user.setEmail(email);
        // パスワードはハッシュ化する
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRoles(String.join(",", roles));
        return userRepository.save(user);
    }

}
