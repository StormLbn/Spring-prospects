package com.example.prospects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prospects.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
