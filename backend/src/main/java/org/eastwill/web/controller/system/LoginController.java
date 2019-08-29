package org.eastwill.web.controller.system;

import org.apache.commons.lang3.StringUtils;
import org.eastwill.authentication.JWTUtil;
import org.eastwill.domain.Response;
import org.eastwill.domain.User;
import org.eastwill.domain.UserConfig;
import org.eastwill.exception.SystemException;
import org.eastwill.service.MenuService;
import org.eastwill.service.RoleService;
import org.eastwill.service.UserConfigService;
import org.eastwill.service.UserService;
import org.eastwill.util.MD5Util;
import org.eastwill.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@Validated
public class LoginController {

    @Autowired
    private UserService userService;
	
    @Autowired 
    private UserConfigService userConfigService;
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private RoleService roleService;
	

    @PostMapping("/login")
    public Response loginOp(
    		@RequestBody String json) throws Exception {
    		//@RequestParam String username,@RequestParam String password) throws Exception {
            // @NotBlank(message = "{required}") String username, String password, HttpServletRequest request) throws Exception {
    	// password = MD5Util.encrypt(username, password);
    	System.out.println("JSON==>" + json);
    	JSONObject jsonInfo = (JSONObject) JSONObject.parse(json);
    	String username = jsonInfo.getString("username");
    	String password = jsonInfo.getString("password");
    	System.out.println("123==>" + username + password);
    	password = MD5Util.encrypt(username, password);
    	final String errorMessage = "用户名或密码错误";
        UserView user = userService.getUserInfoByUsername(username);
        if (user == null)
            throw new SystemException(errorMessage);
        if (!StringUtils.equals(user.getPassword(), password))
            throw new SystemException(errorMessage);
        if (User.STATUS_LOCK.equals(user.getStatus()))
            throw new SystemException("账号已被锁定,请联系管理员！");
        
        // 生成 Token
        String token = JWTUtil.sign(username, password);
        //test
        Map<String, Object> userInfo = this.generateOpuser(token, user);
        return new Response().message("认证成功").data(userInfo).code(200).timestamp(1566977728436L);
    }
    
    private Map<String, Object> generateOpuser(String token, UserView user) {
    	Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("token", token);
        UserConfig userConfig = userConfigService.findByUserId(user.getUserId());
        userInfo.put("config", userConfig);
        List<String> menu = menuService.findUserPermissions(user.getUsername());
        userInfo.put("permissions", menu);
        //System.out.println("menu==> " + menu);
        List<String> role = roleService.findUserRole(user.getUsername());
        userInfo.put("roles", role);
        userInfo.put("user", user);
        userInfo.put("exipreTime", "90190522120040");
        return userInfo;
    }
    
    @GetMapping("logout/{id}")
    public void logout(@NotBlank(message = "{required}") @PathVariable String id) throws Exception {
        //this.kickout(id);
    }
    
}
