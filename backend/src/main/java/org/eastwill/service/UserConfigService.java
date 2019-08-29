package org.eastwill.service;

import org.eastwill.domain.UserConfig;

public interface UserConfigService {

	UserConfig findByUserId(Long userId);
	
	void update(UserConfig userConfig) throws Exception;
	
	void initDefaultUserConfig(String userId);
}
