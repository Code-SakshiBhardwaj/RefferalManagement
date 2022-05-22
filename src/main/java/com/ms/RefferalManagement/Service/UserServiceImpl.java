package com.ms.RefferalManagement.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ms.RefferalManagement.Entity.User;
import com.ms.RefferalManagement.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private  UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public String add(User user) {
		if(user.getEmail()==null) {
			return "Mandatory field is missing";
		}
	for(User c:getAll()) {
		if(c.getId()==user.getId()) {
			return "User Already Exist";
		}
		else if(c.getEmail().equals(user.getEmail())) {
			return "MailId Already Registered";
		}
		
	}
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userRepository.save(user);
	return "New User Added";
	}

	@Override
	public String update(User user) {
		if(userRepository.existsById(user.getId())) {
			userRepository.save(user);
			return "User Updated";
		}else
		{
			return "Update failed as User doesn't exist";
		}
	}

	@Override
	public User getById(Long id) {
		User c=null;
		for(User user:getAll()) {
			if(user.getId()==id) {
				c=user;
				break;
			}
		}
		return c;
	}

	@Override
	public String delete(Long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "User Deleted";
		}else
		{
			return "Delete failed as User doesn't exist";
		}
	}
	

	@Override
	public User getByEmail(String email) {
		User data=userRepository.findByEmail(email);
		return data;
	}

}
