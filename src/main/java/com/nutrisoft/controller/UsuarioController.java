package com.nutrisoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listUsuarios() {
		ModelAndView model = new ModelAndView("usuario");
		model.addObject("usuario", new Usuario());
		model.addObject("usuarios", usuarioService.listUsuarios());
		return model;
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario, @RequestParam String senha) throws Exception{
		String senhaMD5 = Usuario.getSenhaMD5(senha);
		usuario.setSenha(senhaMD5);
		
		if (usuario.getIdPessoa() == null) {
			this.usuarioService.addUsuario(usuario);
		} else {
			this.usuarioService.updateUsuario(usuario);
		}
		
		return "redirect:/usuario";
	}

	@RequestMapping("/remove/{id}")
	public String removeUsuario(@PathVariable("id") int id){
		this.usuarioService.removeUsuario(id);
		return "redirect:/usuario";
	}

	@RequestMapping("/edit/{id}")
	public String editUsuario(@PathVariable("id") int id, Model model){
		model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
		return "usuario";
	}
}