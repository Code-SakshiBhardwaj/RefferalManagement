package com.ms.RefferalManagement.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.RefferalManagement.Entity.Privilege;
import com.ms.RefferalManagement.Repository.PrivilegeRepository;




@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	private  PrivilegeRepository privilegeRepository;

	@Override
	public List<Privilege> getAll() {
		return privilegeRepository.findAll();
	}

	@Override
	public String add(Privilege privilege) {
		if(privilege.getName()==null ||privilege.getRoles()==null) {
			return "Mandatory field is missing";
		}
	for(Privilege c:getAll()) {
		if(c.getId()==privilege.getId()) {
			return "Privilege Already Exist";
		}
		else if(c.getName().equals(privilege.getName())) {
			return "Privilege Already Registered";
		}
		
	}
	privilegeRepository.save(privilege);
	return "New Privilege Added";
	}

	@Override
	public String update(Privilege privilege) {
		if(privilegeRepository.existsById(privilege.getId())) {
			privilegeRepository.save(privilege);
			return "Privilege Updated";
		}else
		{
			return "Update failed as Privilege doesn't exist";
		}
	}

	@Override
	public Privilege getById(Long id) {
		Privilege c=null;
		for(Privilege privilege:getAll()) {
			if(privilege.getId()==id) {
				c=privilege;
				break;
			}
		}
		return c;
	}

	@Override
	public String delete(Long id) {
		if(privilegeRepository.existsById(id)) {
			privilegeRepository.deleteById(id);
			return "Privilege Deleted";
		}else
		{
			return "Delete failed as Privilege doesn't exist";
		}
	}

	@Override
	public Privilege getByName(String name) {
		Privilege data=privilegeRepository.findByName(name);
		return data;
	}

}
