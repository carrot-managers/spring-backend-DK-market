package com.opensource.backdk.repository;

import com.opensource.backdk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
