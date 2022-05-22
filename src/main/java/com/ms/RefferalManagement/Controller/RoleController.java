package com.ms.RefferalManagement.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.RefferalManagement.Entity.Role;
import com.ms.RefferalManagement.Service.RoleService;


@RequestMapping("/role")
@RestController
public class RoleController {
	@Autowired 
	private RoleService roleService;
	
	@PostMapping("/add")
	public String add(@RequestBody Role role) {
		return roleService.add(role);
	}
	
	@GetMapping("/getAll")
	public List<Role> getAll(){
		return roleService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public Role getById(@PathVariable Long id) {
		return roleService.getById(id);
	}
	
	@GetMapping("/getByName/{name}")
	public Role getByName(@PathVariable String name) {
		return roleService.getByName(name);
	}
	
	
	@PutMapping("/update")
	public String update(@RequestBody Role role) {
		return roleService.update(role);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return roleService.delete(id);
	}
}
