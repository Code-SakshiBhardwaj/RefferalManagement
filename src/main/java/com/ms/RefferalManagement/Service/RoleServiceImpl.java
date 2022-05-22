package com.ms.RefferalManagement.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.RefferalManagement.Entity.Role;
import com.ms.RefferalManagement.Repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private  RoleRepository roleRepository;


	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	@Override
	public String add(Role role) {
		if(role.getName()==null){
			return "Mandatory field is missing";
		}
	for(Role c:getAll()) {
		if(c.getId()==role.getId()) {
			return "Role Already Exist";
		}
		else if(c.getName().equals(role.getName())) {
			return "Role Already Registered";
		}
		
	}
	roleRepository.save(role);
	return "New Role Added";
	}

	@Override
	public String update(Role role) {
		if(roleRepository.existsById(role.getId())) {
			roleRepository.save(role);
			return "Role Updated";
		}else
		{
			return "Update failed as Role doesn't exist";
		}
	}

	@Override
	public Role getById(Long id) {
		Role c=null;
		for(Role role:getAll()) {
			if(role.getId()==id) {
				c=role;
				break;
			}
		}
		return c;
	}

	@Override
	public String delete(Long id) {
		if(roleRepository.existsById(id)) {
			roleRepository.deleteById(id);
			return "Role Deleted";
		}else
		{
			return "Delete failed as Role doesn't exist";
		}
	}

	@Override
	public Role getByName(String name) {
		Role data=roleRepository.findByName(name);
		return data;
	}

}
