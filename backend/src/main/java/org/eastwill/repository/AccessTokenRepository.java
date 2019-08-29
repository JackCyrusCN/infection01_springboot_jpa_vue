package org.eastwill.repository;

import org.eastwill.domain.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional(timeout=15)
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
	@Modifying
	//@Query(value="DELETE FROM access_token WHERE access_token=:taccess_token",nativeQuery=true)
	@Query(value="DELETE FROM access_token ;",nativeQuery=true)
	public int delAccessToken();
}
