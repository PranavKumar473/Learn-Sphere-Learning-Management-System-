package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entities.Users;

public interface UsersRepository  extends JpaRepository<Users, Integer>{
	Users findByEmail(String email);//providing signature because system knows only findById.
	boolean existsByEmail(String email);
}