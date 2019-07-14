package com.EKSAD.tugas.TugasSwagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EKSAD.tugas.TugasSwagger.model.Users;

public interface UserDAO extends JpaRepository<Users, Long> {

	public Users findByUsername(String Username);
	
}
