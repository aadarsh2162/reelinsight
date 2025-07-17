package com.reelinsight.repository;

import com.reelinsight.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


        boolean existsByUsername(String username);

        boolean existsByEmail(String email);

        boolean existsByMobile(String mobile);

        Optional<User> findByUsernameOrEmailOrMobile(String username, String email, String mobile);




}
