package com.example.demo.service;

import com.example.demo.model.LibraryUser;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public Set<LibraryUser> findAll() {
        return (Set<LibraryUser>) userRepo.findAll();
    }

    @Override
    public LibraryUser findById(Long aLong) {
        return userRepo.findById(aLong).orElse(null);
    }

    @Override
    public LibraryUser save(LibraryUser object) {
        return userRepo.save(object);
    }

    @Override
    public void delete(LibraryUser object) {
        userRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }
}
