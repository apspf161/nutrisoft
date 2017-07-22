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

		try 
		{ 

			Usuario usuarioBanco = usuarioService.getUsuarioByLoginSenha(authentication.getName(), Usuario.getSenhaMD5(authentication.getCredentials().toString()));

			if (null != usuarioBanco) 
			{					

				if(usuarioBanco.getPerfil().equals(PerfilEnum.ATENDENTE))
				{
					updatedAuthorities.add(new SimpleGrantedAuthority("atendente"));
				}
				else if(usuarioBanco.getPerfil().equals(PerfilEnum.ADMINISTRADOR))
				{
					updatedAuthorities.add(new SimpleGrantedAuthority("administrador"));
				}
				else if(usuarioBanco.getPerfil().equals(PerfilEnum.NUTRICIONISTA))
				{
					updatedAuthorities.add(new SimpleGrantedAuthority("atendente"));
					updatedAuthorities.add(new SimpleGrantedAuthority("nutricionista"));
				}
			} 

			if(updatedAuthorities.size() == 0)
			{
				throw new BadCredentialsException("Usuário sem acesso.");
			}

			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(), updatedAuthorities);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new BadCredentialsException("Usuário inexistente.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}