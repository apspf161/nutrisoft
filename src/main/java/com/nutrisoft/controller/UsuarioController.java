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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listPersons() {
		ModelAndView model = new ModelAndView("listaUsuario");
		model.addObject("listaUsuarios", usuarioService.listUsuarios());
		return model;
	}

	@RequestMapping(value= "/add", method = RequestMethod.POST)
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