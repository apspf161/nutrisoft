package com.nutrisoft.model.enums;

public enum StatusAgendamentoEnum {
	MARCADO (1),
	CONFIRMADO (2),
	CANCELADO (3),
	REALIZADO (4);
	
	private Integer status;
	
	private StatusAgendamentoEnum (Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	
}