package com.nutrisoft.controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView menuAdministrador() {
		return new ModelAndView("principal");
	}
	
	@RequestMapping(value = "/listaUsuario", method = RequestMethod.GET)
	public ModelAndView listaAgendamento(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaUsuario");

		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) 
		{
			mv.addObject("error", (String) model.asMap().get("error"));	
			mv.addObject("success", (String) model.asMap().get("success"));
		}

		mv.addObject("usuario", new Usuario());
		mv.addObject("listaUsuarios", usuarioService.listUsuarios());
		return mv;
	}

	@RequestMapping(value= "/incluirUsuario", method = RequestMethod.GET)
	public ModelAndView incluirUsuario() {
		ModelAndView model = new ModelAndView("usuario");
		model.addObject("usuario", new Usuario());
		return model;
	}
	
	@RequestMapping(value= "/incluirUsuario", method = RequestMethod.POST)
	public ModelAndView incluirUsuarioSubmit(@ModelAttribute("usuario") Usuario usuario, @RequestParam String senha, Model model, RedirectAttributes redirectAttrs) throws Exception{
		String senhaMD5 = Usuario.getSenhaMD5(senha);
		usuario.setSenha(senhaMD5);
		
		try{
			if (usuario.getIdPessoa() == null) {
				this.usuarioService.addUsuario(usuario);
				redirectAttrs.addFlashAttribute("success", "Usuário incluído com sucesso.");
			} else {
				this.usuarioService.updateUsuario(usuario);
				redirectAttrs.addFlashAttribute("success", "Usuário alterado com sucesso.");
			}
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao Incluir/Alterar um Usuário");
		}
		
		return new ModelAndView("redirect:/usuario/listaUsuario");	
	}

	@RequestMapping("/excluirUsuario/{id}")
	public ModelAndView removeUsuario(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) throws Exception{
		try{
			this.usuarioService.removeUsuario(id);
			redirectAttrs.addFlashAttribute("success", "Usuário excluído com sucesso.");
			
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao excluir um Usuário");
		}
		
		return new ModelAndView("redirect:/usuario/listaUsuario");	
	}

	@RequestMapping("/alterarUsuario/{id}")
	public String editUsuario(@PathVariable("id") int id, Model model){
		model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
		return "usuario";
	}
}