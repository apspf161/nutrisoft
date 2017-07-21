package com.nutrisoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nutrisoft.authentication.Autenticacao;
import com.nutrisoft.model.Usuario;
import com.nutrisoft.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

//	private Autenticacao autenticacao;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listPersons() {

	/*	if (autenticacao.isAutenticado() == false) {
			return new ModelAndView("logar");
		}
*/
		ModelAndView model = new ModelAndView("listaUsuario");
		model.addObject("listaUsuarios", usuarioService.listUsuarios());
		return model;
	}

	@RequestMapping(value = "/cadUsuario", method = RequestMethod.GET)
	public ModelAndView cadUsuario() {

/*		if (autenticacao.isAutenticado() == false) {
			return new ModelAndView("logar");
		}
*/		
		ModelAndView model = new ModelAndView("usuario");
		model.addObject("usuario", new Usuario());
		return model;
	}

	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("usuario") Usuario usuario, @RequestParam String senha) throws Exception{

/*		if (autenticacao.isAutenticado() == false) {
			return new ModelAndView("logar");
		}
*/		
		String senhaMD5 = Usuario.getSenhaMD5(senha);
		usuario.setSenha(senhaMD5);
		
		if(usuario.getIdPessoa() == null){
			//new person, add it
			this.usuarioService.addUsuario(usuario);
		}else{
			//existing person, call update
			this.usuarioService.updateUsuario(usuario);
		}

		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/remove/{id}")
	public ModelAndView removePerson(@PathVariable("id") int id){

/*		if (autenticacao.isAutenticado() == false) {
			return new ModelAndView("logar");
		}
*/
		this.usuarioService.removeUsuario(id);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editPerson(@PathVariable("id") int id){

/*		if (autenticacao.isAutenticado() == false) {
			return new ModelAndView("logar");
		}
*/
		ModelAndView model = new ModelAndView("usuario");
		model.addObject("usuario", this.usuarioService.getUsuarioById(id));
		return model;
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}