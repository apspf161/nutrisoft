package com.nutrisoft.model.enums;

import org.springframework.util.StringUtils;

public enum StatusAgendamentoEnum {
	MARCADO,
	CONFIRMADO,
	CANCELADO,
	REALIZADO;
	
	public String getFormatado() {
		return StringUtils.capitalize(this.toString().toLowerCase());
	}
}