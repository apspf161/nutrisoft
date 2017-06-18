package com.nutrisoft.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	//A annotation RequestMapping é utilizada para mapear uma url no browser 
	//para um método.
	//Mapeamos a url http://localhost:8090/nutrisoft/usuario/login via get 
	//para este método
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(@ModelAttribute("usuario") Usuario usuario) {
		return "login";
	}

	@RequestMapping(value = "/trocarSenha", method = RequestMethod.GET)
	public String trocarSenha() {
		return "trocarSenha";
	}

	@RequestMapping(value = "/novaSenha", method = RequestMethod.GET)
	public String novaSenha() {
		return "novaSenha";
	}
	
	
/*	@RequestMapping(value = "/entrada/menu", method = { RequestMethod.GET })
	public ModelAndView menu() {
		String mav = "/entrada";
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		boolean authorized = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

		if(authorities.contains(new SimpleGrantedAuthority("elegivel")))
		{
			mav = "redirect:/interno/adesao/simulacao";

		}
		else
		{
			mav = "redirect:/interno/prc/prc";
		}	
		*//**
		 *  Redirecionar usuario com acesso sem ACL para tela especifica
		 *//*
		ModelAndView model = new ModelAndView(mav);
	
		return model;
	}		
*/

	//Mapeamos a url http://localhost:8090/nutrisoft/usuario/login via post 
	//para este método que:
	//Tenta obter um usuario do banco com o login e senha informados
	//Se existir exibe a tela principal
	//Se não existir, exibe novamente a tela de login
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public String validarLogin(@ModelAttribute("usuario") Usuario usuario) throws Exception {

		Usuario usuarioBanco = usuarioService.getUsuarioByLoginSenha(usuario.getLogin(), Usuario.getSenhaMD5(usuario.getSenha()));

		if (usuarioBanco != null) { 
			return "redirect:/menu";
		} else {
			return "login2";
		}
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioService.listUsuarios());
		return "usuario";	}

	@RequestMapping(value= "/usuario/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("usuario") Usuario usuario, @RequestParam String senha) throws Exception{

		String senhaMD5 = Usuario.getSenhaMD5(senha);
		usuario.setSenha(senhaMD5);
		
		if(usuario.getIdPessoa() == null){
			//new person, add it
			this.usuarioService.addUsuario(usuario);
		}else{
			//existing person, call update
			this.usuarioService.updateUsuario(usuario);
		}

		return "redirect:/usuarios";
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		this.usuarioService.removeUsuario(id);
		return "redirect:/usuarios";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model){
		model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
		return "usuario";
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


}