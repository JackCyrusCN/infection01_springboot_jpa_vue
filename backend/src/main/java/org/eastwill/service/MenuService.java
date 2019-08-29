package org.eastwill.service;

import java.util.List;
import java.util.Map;

import org.eastwill.domain.Menu;
import org.springframework.data.domain.Sort;

public interface MenuService {
	List<String> findUserPermissions(String username);
	
	List<Menu> findUserMenus(String username);
	
	public Map<String, Object> findMenus(Sort sort,Menu menu);
	
	List<String> findUserActions(String username);
}
