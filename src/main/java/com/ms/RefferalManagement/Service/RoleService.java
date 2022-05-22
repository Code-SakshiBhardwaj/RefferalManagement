package com.ms.RefferalManagement.Service;

import java.util.List;

import com.ms.RefferalManagement.Entity.Role;

public interface RoleService {
	
	public List<Role> getAll();
	public String add(Role role);
	public String update(Role role);
	public Role getById(Long id);
	public String delete(Long id);
	public Role getByName(String name);

}
