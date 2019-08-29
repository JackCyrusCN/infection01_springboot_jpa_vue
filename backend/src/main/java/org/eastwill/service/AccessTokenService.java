package org.eastwill.service;

import java.util.List;

import org.eastwill.domain.AccessToken;


public interface AccessTokenService {
     //查询access_token
	public List<AccessToken> searchAccessToken();
	 //删除access_token
	public void delToken();
	 //写入access_token
	 public AccessToken saveToken(AccessToken ttoken);
}
