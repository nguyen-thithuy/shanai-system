package jp.co.ndsw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.ndsw.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNo(String no);
    
}