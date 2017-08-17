package com.nutrisoft.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;
import com.nutrisoft.service.ClienteService;
import com.nutrisoft.service.ConsultaService;

import be.ceau.chart.LineChart;

public abstract class GraficoBase {

	@Autowired
	protected ClienteService clienteService;

	@Autowired
	protected ConsultaService consultaService;

	public GraficoBase(ClienteService clienteService, ConsultaService consultaService) {
        this.clienteService = clienteService;
        this.consultaService = consultaService;
    }
	
	public LineChart criarGrafico(Integer idCliente){
		
		Cliente cliente = buscarCliente(idCliente);
		
		List<Consulta> lista = listarConsultas(cliente);
		
		return formatarDados(lista);
	}
	
	public Cliente buscarCliente(Integer idCliente){
		 return clienteService.getClienteById(idCliente);
	}
	
	public List<Consulta> listarConsultas(Cliente cliente){
		return consultaService.filtrarListaGrafico(cliente);
	}

	public abstract LineChart formatarDados(List<Consulta> lista);
}
