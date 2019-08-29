package org.eastwill.repository;


import java.util.List;

import org.eastwill.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout = 15)
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	@Query(value = "select * from t_user_role where user_id = ?1", nativeQuery = true)
	List<UserRole> findUserRoleByUserId(Long userId);
}
