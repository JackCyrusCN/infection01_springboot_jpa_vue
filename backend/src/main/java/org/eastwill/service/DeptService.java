package org.eastwill.service;

import java.util.Map;

public interface DeptService {
	
	public Map<String, Object> findDepts();
	
	public void createDept(org.eastwill.domain.Dept dept);
}
