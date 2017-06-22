package com.nutrisoft.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nutrisoft.model.Usuario;

@Controller
public class EntradaController {

	//A annotation RequestMapping é utilizada para mapear uma url no browser 
	//para um método. Mapeamos a url http://localhost:8090/nutrisoft/ via get para este método
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView logarSistema(@ModelAttribute("usuario") Usuario usuario) {
		return new ModelAndView("logar");
	}

	@RequestMapping(value = "/logar", method = RequestMethod.GET)
	public ModelAndView logar(@RequestParam(value = "error", required = false) String error, 
			@RequestParam(value = "logout", required = false) String logout) throws Exception {
		
		ModelAndView model = new ModelAndView("logar");

		if (error != null) {
			model.addObject("error", "Erro ao logar no sistema");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		return model;
	}

	@RequestMapping(value = "/trocarSenha", method = RequestMethod.GET)
	public String trocarSenha() {
		return "trocarSenha";
	}

	@RequestMapping(value = "/novaSenha", method = RequestMethod.GET)
	public String novaSenha() {
		return "novaSenha";
	}

	@RequestMapping(value = "/logar/menu", method = { RequestMethod.GET })
	public ModelAndView menu() {
		String mav = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		if(authorities.contains(new SimpleGrantedAuthority("administrador")))
		{
			mav = "redirect:/usuario/";
		}
		else if(authorities.contains(new SimpleGrantedAuthority("atendente")))
		{
			mav = "redirect:/usuario/";
		}
		else 
		{
			mav = "redirect:/usuario/";
		}	

		ModelAndView model = new ModelAndView(mav);
		return model;
	}		

/*			if(usuario.getPerfil().equals(PerfilEnum.ADMINISTRADOR)){
				return "redirect:/menuAdministrador";	
			} else if(usuario.getPerfil().equals(PerfilEnum.ATENDENTE)){
				return "redirect:/menuAtendente";
			}else{
				return "redirect:/menuNutricionista";
			}
*/
}