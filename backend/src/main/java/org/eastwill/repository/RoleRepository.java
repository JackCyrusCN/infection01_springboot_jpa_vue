package org.eastwill.repository;

import java.util.List;

import org.eastwill.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	//@Query(value = "select * from t_role where role_id = (select role_id from t_user_role = 1?)", nativeQuery = true)
	@Query(value = "select r.role_name from t_role r left join t_user_role ur on (r.role_id = ur.role_id) left join t_user u on (u.user_id = ur.user_id) where u.username = ?1", nativeQuery = true)
	List<String> findUserRole(String username);
	
//	@Query(value = "select * from t_role",
//			countQuery = "select count(*) from t_role ",
//			nativeQuery = true)
//	Page<Role> findPageAll(Pageable pageable);
}
