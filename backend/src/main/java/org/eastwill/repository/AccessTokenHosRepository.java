package org.eastwill.repository;

import org.eastwill.domain.AccessTokenHos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional(timeout=15)
public interface AccessTokenHosRepository extends JpaRepository<AccessTokenHos, String> {
	@Modifying
	@Query(value="DELETE FROM access_token_hos",nativeQuery=true)
	public int delAccessToken();
}
