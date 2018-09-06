package com.website._1tv.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import com.website._1tv.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
