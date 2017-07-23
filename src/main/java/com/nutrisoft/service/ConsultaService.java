package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Cliente;
import com.nutrisoft.model.Consulta;

public interface ConsultaService {
	
	public void addConsulta(Consulta consulta);
	
	public void updateConsulta(Consulta consulta);
	
	public void removeConsulta(int id);
	
	public List<Consulta> listConsultas();
	
	public Consulta getConsultaById(int id);
	
	public List<Consulta> listarConsultasAnteriores(Cliente cliente);
}