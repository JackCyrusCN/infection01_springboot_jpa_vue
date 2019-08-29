package org.eastwill;

import javax.servlet.ServletContextListener;

import org.eastwill.properties.SystemProperties;
import org.eastwill.servlet.WeixinServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(SystemProperties.class)
public class WxsrvApplication {
	//@Autowired
	//private DataSource primaryDataSource;
	//@Bean
	//public JdbcTemplate jdbcTemplate() {
	//	return new JdbcTemplate(primaryDataSource);
	//}
	
	public static void main(String[] args) {
		SpringApplication.run(WxsrvApplication.class, args);
	}


}
