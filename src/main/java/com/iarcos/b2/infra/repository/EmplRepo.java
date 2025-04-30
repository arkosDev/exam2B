package com.iarcos.b2.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iarcos.b2.infra.entity.EmplEnt;

public interface EmplRepo extends JpaRepository<EmplEnt, UUID> {
	
}