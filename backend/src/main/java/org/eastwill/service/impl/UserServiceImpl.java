package org.eastwill.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.eastwill.domain.User;
import org.eastwill.domain.UserConfig;
import org.eastwill.domain.UserRole;
import org.eastwill.repository.UserConfigRepository;
import org.eastwill.repository.UserRepository;
import org.eastwill.repository.UserRoleRepository;
import org.eastwill.repository.UserViewRepository;
import org.eastwill.service.UserConfigService;
import org.eastwill.service.UserService;
import org.eastwill.util.PasswordHelper;
import org.eastwill.views.UserView;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private UserViewRepository userViewRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private UserConfigRepository userConfigRepository;
    
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByUsername(account);
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.getUserByUserId(id);
    }

    @Override
    @Transactional
    public Long saveUser(User user) {

        PasswordHelper.encryptPassword(user);
        int index = new Random().nextInt(6) + 1;
        String avatar = "/static/user/user_" + index + ".png";

        user.setAvatar(avatar);
        return Long.valueOf(userRepository.save(user).getId());
    }


    @Override
    @Transactional
    public void updateUser(User user) {
    	User newUser = new User();
		newUser = updateUserInfo(user);
    	userRepository.saveAndFlush(newUser);
    }

    @Override
    @Transactional
    public void updateAvatar(String username, String avatar) {
    	User newUser = new User();
		newUser = updateUserAvator(username, avatar);
    	userRepository.saveAndFlush(newUser);
    }
    
    public User updateUserInfo (User user) {
    	Long userId = user.getUserId();
    	User newUser = userRepository.getUserByUserId(userId);
    	newUser.setEmail(user.getEmail());
    	newUser.setMobile(user.getMobile());
    	newUser.setDeptId(user.getDeptId());
    	newUser.setSsex(user.getSsex());
    	newUser.setDescription(user.getDescription());
    	return newUser;
    }
    
    public User updateUserAvator (String username, String avatar) {
    	User newUser = userRepository.findByUsername(username);
    	newUser.setAvatar(avatar);
    	return newUser;
    }
//    @Override
//    @Transactional
//    public void deleteUserById(Long id) {
//        userRepository.delete(id);
//    }


	@Override
	@Transactional
    public void updateLoginTime(String username) throws Exception {
        User user = new User();
        user = userRepository.findByUsername(username);
        user.setLastLoginTime(new Date());
        //this.baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        userRepository.save(user);
    }
	
	@Override
	public Page<User> findPageAll(Pageable pageable, User user) {
		//List<User> users = userRepository.findPageAll(pageable).getContent();
/*		for (User user : users) {
			System.out.println("userName:" + user.getUsername() + "userSsex:" + user.getSsex());
		}*/
		Example<User> example = Example.of(user);
		return userRepository.findAll(example, pageable);
	}
	
	@Override
	public UserView getUserInfoByUsername(String username) {
		// TODO Auto-generated method stub
		return userViewRepository.getUserViewByUsername(username);
	}
	
	public Page<UserView> findAllView(Pageable pageable, UserView user) {
		Example<UserView> example = Example.of(user);
		return userViewRepository.findAll(example, pageable);
	}

	@Override
	public Page<UserView> findUserView(Specification<UserView> spec, Pageable pageable) {
		return userViewRepository.findAll(spec, pageable);
	}
	
	@Override
	public Optional<User> findOne(Specification<User> spec) {
		return userRepository.findOne(spec);
	}
	
	@Override
    @Transactional
    public void createUser(User user) throws Exception {
        // 创建用户
        user.setCreateTime(new Date());
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(PasswordHelper.encrypt(user.getUsername(), User.DEFAULT_PASSWORD));
        userRepository.save(user);
        
        // 保存用户角色
        String[] roleIds = user.getRoleId().split(",");
        for (String roleId : roleIds) {
        	UserRole ur = new UserRole();
        	ur.setUserId(user.getUserId());
        	System.out.println("user.getRoleId(3)==>" + roleId);
        	ur.setRoleId(Long.valueOf(roleId));
        	userRoleRepository.saveAndFlush(ur);
        }
       
        // 创建用户默认的个性化配置
        userConfigService.initDefaultUserConfig(String.valueOf(user.getUserId()));
        // String.valueOf(user.getUserId()
    }
	
	@Override
    @Transactional
    public void deleteUsers(String[] userIds) throws Exception {
        List<String> list = Arrays.asList(userIds);
        for (String ids : list) {
        	Long id = Long.valueOf(ids);
        	// 删除角色
        	userRepository.deleteById(id);
        	 // 删除用户角色
        	List<UserRole> url = userRoleRepository.findUserRoleByUserId(id);
        	if (url.size() != 0) {
        		for (UserRole ur : url) {
            		userRoleRepository.delete(ur);
            	}
        	}
            //this.userRoleService.deleteUserRolesByUserId(userIds);
            // 删除用户个性化配置
            UserConfig uc = this.userConfigRepository.findByUserId(id);
            if (uc != null) {
            	this.userConfigRepository.delete(uc);
            }
        }
        
    }

	@Override
    @Transactional
	public void resetPassword(String[] userIds) throws Exception {
		for (String userId : userIds) {
			User newUser = userRepository.getUserByUserId(Long.valueOf(userId));
            newUser.setPassword(PasswordHelper.encrypt(newUser.getUsername(), User.DEFAULT_PASSWORD));
            userRepository.save(newUser);
        }
	}

	@Override
	public void updatePassword(String username, String password) throws Exception {
		User newUser = userRepository.findByUsername(username);
    	newUser.setPassword(PasswordHelper.encrypt(username, password));
    	userRepository.save(newUser);
	}
}
