package org.eastwill.service;

import java.util.List;

import org.eastwill.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
	List<String> findUserRole(String username);
	
	public Page<Role> findPageAll(Pageable pageable);
}
