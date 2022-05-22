package com.ms.RefferalManagement.Service;

import java.util.List;

import com.ms.RefferalManagement.Entity.User;
public interface UserService {
	public List<User> getAll();
	public String add(User user);
	public String update(User user);
	public User getById(Long id);
	public String delete(Long id);
	public User getByEmail(String email);

}
