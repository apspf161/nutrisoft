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

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
 
    private static final long serialVersionUID = 1L;
 
    private String role;
 
    public GrantedAuthorityImpl(String role) {
        this.role = role;
    }
 
    public String getAuthority() {
        return role;
    }
}