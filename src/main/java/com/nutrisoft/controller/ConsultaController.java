package com.nutrisoft.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Antropometria;
import com.nutrisoft.model.AvaliacaoAlimentar;
import com.nutrisoft.model.Consulta;
import com.nutrisoft.model.DietaNutricional;
import com.nutrisoft.service.AgendamentoService;
import com.nutrisoft.service.ConsultaService;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private AgendamentoService agendamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listConsulta() {
		ModelAndView model = new ModelAndView("listaConsulta");
		model.addObject("consulta", new Consulta());
		model.addObject("consultas", consultaService.listConsultas());
		return model;
	}
//
//	@RequestMapping("/remove/{id}")
//	public String removeConsulta(@PathVariable("id") int id){
//		this.consultaService.removeConsulta(id);
//		return "redirect:/consulta";
//	}
//	
//	@RequestMapping("/edit/{id}")
//	public String editConsulta(@PathVariable("id") int id, Model model){
//		model.addAttribute("consulta", this.consultaService.getConsultaById(id));
//		return "listConsulta";
//	}
	
	@RequestMapping("/listarAgendamentosDeHoje")
	public String listarAgendamentosDeHoje(Model model) {
		model.addAttribute("agendamentos", this.agendamentoService.listarAgendamentosDeHoje());
		return "listarAgendamentosDeHoje";
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.GET)
	public String iniciarConsulta(@RequestParam Integer idAgendamento, Model model) {
		Consulta consulta = new Consulta();
		
		Agendamento agendamento = this.agendamentoService.getAgendamentoById(idAgendamento);
		consulta.setAgendamento(agendamento);
		consulta.setAntropometria(new Antropometria());
		consulta.setAvaliacaoAlimentar(new AvaliacaoAlimentar());
		consulta.setDietaNutricional(new DietaNutricional());
		model.addAttribute("consulta", consulta);
		
		List<Consulta> consultasAnteriores = this.consultaService.listarConsultasAnteriores(agendamento.getCliente());
		model.addAttribute("consultasAnteriores", consultasAnteriores);
		
		return "consulta";
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addConsulta(@ModelAttribute("consulta") Consulta consulta) throws Exception {
		this.consultaService.addConsulta(consulta);
		return "redirect:listarAgendamentosDeHoje";
	}
}