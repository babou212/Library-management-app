package com.example.demo.service;

import com.example.demo.model.LibraryAdmin;
import com.example.demo.repository.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;

    public List<LibraryAdmin> getAdmins() {
        return adminRepo.findAll();
    }

    public Optional<LibraryAdmin> getUserByUsername(String username) throws IOException {
        return getAdmins().stream()
                .filter(item -> Objects.equals(item.getUsername(), username))
                .findFirst();
    }
}
