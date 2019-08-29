package org.eastwill.service.impl;

import java.util.List;

import org.eastwill.domain.AccessToken;
import org.eastwill.repository.AccessTokenRepository;
import org.eastwill.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccessTokenServiceImpl implements AccessTokenService {
	@Autowired
	private AccessTokenRepository accessTokenRepository;
	
	public AccessTokenServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AccessToken> searchAccessToken() {
		return accessTokenRepository.findAll();
	}

	@Override
	public void delToken() {
		accessTokenRepository.delAccessToken();
	}

	@Override
	public AccessToken saveToken(AccessToken ttoken) {
		return accessTokenRepository.saveAndFlush(ttoken);

	}

}
