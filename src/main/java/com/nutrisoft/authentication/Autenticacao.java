/**
	 * Furnas Centrais Elétricas S.A
	 * Divisão de Suporte ao Desenvolvimento de Sistemas de Informação
	 * Copyright (c) 2014 Todos os direitos reservados à Eletrobras Furnas S.A.
	 * 
	 * @author Wilson Fernandes 
	 * @since 12/01/2017
	 * @version 1.0
	 */

package com.nutrisoft.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Autenticacao {
	
	public User getUserDetails() {

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return user;

		/*
		 * System.out.println(userDetails.getPassword());
		 * System.out.println(userDetails.getUsername());
		 * System.out.println(userDetails.isEnabled()); Authorities
		 */
	}
	
	
	public Boolean isAutenticado() {
	
		boolean isAutenticado = false ; 
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		String username = authentication.getName();
		
		if ( ! username.isEmpty() || !username.equals("")) {
			
			isAutenticado = true;
		}
		
		return isAutenticado;
	}
	
	
	public String getMatricula() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		String username = authentication.getName();
				
		username = username.trim().toLowerCase().substring(2);
				
		return username;
	}
	
	
	
	public boolean hasRole(String role) {
		  @SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
		  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  boolean hasRole = false;
		  for (GrantedAuthority authority : authorities) {
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		}

}
