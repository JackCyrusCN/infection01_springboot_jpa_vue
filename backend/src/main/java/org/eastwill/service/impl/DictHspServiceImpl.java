package org.eastwill.service.impl;

import org.eastwill.domain.DictHsp;
import org.eastwill.repository.DictHspRepository;
import org.eastwill.service.DictHspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DictHspServiceImpl implements DictHspService {
	@Autowired
	private DictHspRepository dictHspRepository;
	
	@Override
	public DictHsp searchDictHsp() {
		return dictHspRepository.searchDictHsp();
	}

	@Override
	public DictHsp searchByHoskey(String thoskey) {
		return dictHspRepository.searchByHoskey(thoskey);
	}

}
