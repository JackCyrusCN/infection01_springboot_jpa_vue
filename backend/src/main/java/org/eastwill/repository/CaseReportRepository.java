package org.eastwill.repository;

import org.eastwill.domain.Opuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.eastwill.domain.infection.CaseReport;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface CaseReportRepository extends JpaRepository<CaseReport, String> {

	//按患者号检索院感病历
	@Query(value="select * from  case_report where pid = ?1) ",nativeQuery=true)	
	public Opuser searchByPid(String pid);
	
//	@Modifying
//	@Query(value="insert into case_report(seq, pid, patient_name, gender, age, age_unit, admission_time, admission_diag_code, admission_diag_name, infection_time, infection_diag_code, "
//			+ "infection_diag_name, etiologic_ex, etiologic_spec_name, pathogen_code, pathogen_name, pre_factor, pre_factor_else, remark, op_code, op_depid, op_time) "
//			+ "values (?,?,?,)", nativeQuery=true)
//	public void saveCaseReport(CaseReport caseReport);
}
