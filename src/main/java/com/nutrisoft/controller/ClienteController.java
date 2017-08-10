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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Usuario;
import com.nutrisoft.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/listaCliente", method = RequestMethod.GET)
	public ModelAndView listaCliente(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaCliente");

		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) 
		{
			mv.addObject("error", (String) model.asMap().get("error"));	
			mv.addObject("success", (String) model.asMap().get("success"));
		}

		mv.addObject("cliente", new Cliente());
		mv.addObject("listaClientes", clienteService.listClientes());
		return mv;
	}
	
	@RequestMapping(value= "/incluirCliente", method = RequestMethod.GET)
	public ModelAndView incluirCliente() throws Exception{
		ModelAndView model = new ModelAndView("cliente");
		model.addObject("cliente", new Usuario());
		return model;
	}
	
	@RequestMapping(value= "/incluirCliente", method = RequestMethod.POST)
	public ModelAndView incluirClienteSubmit(@ModelAttribute("cliente") Cliente cliente, Model model, RedirectAttributes redirectAttrs) throws Exception{
		
		try{
			if (cliente.getIdPessoa() == null) {
				this.clienteService.addCliente(cliente);
				redirectAttrs.addFlashAttribute("success", "Cliente incluído com sucesso.");
			} else {
				this.clienteService.updateCliente(cliente);
				redirectAttrs.addFlashAttribute("success", "Cliente alterado com sucesso.");
			}
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao Incluir/Alterar um Cliente.");
		}
		
		return new ModelAndView("redirect:/cliente/listaCliente");	
	}

	@RequestMapping("/remove/{id}")
	public String removeCliente(@PathVariable("id") int id){
		this.clienteService.removeCliente(id);
		return "redirect:/cliente";
	}

	@RequestMapping("/edit/{id}")
	public String editCliente(@PathVariable("id") int id, Model model){
		model.addAttribute("cliente", this.clienteService.getClienteById(id));
		return "cliente";
	}
}