package org.eastwill.service.impl;

import java.util.List;

import org.eastwill.domain.AccessTokenHos;
import org.eastwill.repository.AccessTokenHosRepository;
import org.eastwill.service.AccessTokenHosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccessTokenHosServiceImpl implements AccessTokenHosService {
	@Autowired
	private AccessTokenHosRepository accessTokenHosRepository;
	
	public AccessTokenHosServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AccessTokenHos> searchAccessToken() {
		return accessTokenHosRepository.findAll();
	}

	@Override
	public void delToken() {
		accessTokenHosRepository.delAccessToken();
	}

	@Override
	public AccessTokenHos saveToken(AccessTokenHos ttoken) {
		return accessTokenHosRepository.saveAndFlush(ttoken);

	}

}
