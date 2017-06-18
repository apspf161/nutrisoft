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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.model.enums.PerfilEnum;
import com.nutrisoft.service.UsuarioService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();

		boolean usuarioAutenticadoNoDominio = true;

		try 
		{ 

			Usuario usuarioBanco = usuarioService.getUsuarioByLoginSenha(authentication.getName(), Usuario.getSenhaMD5(authentication.getCredentials().toString()));

			if (null != usuarioBanco) 
			{					

				if(usuarioBanco.getPerfil().equals(PerfilEnum.ATENDENTE.toString()))
				{
					updatedAuthorities.add(new SimpleGrantedAuthority("atendente"));
				}
				else if(usuarioBanco.getPerfil().equals(PerfilEnum.ADMINISTRADOR.toString()))
				{
					updatedAuthorities.add(new SimpleGrantedAuthority("administrador"));
				}
				else if(usuarioBanco.getPerfil().equals(PerfilEnum.NUTRICIONISTA.toString()))
				{
					updatedAuthorities.add(new SimpleGrantedAuthority("nutricionista"));
				}
			} 

			if(updatedAuthorities.size() == 0)
			{
				throw new BadCredentialsException("Usuário sem permissão.");
			}

			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(), updatedAuthorities);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new BadCredentialsException("Você não está Elegível a Adesão ao PAE ou tem permissão de acesso.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}