package com.website.pbc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.website.pbc.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
