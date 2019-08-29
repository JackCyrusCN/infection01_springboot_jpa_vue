package org.eastwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.eastwill.domain.User;

/**
 * @author shimh
 * <p>
 * 2018�?1�?23�?
 */

@Transactional(timeout=15)
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{  //, JpaSpecificationExecutor<User>

	@Query(value = "select * from t_user where username = ?1", nativeQuery = true) //
    User findByUsername(String username);
    
//	@Query(value = "select t.user_id as userId, t.username, t.password, t.dept_id as deptId, " +
//			"t.email, t.mobile, t.status, t.modify_time as modifyTime, t.last_login_time as lastLoginTime, " +
//			"t.ssex, t.description, t.avatar, t.create_time as createTime, t.real_name as realName, " +
//			"a.role_id as roleId,b.role_name as roleName,c.dept_name as deptName from t_user t " + 
//			"left join t_user_role a on a.user_id = t.user_id " + 
//			"left join t_role b on b.role_id = a.role_id " + 
//			"left join t_dept c on c.dept_id = t.dept_id " + 
//			"where username = ?1", nativeQuery = true) //select * from t_user where username = ?1
//    UserInfo findByUsernameInfo(String username);
	
	@Query(value = "select * from t_user where user_id = (select coalesce(max(t.user_id),0) from t_user t where t.user_id = ?1)", nativeQuery = true)
	User getUserByUserId (Long userId);
	
	

    //@Query(value = "select account from sys_user where ", nativeQuery = true)
	
//	@Query(value = "select * from t_user",
//			countQuery = "select count(*) from t_user ",
//			nativeQuery = true)
//	Page<User> findPageAll(Pageable pageable, );
}
