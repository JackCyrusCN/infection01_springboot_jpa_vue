package org.eastwill.service;

import org.eastwill.domain.Opuser;
import org.eastwill.domain.infection.CaseReport;

public interface CaseReportService {

	public String saveCaseReport(CaseReport caseReport);
	
	public Opuser searchByPid(String pid);
}
