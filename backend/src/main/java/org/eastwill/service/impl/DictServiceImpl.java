package org.eastwill.service.impl;

import org.eastwill.domain.Dict;
import org.eastwill.repository.DictRepository;
import org.eastwill.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictRepository dictRepository;
	
	@Override
	public Page<Dict> findPageAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return dictRepository.findAll(pageable);
	}

}
