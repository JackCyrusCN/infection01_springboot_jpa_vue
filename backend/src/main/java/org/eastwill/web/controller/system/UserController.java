package org.eastwill.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.eastwill.domain.Response;
import org.eastwill.domain.User;
import org.eastwill.domain.UserConfig;
import org.eastwill.exception.SystemException;
import org.eastwill.pojo.QueryRequest;
import org.eastwill.service.MenuService;
import org.eastwill.service.UserConfigService;
import org.eastwill.service.UserService;
import org.eastwill.util.PasswordHelper;
import org.eastwill.views.UserView;
import org.eastwill.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

	private String message;
	@Autowired
	private UserConfigService userConfigService;
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	
	@GetMapping("check/{username}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username) {
		Specification<User> spec = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(cb.equal(root.get("username"), username));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		if (userService.findOne(spec).hashCode() == 0) {
			return true;
		}
		return false;
        //return this.userService.findByName(username) == null;
    }
	
	@PutMapping("/userconfig")
    public void updateUserConfig(@Valid UserConfig userConfig) throws SystemException {
        try {
            this.userConfigService.update(userConfig);
        } catch (Exception e) {
        	log.error("修改个人配置失败",e);
        }
    }
	
	@PutMapping("profile")
    public void updateProfile(@Valid User user) throws SystemException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            message = "修改个人信息失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
	
	@PutMapping("avatar")
    public void updateAvatar(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String avatar) throws SystemException {
        try {
            this.userService.updateAvatar(username, avatar);
        } catch (Exception e) {
            message = "修改头像失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
	
	@GetMapping("/{username}")
	public User detail(@NotBlank(message = "{required}") @PathVariable String username) {
		return this.userService.getUserByAccount(username);
	}
	
	@GetMapping
    @RequiresPermissions("user:view")
    public Map<String, Object> userList(QueryRequest queryRequest, UserView user) {
		int pageNum = queryRequest.getPageNum() - 1;
		int pageSize = queryRequest.getPageSize();
		Direction pageOrder = Sort.Direction.ASC;
		String pageField = "deptId";
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
		Pageable pageable = new PageRequest(pageNum, pageSize, sort);
		
		Specification<UserView> spec = new Specification<UserView>() {
			@Override
			public Predicate toPredicate(Root<UserView> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (StringUtils.isNotBlank(user.getCreateTimeFrom())) {
					predicates.add(cb.greaterThanOrEqualTo(root.get("createTime").as(String.class), user.getCreateTimeFrom()));
				}
				if (StringUtils.isNotBlank(user.getCreateTimeTo())) {
					predicates.add(cb.lessThanOrEqualTo(root.get("createTime").as(String.class), user.getCreateTimeTo()));
				}
				if (StringUtils.isNotBlank(user.getUsername())) {
					predicates.add(cb.like(root.get("username").as(String.class), "%" + user.getUsername() + "%"));
				}
				if (StringUtils.isNotBlank(user.getSsex())) {
					predicates.add(cb.equal(root.get("ssex").as(String.class), user.getSsex()));
				}
				if (StringUtils.isNotBlank(user.getStatus())) {
					predicates.add(cb.equal(root.get("status").as(String.class), user.getStatus()));
				}
				Predicate preOr = null;
				if (user.getDeptId() != null) {
					Path<Object> deptId = root.get("deptId");
					Path<Object> parentId = root.get("parentId");
					Predicate pr1 = cb.equal(deptId, user.getDeptId());
					Predicate pr2 = cb.equal(parentId, user.getDeptId());
					preOr = cb.or(pr1, pr2);
					//predicates.add(cb.equal(root.get("deptId"), user.getDeptId()));
				}
				Predicate preAnd =  cb.and(predicates.toArray(new Predicate[predicates.size()]));
				if (preOr != null) {
					return query.where(preOr, preAnd).getRestriction();
				}else {
					return cb.and(predicates.toArray(new Predicate[predicates.size()]));
				}
				
			} 
		};
		
		return getDataTable(userService.findUserView(spec, pageable));
		//System.out.println("ssssssssssssss===");
		//List<User> lists= userService.findAll1();
		//System.out.println("zzzzzzzzzzzzzz===" + lists.toString());
//		for (User u1 : lists) {
//			System.out.println("size==>" + u1.getRoles().size());
//			System.out.println("role:" + u1.getRoles());
//			System.out.println("role.toString:" + u1.getRoles().toString());
//		}
//		Page<User> pUser = userService.findPageAll(pageable, user);
//		Page<User> nUser = null;
//		for (User u : pUser.getContent()) {
//			String tRoldId = "";
//			String tRoleName = "";
//			for(Role r : u.getRoles()) {
//				tRoldId = tRoldId + r.getRoleId().toString() + ",";
//				tRoleName = tRoleName + r.getRoleName() + ",";
//			}
//			u.setRoleId(tRoldId);
//			u.setRoleName(tRoleName);
//		}
		//System.out.println("order=>" + pageOrder + ", field=>" + pageField);
		//return null;
        //return getDataTable(userService.findAllView(pageable, user));
		//return null;
    }
	
    @PostMapping
    @RequiresPermissions("user:add")
    public void addUser(@Valid User user) throws SystemException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            message = "新增用户失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
    
    @PutMapping
    @RequiresPermissions("user:update")
    public void updateUser(@Valid User user) throws SystemException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            message = "修改用户失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
    
    @DeleteMapping("/{userIds}")
    @RequiresPermissions("user:delete")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws SystemException {
        try {
            String[] ids = userIds.split(",");
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            message = "删除用户失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
    
    @PutMapping("password/reset")
    @RequiresPermissions("user:reset")
    public void resetPassword(@NotBlank(message = "{required}") String userIds) throws SystemException {
        try {
            String[] userIdArr = userIds.split(",");
            this.userService.resetPassword(userIdArr);
        } catch (Exception e) {
            message = "重置用户密码失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
    
    @GetMapping("password/check")
    public boolean checkPassword(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) {
        String encryptPassword = PasswordHelper.encrypt(username, password);
        User user = userService.getUserByAccount(username);
        if (user != null)
            return StringUtils.equals(user.getPassword(), encryptPassword);
        else
            return false;
    }

    @PutMapping("password")
    public void updatePassword(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws SystemException {
        try {
            userService.updatePassword(username, password);
        } catch (Exception e) {
            message = "修改密码失败";
            log.error(message, e);
            throw new SystemException(message);
        }
    }
    
    @GetMapping("info")
    public Response userInfo() {
    	String permissionList = menuService.findUserPermissions("admin").toString();
    	String actionList = menuService.findUserActions("admin").toString();
    	System.out.println("per==>" + permissionList);
    	Object userInfo = new Object();
    	String userInfos = "{" + 
    			"'id': '4291d7da9005377ec9aec4a71ea837f'," + 
    			"'name': '院感管理员'," + 
    			"'username': 'admin'," + 
    			"'password': ''," + 
    			"'avatar': '/avatar2.jpg'," + 
    			"'status': 1," + 
    			"'telephone': ''," + 
    			"'lastLoginIp': '27.154.74.117'," + 
    			"'lastLoginTime': 1534837621348," + 
    			"'creatorId': 'admin'," + 
    			"'createTime': 1497160610259," + 
    			"'merchantCode': 'TLif2btpzg079h15bk'," + 
    			"'deleted': 0," + 
    			"'roleId': 'admin'," + 
    			"'role': {" + 
    			"'id': 'admin'," + 
    			"'name': '管理员'," + 
    			"'describe': '拥有所有权限'," + 
    			"'status': 1," + 
    			"'creatorId': 'system'," + 
    			"'createTime': 1497160610259," + 
    			"'deleted': 0," + 
    			"'actionList': " + actionList + 
    			",\"permissionList\": " + permissionList + 
    			" } }";
    	System.out.println("userInfo==>" + userInfos);
    	userInfo = JSON.parseObject(userInfos);
    	return new Response().message("认证成功").data(userInfo).code(200).timestamp(1566977728436L);
    }
}
