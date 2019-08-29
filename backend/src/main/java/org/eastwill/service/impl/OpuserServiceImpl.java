package org.eastwill.service.impl;

import java.util.List;

import org.eastwill.domain.Opuser;
import org.eastwill.repository.OpuserRepository;
import org.eastwill.service.OpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpuserServiceImpl implements OpuserService{
	
	@Autowired
	private OpuserRepository opuserRepository;

	@Override
	public List<Opuser> findAllOpusers() {
		// TODO Auto-generated method stub
		return opuserRepository.findAll();
	}
	
	
	
}
