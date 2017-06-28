package com.nutrisoft.model.enums;

public enum TipoConsultaEnum {
	
	PRIMEIRA_VEZ("P"),
	ACOMPANHAMENTO("A");
	
	private String status;
	
	private TipoConsultaEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}