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

import com.ms.RefferalManagement.Entity.Privilege;
import com.ms.RefferalManagement.Service.PrivilegeService;



@RequestMapping("/privilege")
@RestController
public class PrivilegeController {
	@Autowired 
	private PrivilegeService privilegeService;
	
	@PostMapping("/add")
	public String add(@RequestBody Privilege privilege) {
		return privilegeService.add(privilege);
	}
	
	@GetMapping("/getAll")
	public List<Privilege> getAll(){
		return privilegeService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public Privilege getById(@PathVariable Long id) {
		return privilegeService.getById(id);
	}
	
	@GetMapping("/getByName/{name}")
	public Privilege getByName(@PathVariable String name) {
		return privilegeService.getByName(name);
	}
	
	
	@PutMapping("/update")
	public String update(@RequestBody Privilege privilege) {
		return privilegeService.update(privilege);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return privilegeService.delete(id);
	}
}
