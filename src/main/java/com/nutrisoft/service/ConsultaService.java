package com.nutrisoft.service;

import java.util.List;

import com.nutrisoft.model.Consulta;

public interface ConsultaService {
	
	void addConsulta(Consulta consulta);

	void updateConsulta(Consulta consulta);
	
	void removeConsulta(int id);
	
	List<Consulta> listConsultas();
	
	Consulta getConsultaById(int id);
}