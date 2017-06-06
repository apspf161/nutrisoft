package com.nutrisoft.model.enums;

public enum TipoConsultaEnum {
	PRIMEIRA_VEZ ('P'),
	ACOMPANHAMENTO('A');
	
	private char tipo;
	
	private TipoConsultaEnum (char tipo) {
		this.tipo = tipo;
	}

	public char getTipo() {
		return tipo;
	}
	
}