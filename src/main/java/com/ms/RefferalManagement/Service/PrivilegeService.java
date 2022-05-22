package com.ms.RefferalManagement.Service;

import java.util.List;

import com.ms.RefferalManagement.Entity.Privilege;




public interface PrivilegeService {
	
	public List<Privilege> getAll();
	public String add(Privilege privilege);
	public String update(Privilege Privilege);
	public Privilege getById(Long id);
	public String delete(Long id);
	public Privilege getByName(String name);

}
