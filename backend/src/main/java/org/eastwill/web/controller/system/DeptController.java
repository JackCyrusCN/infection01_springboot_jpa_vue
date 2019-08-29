package org.eastwill.web.controller.system;

import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.eastwill.domain.Dept;
import org.eastwill.exception.SystemException;
import org.eastwill.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/dept")
public class DeptController {
	
	private String message;
	
	@Autowired
	private DeptService deptService;
    @GetMapping
    public Map<String, Object> deptList() {
    	
        return this.deptService.findDepts();
    }
    
    @PostMapping
    @RequiresPermissions("dept:add")
    public void addDept(@Valid Dept dept) throws SystemException {
        try {
            this.deptService.createDept(dept);
        } catch (Exception e) {
            message = "新增部门失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
}
