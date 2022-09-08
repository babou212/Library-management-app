package com.example.demo.repository;

import com.example.demo.model.LibraryAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<LibraryAdmin, Long> {
}
