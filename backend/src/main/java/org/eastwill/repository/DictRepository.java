package org.eastwill.repository;

import org.eastwill.domain.Dict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface DictRepository extends JpaRepository<Dict, Long>{

//	@Query(value = "select * from t_dict",
//			countQuery = "select count(*) from t_dict ",
//			nativeQuery = true)
//	Page<Dict> findPageAll(Pageable pageable);
}
