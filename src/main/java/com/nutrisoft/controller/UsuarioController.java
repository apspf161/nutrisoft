package com.nutrisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/usuario/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("usuario") Usuario usuario) {
		return "login";
	}
	
	//Mapeamos a url http://localhost:8090/nutrisoft/usuario/login via post 
	//para este método que:
	//Tenta obter um usuario do banco com o login e senha informados
	//Se existir exibe a tela principal
	//Se náo existir, exibe novamente a tela de login
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public String validarLogin(@ModelAttribute("usuario") Usuario usuario) {
		Usuario usuarioBanco = usuarioService.getUsuarioByLoginSenha(usuario.getLogin(), usuario.getSenha());
		if (usuarioBanco != null) { 
			return "principal";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioService.listUsuarios());
		return "usuario";
	}
	
//	//For add and update person both
//	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
//	public String addPerson(@ModelAttribute("person") Person p){
//		
//		if(p.getId() == 0){
//			//new person, add it
//			this.personService.addPerson(p);
//		}else{
//			//existing person, call update
//			this.personService.updatePerson(p);
//		}
//		
//		return "redirect:/persons";
//		
//	}
//	
//	@RequestMapping("/remove/{id}")
//    public String removePerson(@PathVariable("id") int id){
//		
//        this.personService.removePerson(id);
//        return "redirect:/persons";
//    }
// 
//    @RequestMapping("/edit/{id}")
//    public String editPerson(@PathVariable("id") int id, Model model){
//        model.addAttribute("person", this.personService.getPersonById(id));
//        model.addAttribute("listPersons", this.personService.listPersons());
//        return "person";
//    }	
}