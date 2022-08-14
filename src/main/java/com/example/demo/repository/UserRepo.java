package com.example.demo.repository;

import com.example.demo.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<LibraryUser, Long> {
}