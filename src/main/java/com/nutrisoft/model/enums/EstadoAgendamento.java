package com.nutrisoft.model.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EstadoAgendamento {
	
	MARCADA("Marcada"), CONFIRMADA("Confirmada"), CANCELADA("Cancelada"), CONCLUIDA("Concluida");
	
	private final String valor;

	private static Map<String, EstadoAgendamento> lookup = new HashMap<String, EstadoAgendamento>();
	
	static {
		for (EstadoAgendamento tipo : EstadoAgendamento.values()) {
			lookup.put(tipo.getValor(), tipo);
		}
	}
	
	EstadoAgendamento(String valor){
		this.valor = valor;
	}
	
	public String getValor(){
		return valor;
	}
	
	public static EstadoAgendamento getEstadoAgendamento(String valor){
		return lookup.get(valor);
	}
	
	public static List<String> getValores(){
		List<String> listaValores = new ArrayList<String>();
		
		for (EstadoAgendamento EstadoAgendamento: values()){
			listaValores.add(EstadoAgendamento.valor);
		}
		
		return listaValores;
	}
}
