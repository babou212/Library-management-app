package com.example.demo.repository;

import com.example.demo.model.LibraryUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<LibraryUser, Long> {
}