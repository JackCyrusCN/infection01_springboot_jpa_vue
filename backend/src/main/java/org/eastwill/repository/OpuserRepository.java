package org.eastwill.repository;

import org.eastwill.domain.Opuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
@Transactional(timeout=15)
public interface OpuserRepository extends JpaRepository<Opuser, Long> {

	//按医生编号查询挂号医师
	@Query(value="select * from  opuser where seq = (SELECT coalesce(max(seq),0) FROM opuser where operator_code=:toperatorCode) ",nativeQuery=true)	
	public Opuser searchByOperatorCode(@Param("toperatorCode")String toperatorCode);
}
