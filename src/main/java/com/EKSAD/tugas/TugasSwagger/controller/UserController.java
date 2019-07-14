package com.EKSAD.tugas.TugasSwagger.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EKSAD.tugas.TugasSwagger.dao.UserDAO;
import com.EKSAD.tugas.TugasSwagger.model.Users;

public class UserController {

	@Autowired
	UserDAO userDao;

	@RequestMapping("")
	public HashMap<String, Object> admin(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "masuk sebagai admin");
		return map;
	}
	
	@RequestMapping("user")
	public HashMap<String, Object> user(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "masuk sebagai Bolobolo");
		return map;
	}
	
	@GetMapping("getAll")
	public List<Users> getAll(){
		
		return userDao.findAll();
	}
	
	@PostMapping("save")
	public Users save( @RequestBody Users user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userDao.save(user);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		
		userDao.deleteById(id);
		return "data berhasil dihapus";
	}

}
