package com.wlf.home.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "UserFilter",urlPatterns = "/user/*")
@Slf4j
public class UserFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("UserFilter---------->>> init");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("UserFilter-------->>> doFilter");
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {
		log.info("UserFilter---------->>> destroy");
	}
}
