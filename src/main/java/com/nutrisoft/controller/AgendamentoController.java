package com.nutrisoft.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Nutricionista;
import com.nutrisoft.service.AgendamentoService;
import com.nutrisoft.service.ClienteService;
import com.nutrisoft.service.NutricionistaService;
import com.nutrisoft.util.ValidacaoUtil;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private NutricionistaService nutricionistaService;

	@Autowired
	private ValidacaoUtil validacaoUtil;

	private static final DateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final DateFormat sdfDataBD = new SimpleDateFormat("yyyy-MM-dd");
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdfDataHora, false));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView menuAgendamento() {
		return new ModelAndView("principal");
	}

	@RequestMapping(value = "/filtraListaAgendamento/{txtData}", method = RequestMethod.GET)
	public ModelAndView filtraListaAdesao(@PathVariable String txtData, Model model, RedirectAttributes redirectAttrs) throws ParseException {

		Agendamento agendamento = new Agendamento();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		agendamento.setDataAgendamento(sdf1.parse(txtData));
		
		List<Agendamento> listaAgendamento = agendamentoService.filtrarListaAgendamentos(agendamento);

		redirectAttrs.addFlashAttribute("agendamento", listaAgendamento);

		return new ModelAndView("redirect:/agendamento/listaAgendamento");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listaAgendamento", method = RequestMethod.GET)
	public ModelAndView listaAgendamento(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaAgendamento");

		List<Agendamento> listaAgendamento = new ArrayList<Agendamento>();

		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) 
		{
			listaAgendamento = (List<Agendamento>) model.asMap().get("agendamento");
			mv.addObject("error", (String) model.asMap().get("error"));	
			mv.addObject("success", (String) model.asMap().get("success"));
		}
		else
		{
			//Não pode carregar nenhuma lista até o usuário buscar no filtro
		}

		mv.addObject("listaAgendamento", listaAgendamento);
		return mv;
	}
	
	@RequestMapping(value = "/filtraListaClientesParaAgendamento/{txtNome}/{txtCPF}", method = RequestMethod.GET)
	public ModelAndView filtraListaClientesParaAgendamento(@PathVariable String txtNome, @PathVariable String txtCPF, Model model, RedirectAttributes redirectAttrs) {

		Agendamento agendamento = new Agendamento();
		Cliente cliente = new Cliente();

		//Verifica se foi preenchido um text padrão para casos em que o usuário não preencher o campo.
		txtNome = ("x$x").equals(txtNome) ? null : txtNome;
		txtCPF = ("x$x").equals(txtCPF) ? null : txtCPF;

		cliente.setNome(txtNome);
		cliente.setCpf(txtCPF);
		agendamento.setCliente(cliente);

		List<Cliente> listaCliente = clienteService.filtrarListaCliente(cliente);

		redirectAttrs.addFlashAttribute("cliente", listaCliente);

		return new ModelAndView("redirect:/agendamento/listaClientesParaAgendamento");
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listaClientesParaAgendamento", method = RequestMethod.GET)
	public ModelAndView listaClientesParaAgendamento(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaClientesParaAgendamento");

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
	
	@RequestMapping(value = "/cadAgendamento/{idCliente}", method = RequestMethod.GET)
	public ModelAndView cadAgendamento(@PathVariable Integer idCliente, Model model, RedirectAttributes redirectAttrs) {

		Cliente cliente = clienteService.getClienteById(idCliente);
		redirectAttrs.addFlashAttribute("cliente", cliente);

		return new ModelAndView("redirect:/agendamento/agendarConsulta");
	}

	
	@RequestMapping(value = "/alterarAgendamento/{idAgendamento}", method = RequestMethod.GET)
	public ModelAndView alterarAgendamento(@PathVariable Integer idAgendamento, Model model, RedirectAttributes redirectAttrs) {

		Agendamento agendamento = agendamentoService.getAgendamentoById(idAgendamento);
		redirectAttrs.addFlashAttribute("agendamento", agendamento);
		redirectAttrs.addFlashAttribute("cliente", agendamento.getCliente());

		return new ModelAndView("redirect:/agendamento/agendarConsulta");
	}
	

	@RequestMapping(value = "/agendarConsulta", method = RequestMethod.GET)
	public ModelAndView agendarConsulta(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("agendarConsulta");
		Agendamento agendamento = new Agendamento();
		Cliente cliente = new Cliente();
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		if (flashMap != null) 
		{
			agendamento = (Agendamento) model.asMap().get("agendamento");
			cliente = (Cliente) model.asMap().get("cliente");
			
			agendamento = agendamento == null ? new Agendamento() : agendamento;
		}
		else
		{
			return new ModelAndView("redirect:/agendamento/listaClientesParaAgendamento");	
		}

		
		mv.addObject("inclusao", agendamento.getIdAgendamento() == null || agendamento.getIdAgendamento() == 0 ? true : false);
		
		List<Nutricionista> listaNutricionistas = nutricionistaService.listNutricionistas();
		agendamento.setCliente(cliente);

		mv.addObject("nutricionistas", listaNutricionistas);
		mv.addObject("agendamento", agendamento);

		return mv;
	}

	@RequestMapping(value = "/agendarConsulta", method = RequestMethod.POST)
	public ModelAndView agendarConsultaSubmit(@ModelAttribute("agendamento") Agendamento agendamento, BindingResult result, Model model, RedirectAttributes redirectAttrs) {

		String url = "redirect:/agendamento/listaClientesParaAgendamento";
		
		try{
			String data = sdfDataHora.format(agendamento.getDataAgendamento());
			
			if (agendamento.getIdAgendamento() == null) {
				this.agendamentoService.addAgendamento(agendamento);
				redirectAttrs.addFlashAttribute("success", "Consulta agendada para o dia "+ data +".");
			} else {
				this.agendamentoService.updateAgendamento(agendamento);
				url = "redirect:/agendamento/listaAgendamento";
				redirectAttrs.addFlashAttribute("success", "Consulta alterada para o dia "+ data +".");
			}
		}

		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao Agendar uma Consulta");
		}
		return new ModelAndView(url);	
	}

	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("agendamento") Agendamento agendamento) throws Exception{
		try{
			if (agendamento.getIdAgendamento() == null) {
				this.agendamentoService.addAgendamento(agendamento);
			} else {
				this.agendamentoService.updateAgendamento(agendamento);
			}
		}
		catch(Exception e){

		}

		return "redirect:/agendamento";
	}
		
	@RequestMapping(value = "/confirmarAgendamento/{idAgendamento}", method = RequestMethod.GET)
	public ModelAndView efetuarPagamentoSubmit(@PathVariable("idAgendamento") Integer idAgendamento, Model model, RedirectAttributes redirectAttrs) {

		try{
			if (idAgendamento != null) {
				Agendamento agendamento = new Agendamento();
				agendamento = this.agendamentoService.getAgendamentoById(idAgendamento);
				this.agendamentoService.confirmarConsulta(agendamento);
				redirectAttrs.addFlashAttribute("success", "Agendamento confirmado com sucesso.");
			}
			else
			{
				redirectAttrs.addFlashAttribute("error", "Erro ao Confirmar um Agendamento");
			}
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao Confirmar um Agendamento");
		}
		
		return new ModelAndView("redirect:/agendamento/listaAgendamento");	
	}
	

	@RequestMapping(value = "/cancelarAgendamento/{idAgendamento}", method = RequestMethod.GET)
	public ModelAndView cancelarAgendamento(@PathVariable("idAgendamento") Integer idAgendamento, Model model, RedirectAttributes redirectAttrs) {

		try{
			if (idAgendamento != null) {
				Agendamento agendamento = new Agendamento();
				agendamento = this.agendamentoService.getAgendamentoById(idAgendamento);
				this.agendamentoService.cancelarAgendamento(agendamento);
				redirectAttrs.addFlashAttribute("success", "Agendamento cancelado com sucesso.");
			} 
			else
			{
				redirectAttrs.addFlashAttribute("error", "Erro ao Cancelar um Agendamento");
			}
		}
		catch(Exception e){
			redirectAttrs.addFlashAttribute("error", "Erro ao Cancelar um Agendamento");
		}
		
		return new ModelAndView("redirect:/agendamento/listaAgendamento");	
	}
	
	public AgendamentoService getAgendamentoService() {
		return agendamentoService;
	}

	public void setAgendamentoService(AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public NutricionistaService getNutricionistaService() {
		return nutricionistaService;
	}

	public void setNutricionistaService(NutricionistaService nutricionistaService) {
		this.nutricionistaService = nutricionistaService;
	}
}