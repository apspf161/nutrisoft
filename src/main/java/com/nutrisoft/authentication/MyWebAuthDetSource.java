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

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;

public class MyWebAuthDetSource implements AuthenticationDetailsSource<HttpServletRequest, MyWebAuthDets> {
	  public MyWebAuthDets buildDetails (HttpServletRequest context) {
	    return new MyWebAuthDets(context);
	  }
	}