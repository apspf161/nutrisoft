package com.nutrisoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nutrisoft.model.Consulta;
import com.nutrisoft.service.ConsultaService;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listConsulta() {
		ModelAndView model = new ModelAndView("consulta");
		model.addObject("consulta", new Consulta());
		model.addObject("consultas", consultaService.listConsultas());
		return model;
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("consulta") Consulta consulta) throws Exception{
		if (consulta.getIdConsulta() == null) {
			this.consultaService.addConsulta(consulta);
		} else {
			this.consultaService.updateConsulta(consulta);
		}
		return "redirect:/consulta";
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		this.consultaService.removeConsulta(id);
		return "redirect:/consulta";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model){
		model.addAttribute("consulta", this.consultaService.getConsultaById(id));
		return "consulta";
	}
}