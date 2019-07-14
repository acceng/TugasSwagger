package com.EKSAD.tugas.TugasSwagger.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.EKSAD.tugas.TugasSwagger.dao.UserDAO;
import com.EKSAD.tugas.TugasSwagger.model.Users;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userDao.findByUsername(username);
		if (user != null) {

			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
			return new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));

		} else {

			throw new UsernameNotFoundException("User Not Found");
		}
	}
}
