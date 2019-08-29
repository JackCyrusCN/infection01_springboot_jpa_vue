package org.eastwill.authentication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.eastwill.domain.Opuser;
import org.eastwill.domain.User;
import org.eastwill.service.MenuService;
import org.eastwill.service.OpuserService;
import org.eastwill.service.RoleService;
import org.eastwill.service.UserService;
import org.eastwill.util.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义实现 ShiroRealm，包含认证和授权两大模块
 *
 * @author MrBird
 */
public class ShiroRealm extends AuthorizingRealm {

	
	@Autowired
    private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	
	
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * `
     * 授权模块，获取用户角色和权限
     *
     * @param token token
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
        String username = JWTUtil.getUsername(token.toString());
        //Opuser user = SystemUtils.getOpuser(username);
        User user = userService.getUserByAccount(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集（模拟值，实际从数据库获取）
        //simpleAuthorizationInfo.setRoles(user.getRole());
        Set<String> rolesSet = new HashSet<String>();
        //rolesSet.add("admin");
        List<String> roles = roleService.findUserRole(user.getUsername());
        for (String role : roles) {
        	rolesSet.add(role);
        }
        Set<String> permSet = new HashSet<String>();
        //permSet.add("user:add");
        //permSet.add("user:view");
        List<String> perms = menuService.findUserPermissions(user.getUsername());
        for (String perm : perms) {
        	permSet.add(perm);
        }
        simpleAuthorizationInfo.setRoles(rolesSet);
        
        // 获取用户权限集（模拟值，实际从数据库获取）
        simpleAuthorizationInfo.setStringPermissions(permSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param authenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的，已经经过了解密
        String token = (String) authenticationToken.getCredentials();

        String username = JWTUtil.getUsername(token);

        if (StringUtils.isBlank(username))
            throw new AuthenticationException("token校验不通过");

        // 通过用户名查询用户信息
        //Opuser user = SystemUtils.getOpuser(username);
        User user = userService.getUserByAccount(username);
        

        if (user == null)
            throw new AuthenticationException("用户名或密码错误");
        if (!JWTUtil.verify(token, username, user.getPassword()))
            throw new AuthenticationException("token校验不通过");
        return new SimpleAuthenticationInfo(token, token, "shiro_realm");
    }
}
