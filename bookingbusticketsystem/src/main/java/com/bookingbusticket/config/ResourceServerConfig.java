package com.bookingbusticket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Value("${secure.resource.id}")
	private String resourceId;
	
	@Value("${unsecure.user.context.path}")
	private String unsecureUserContextPath;
	
	@Value("${unsecure.grant.token.action.path}")
	private String unsecureGrantTokenActionPath;
	
	@Value("${secure.admin.context.path}")
	private String secureAdminContextPath;
	
	@Value("${secure.admin.context.path}")
	private String secureStaffContextPath;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(resourceId).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, unsecureGrantTokenActionPath).permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, unsecureUserContextPath+"/**").permitAll();

		http.anonymous().disable().authorizeRequests()
				.antMatchers(secureStaffContextPath+"/**").access("hasRole('SELLER')")
				.antMatchers(secureAdminContextPath+"/**").access("hasRole('ADMIN')")
				.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}
