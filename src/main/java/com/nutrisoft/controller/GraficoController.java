package com.nutrisoft.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nutrisoft.model.Agendamento;
import com.nutrisoft.model.Cliente;
import com.nutrisoft.service.ClienteService;
import com.nutrisoft.service.ConsultaService;
import com.nutrisoft.util.GraficoBase;
import com.nutrisoft.util.GraficoComposicaoCorporal;
import com.nutrisoft.util.GraficoMetaDePeso;

import be.ceau.chart.LineChart;
import be.ceau.chart.data.LineData;

@Controller
@RequestMapping("/grafico")
public class GraficoController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	protected ConsultaService consultaService;
	
	private static final DateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdfDataHora, false));
	}

	@RequestMapping(value = "/filtraListaClientesParaGrafico/{txtNome}/{txtCPF}", method = RequestMethod.GET)
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

		return new ModelAndView("redirect:/grafico/listaClientesParaGrafico");
	}

	@RequestMapping(value = "/listaClientesParaGrafico", method = RequestMethod.GET)
	public ModelAndView listaClientesParaGrafico(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("listaClientesParaGrafico");

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

	@RequestMapping(value = "/graficoEvolucoesCliente/{idCliente}", method = RequestMethod.GET)
	public ModelAndView graficoEvolucoesCliente(@PathVariable Integer idCliente, Model model, RedirectAttributes redirectAttrs) {

		Cliente cliente = clienteService.getClienteById(idCliente);
		redirectAttrs.addFlashAttribute("cliente", cliente);

		return new ModelAndView("redirect:/grafico/graficoEvolucoes");
	}

	
	@RequestMapping(value = "/graficoEvolucoes", method = { RequestMethod.GET })
	public ModelAndView graficoEvolucoes(Model model, HttpServletRequest request) throws IOException {

		ModelAndView mv = new ModelAndView("graficoEvolucoes");

		Cliente cliente = new Cliente();
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		if (flashMap != null) 
		{
			cliente = (Cliente) model.asMap().get("cliente");
		}
		else
		{
			return new ModelAndView("redirect:/grafico/listaClientesParaGrafico");	
		}

		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@RequestMapping(value = "/graficoMetaPeso", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody LineData graficoMetaPeso(@RequestParam("idCliente") Integer idCliente, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		GraficoBase gb = new GraficoMetaDePeso(clienteService, consultaService);
		LineChart chart = gb.criarGrafico(idCliente);

		if(chart == null)
		{
			return null;
		}

		return chart.getData();
	}
	
	@RequestMapping(value = "/graficoComposicaoCorporal", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody LineData graficoComposicaoCorporal(@RequestParam("idCliente") Integer idCliente, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		GraficoBase gb = new GraficoComposicaoCorporal(clienteService, consultaService);
		LineChart chart = gb.criarGrafico(idCliente);

		if(chart == null)
		{
			return null;
		}

		return chart.getData();
	}
}