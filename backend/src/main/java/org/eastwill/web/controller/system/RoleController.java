package org.eastwill.web.controller.system;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.eastwill.pojo.QueryRequest;
import org.eastwill.service.RoleService;
import org.eastwill.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("role")
public class RoleController extends BaseController{

	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
    //@RequiresPermissions("role:view")
    public Map<String, Object> roleList(QueryRequest queryRequest) {
		int pageNum = queryRequest.getPageNum() - 1;
		int pageSize = queryRequest.getPageSize();
		Direction pageOrder = Sort.Direction.ASC;
		String pageField = "roleId";
		if (queryRequest.getSortOrder() != null && !queryRequest.getSortOrder().equals("undefined")) {
			if (queryRequest.getSortOrder().equals("ascend")) {
				pageOrder = Sort.Direction.ASC;
			}else {
				pageOrder = Sort.Direction.DESC;
			}
		}
		if  (queryRequest.getSortField() != null && !queryRequest.getSortField().equals("undefined")) {
			pageField = queryRequest.getSortField();
		}
		Sort sort = new Sort(pageOrder, pageField);
		System.out.println("sortAttribute==>" + pageOrder + "||" + queryRequest.getSortField());
		Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return getDataTable(roleService.findPageAll(pageable));
		//return null;
    }
}
