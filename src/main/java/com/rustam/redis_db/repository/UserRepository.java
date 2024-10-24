package com.rustam.redis_db.repository;

import com.rustam.redis_db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
