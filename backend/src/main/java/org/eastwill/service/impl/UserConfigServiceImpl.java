package org.eastwill.service.impl;

import org.eastwill.domain.UserConfig;
import org.eastwill.repository.UserConfigRepository;
import org.eastwill.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserConfigServiceImpl implements UserConfigService{

	@Autowired
	private UserConfigRepository userConfigRepository;
	
	@Override
	public UserConfig findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userConfigRepository.findByUserId(Long.valueOf(userId));
	}

	@Override
    @Transactional
    public void update(UserConfig userConfig) throws Exception {
        //baseMapper.updateById(userConfig);
        userConfigRepository.saveAndFlush(userConfig);
        //cacheService.saveUserConfigs(String.valueOf(userConfig.getUserId()));
    }
	
	@Override
    @Transactional
	public void initDefaultUserConfig(String userId) {
		UserConfig userConfig = new UserConfig();
        userConfig.setUserId(Long.valueOf(userId));
        userConfig.setColor(UserConfig.DEFAULT_COLOR);
        userConfig.setFixHeader(UserConfig.DEFAULT_FIX_HEADER);
        userConfig.setFixSiderbar(UserConfig.DEFAULT_FIX_SIDERBAR);
        userConfig.setLayout(UserConfig.DEFAULT_LAYOUT);
        userConfig.setTheme(UserConfig.DEFAULT_THEME);
        userConfig.setMultiPage(UserConfig.DEFAULT_MULTIPAGE);
        userConfigRepository.saveAndFlush(userConfig);
	}
}
