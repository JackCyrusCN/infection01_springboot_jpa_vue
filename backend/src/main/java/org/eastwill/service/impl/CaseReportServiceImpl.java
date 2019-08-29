package org.eastwill.service.impl;

import org.eastwill.domain.Opuser;
import org.eastwill.domain.infection.CaseReport;
import org.eastwill.repository.CaseReportRepository;
import org.eastwill.service.CaseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseReportServiceImpl implements CaseReportService{

	@Autowired
	private CaseReportRepository caseReportRepository;
	
	@Override
	public String saveCaseReport(CaseReport caseReport) {
		// TODO Auto-generated method stub
		String tseq = caseReportRepository.saveAndFlush(caseReport).getSeq().toString();
		System.out.println("tseq");
		return tseq;
	}

	@Override
	public Opuser searchByPid(String pid) {
		return caseReportRepository.searchByPid(pid);
	}
}
