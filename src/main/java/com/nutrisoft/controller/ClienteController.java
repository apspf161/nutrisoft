package com.nutrisoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listCliente() {
		ModelAndView model = new ModelAndView("cliente");
		model.addObject("cliente", new Cliente());
		model.addObject("clientes", clienteService.listClientes());
		return model;
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("cliente") Cliente cliente) throws Exception{
		if (cliente.getIdPessoa() == null) {
			this.clienteService.addCliente(cliente);
		} else {
			this.clienteService.updateCliente(cliente);
		}
		return "redirect:/cliente";
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		this.clienteService.removeCliente(id);
		return "redirect:/cliente";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model){
		model.addAttribute("cliente", this.clienteService.getClienteById(id));
		return "cliente";
	}
}