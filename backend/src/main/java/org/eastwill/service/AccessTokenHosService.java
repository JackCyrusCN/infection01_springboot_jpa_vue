package org.eastwill.service;

import java.util.List;

import org.eastwill.domain.AccessTokenHos;


public interface AccessTokenHosService {
     //查询access_token
	public List<AccessTokenHos> searchAccessToken();
	 //删除access_token
	public void delToken();
	 //写入access_token
	 public AccessTokenHos saveToken(AccessTokenHos ttoken);
}
