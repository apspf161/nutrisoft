package com.nutrisoft.model.enums;

public enum SexoEnum {
	
	MASCULINO('M'), 
	FEMININO('F');
	
	private char sigla;
	
	private SexoEnum(char sigla) {
		this.sigla = sigla;
	}
	
	public char getSigla() {
		return sigla;
	}
}