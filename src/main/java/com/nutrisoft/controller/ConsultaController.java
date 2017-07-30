package com.nutrisoft.controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Antropometria;
import com.nutrisoft.model.AvaliacaoAlimentar;
import com.nutrisoft.model.Cliente;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView menuConsulta() {
		return new ModelAndView("principal");
	}

	@RequestMapping(value = "/filtraListaPagamento/{txtNome}/{txtCPF}", method = RequestMethod.GET)
	public ModelAndView filtraListaAdesao(@PathVariable String txtNome, @PathVariable String txtCPF, Model model, RedirectAttributes redirectAttrs) throws ParseException {

		Consulta consulta = new Consulta();
		Agendamento agendamento = new Agendamento();
		Cliente cliente = new Cliente();

		//Verifica se foi preenchido um text padrão para casos em que o usuário não preencher o campo.
		txtNome = ("x$x").equals(txtNome) ? null : txtNome;
		txtCPF = ("x$x").equals(txtCPF) ? null : txtCPF;

		cliente.setNome(txtNome);
		cliente.setCpf(txtCPF);
		agendamento.setCliente(cliente);
		consulta.setAgendamento(agendamento);
		consulta.setPago(true);

		List<Consulta> listaPagamento = consultaService.filtrarListaPagamentos(consulta);

		redirectAttrs.addFlashAttribute("pagamento", listaPagamento);

		return new ModelAndView("redirect:/consulta/listaPagamento");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listaPagamento", method = RequestMethod.GET)
	public ModelAndView listaPagamento(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaPagamento");

		List<Consulta> listaPagamento = new ArrayList<Consulta>();

		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) 
		{
			listaPagamento = (List<Consulta>) model.asMap().get("pagamento");
			mv.addObject("error", (String) model.asMap().get("error"));	
			mv.addObject("success", (String) model.asMap().get("success"));
		}
		else
		{
			//Não pode carregar nenhuma lista até o usuário buscar no filtro
		}

		mv.addObject("listaPagamento", listaPagamento);
		return mv;
	}

	@RequestMapping(value = "/filtraListaClientesParaPagamento/{txtNome}/{txtCPF}", method = RequestMethod.GET)
	public ModelAndView filtraListaClientesParaPagamento(@PathVariable String txtNome, @PathVariable String txtCPF, Model model, RedirectAttributes redirectAttrs) {

		Consulta consulta = new Consulta();
		Agendamento agendamento = new Agendamento();
		Cliente cliente = new Cliente();

		//Verifica se foi preenchido um text padrão para casos em que o usuário não preencher o campo.
		txtNome = ("x$x").equals(txtNome) ? null : txtNome;
		txtCPF = ("x$x").equals(txtCPF) ? null : txtCPF;

		cliente.setNome(txtNome);
		cliente.setCpf(txtCPF);
		agendamento.setCliente(cliente);
		consulta.setAgendamento(agendamento);
		consulta.setPago(false);

		List<Consulta> listaCliente = consultaService.filtrarListaPagamentos(consulta);

		redirectAttrs.addFlashAttribute("cliente", listaCliente);

		return new ModelAndView("redirect:/consulta/listaClientesParaPagamento");
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listaClientesParaPagamento", method = RequestMethod.GET)
	public ModelAndView listaClientesParaPagamento(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaClientesParaPagamento");

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) 
		{
			listaCliente = (List<Cliente>) model.asMap().get("cliente");
			mv.addObject("error", (String) model.asMap().get("error"));	
			mv.addObject("success", (String) model.asMap().get("success"));
		}
		else
		{
			//Não pode carregar nenhuma lista até o usuário buscar no filtro
		}

		mv.addObject("listaCliente", listaCliente);
		return mv;
	}

	@RequestMapping(value = "/cadPagamento/{idConsulta}", method = RequestMethod.GET)
	public ModelAndView cadAgendamento(@PathVariable Integer idConsulta, Model model, RedirectAttributes redirectAttrs) {

		Consulta consulta = consultaService.getConsultaById(idConsulta);
		redirectAttrs.addFlashAttribute("consulta", consulta);

		return new ModelAndView("redirect:/consulta/efetuarPagamento");
	}


	@RequestMapping(value = "/efetuarPagamento", method = RequestMethod.GET)
	public ModelAndView agendarConsulta(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("efetuarPagamento");

		Consulta consulta = new Consulta();
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) 
		{
			consulta = (Consulta) model.asMap().get("consulta");
		}
		else
		{
			return new ModelAndView("redirect:/consulta/listaClientesParaPagamento");	
		}

		mv.addObject("consulta", consulta);

		return mv;
	}

	@RequestMapping(value = "/efetuarPagamento", method = RequestMethod.POST)
	public ModelAndView efetuarPagamentoSubmit(@ModelAttribute("consulta") Consulta consulta, BindingResult result, Model model, RedirectAttributes redirectAttrs) {

		try{
			if (consulta.getIdConsulta() != null) {
				this.consultaService.efetuarPagamento(consulta);
			} 

			redirectAttrs.addFlashAttribute("success", "Pagamento realizado com sucesso.");
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao Efetuar um Pagamento");
		}
		return new ModelAndView("redirect:/agendamento/listaClientesParaAgendamento");	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listConsulta() {
		ModelAndView model = new ModelAndView("listaConsulta");
		model.addObject("consulta", new Consulta());
		model.addObject("consultas", consultaService.listConsultas());
		return model;
	}

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