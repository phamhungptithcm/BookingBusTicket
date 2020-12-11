package com.bookingbusticket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	@Value("${secure.client.id}")
	private String clientId;
	
	@Value("${secure.client.secret}")
	private String clientSecret;
	
	@Value("${secure.grant.type.password}")
	private String grantType;
	
	@Value("${secure.authorization.code}")
	private String authorizationCode;
	
	@Value("${secure.refresh.token}")
	private String refreshToken;
	
	@Value("${secure.implicit}")
	private String implicit;
	
	@Value("${secure.scope.read}")
	private String scopeRead;
	
	@Value("${secure.scope.write}")
	private String scopeWrite;
	
	@Value("${secure.trust}")
	private String trust;
	
	@Value("${secure.access.token.validity.seconds}")
	private int accessTokenValiditySeconds;
	
	@Value("${secure.refresh.token.validity.seconds}")
	private int refreshTokenValiditySeconds;
	
	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer
				.inMemory()
				.withClient(clientId)
				.secret(clientSecret)
				.authorizedGrantTypes(grantType, authorizationCode, refreshToken, implicit )
				.scopes(scopeRead, scopeWrite, trust)
				.accessTokenValiditySeconds(accessTokenValiditySeconds)
				.refreshTokenValiditySeconds(refreshTokenValiditySeconds);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
	}
}
