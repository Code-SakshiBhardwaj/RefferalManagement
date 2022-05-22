package com.ms.RefferalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.ms.RefferalManagement.Entity.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
	
}
