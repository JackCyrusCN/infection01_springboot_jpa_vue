package org.eastwill.repository;

import org.eastwill.views.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface UserViewRepository extends JpaRepository<UserView, Long>, JpaSpecificationExecutor<UserView>{
	
	@Query(value = "select * from user_view where username = ?1", nativeQuery = true)
	UserView getUserViewByUsername(String username);
}
