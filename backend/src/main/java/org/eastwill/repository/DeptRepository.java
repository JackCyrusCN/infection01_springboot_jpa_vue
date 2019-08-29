package org.eastwill.repository;

import org.eastwill.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface DeptRepository extends JpaRepository<Dept, Long>{

	
}
