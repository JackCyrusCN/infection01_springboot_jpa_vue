package org.eastwill.repository;

import java.util.List;

import org.eastwill.domain.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface UserConfigRepository extends JpaRepository<UserConfig, Long>{
	
	@Query(value = "select * from t_user_config where user_id = ?1", nativeQuery = true)
	UserConfig findByUserId(Long id);
}
