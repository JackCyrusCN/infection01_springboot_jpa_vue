package org.eastwill.service.impl;

import java.util.List;

import org.eastwill.domain.Role;
import org.eastwill.repository.RoleRepository;
import org.eastwill.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<String> findUserRole(String username) {
		// TODO Auto-generated method stub
		return roleRepository.findUserRole(username);
	}

	@Override
	public Page<Role> findPageAll(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}
}
