package com.bookingbusticket.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	@Value("${secure.cors.filter.allow.origin}")
	private String allowOrigin;
	
	@Value("${secure.cors.filter.allow.method}")
	private String allowMehtod;
	
	@Value("${secure.cors.filter.max.age}")
	private String filterMaxAge;
	
	@Value("${secure.cors.filter.allow.headers}")
	private String allowHeaders;
	
	private static final String ALLOW_ORIGIN_LABEL="Access-Control-Allow-Origin";
	private static final String ALLOW_MEHTOD_LABEL="Access-Control-Allow-Methods";
	private static final String ALLOW_HEADERS_LABEL="Access-Control-Allow-Headers";
	private static final String FILTER_MAXAGE_LABEL="Access-Control-Max-Age";
	
	public CorsFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;

		res.setHeader(ALLOW_ORIGIN_LABEL, allowOrigin);
		res.setHeader(ALLOW_MEHTOD_LABEL, allowMehtod);
		res.setHeader(FILTER_MAXAGE_LABEL, filterMaxAge);
		res.setHeader(ALLOW_HEADERS_LABEL, allowHeaders);

		if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
			res.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}
}
