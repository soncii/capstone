package com.damir.healthcare.repositories;

import com.damir.healthcare.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
