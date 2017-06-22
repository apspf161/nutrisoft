package com.nutrisoft.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class MyWebAuthDets extends WebAuthenticationDetails {
	private static final long serialVersionUID = 1L;

	public MyWebAuthDets(HttpServletRequest request) {
		super(request);
	}
}