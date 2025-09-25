package com.dev.ecom.repositories;

import com.dev.ecom.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUserName(String username);

    boolean existsUserByUserName(@NotBlank @Size(min = 3, max = 20) String userName);

    boolean existsUserByEmail(@NotBlank @Size(max = 50) @Email String email);

    boolean existsByUserName(String user1);
}
