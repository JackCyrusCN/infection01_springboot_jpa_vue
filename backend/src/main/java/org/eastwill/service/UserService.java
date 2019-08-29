package org.eastwill.service;

import java.util.List;
import java.util.Optional;

import org.eastwill.domain.User;
import org.eastwill.views.UserView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author shimh
 * <p>
 * 2018�?1�?23�?
 */
public interface UserService {

    List<User> findAll();

    User getUserByAccount(String account);

    User getUserById(Long id);

    Long saveUser(User user);

    void updateUser(User user);
    
    void updateAvatar(String username, String avatar);

//    void deleteUserById(Long id);
    
    void updateLoginTime(String username) throws Exception;
    
    Page<User> findPageAll(Pageable pageable, User user);
        
    UserView getUserInfoByUsername(String username);
    
    Page<UserView>  findAllView(Pageable pageable, UserView user);
    
    Page<UserView> findUserView(Specification<UserView> spec, Pageable pageable);
    
    Optional<User> findOne(Specification<User> spec);
    
    void createUser(User user) throws Exception ;
    
    void deleteUsers (String[] userIds) throws Exception;
    
    public void resetPassword(String[] usernames) throws Exception;
    
    public void updatePassword(String username, String password) throws Exception;
}
