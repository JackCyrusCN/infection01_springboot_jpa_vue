package org.eastwill.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.eastwill.domain.DictHsp;
import org.eastwill.service.TokenService;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
@Service
public class TokenServiceImpl implements TokenService {
	//@Autowired
	//private DictHspRepository dictHspRepository;
	
	@Override
	public String getToken(DictHsp dictHsp) {
		String token="";
		LocalDate tldate = LocalDate.now().plusYears(1);
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = tldate.atStartOfDay(zoneId);
		Date tdate = Date.from(zdt.toInstant());
		
        token= JWT.create().withAudience(dictHsp.getHspCode()).withExpiresAt(tdate)// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(dictHsp.getHosKey()));// 以 password 作为 token 的密钥
        return token;
	}

}
