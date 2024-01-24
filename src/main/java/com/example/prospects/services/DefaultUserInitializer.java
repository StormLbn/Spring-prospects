package com.example.prospects.services;

import com.example.prospects.model.Role;
import com.example.prospects.model.User;
import com.example.prospects.repository.RoleRepo;
import com.example.prospects.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserInitializer implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.findByUsername("admin") == null) {
            Role role = new Role();
            role.setRoleName("ADMIN");
            roleRepo.save(role);

            User defaultUser = new User();
            defaultUser.setRole(role);
            defaultUser.setFirstName("Admin");
            defaultUser.setLastName("ADMIN");
            defaultUser.setUsername("admin");
            defaultUser.setEmail("admin@test.com");
            defaultUser.setPassword(passwordEncoder.encode("aze123"));
            userRepo.save(defaultUser);
        }

        System.out.println();
        System.out.println("Default user : admin - password : aze123");
        System.out.println();
    }
}
