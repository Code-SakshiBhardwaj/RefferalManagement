package com.ms.RefferalManagement.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.RefferalManagement.Entity.User;
import com.ms.RefferalManagement.Service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private UserService userService;
	
	@PostMapping("/add")
	public String add(@RequestBody User user) {
		return userService.add(user);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@GetMapping("/getByEmail/{email}")
	public User getByEmail(@PathVariable String email) {
		return userService.getByEmail(email);
	}
	
	
	@PutMapping("/update")
	public String update(@RequestBody User user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return userService.delete(id);
	}
}
