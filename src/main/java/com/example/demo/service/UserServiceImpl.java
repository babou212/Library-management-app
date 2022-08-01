package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public Set<User> findAll() {
        return (Set<User>) userRepo.findAll();
    }

    @Override
    public User findById(Long aLong) {
        return userRepo.findById(aLong).orElse(null);
    }

    @Override
    public User save(User object) {
        return userRepo.save(object);
    }

    @Override
    public void delete(User object) {
        userRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }
}
