package com.nutrisoft.model.enums;

import org.springframework.util.StringUtils;

public enum TipoConsultaEnum {
	
	PRIMEIRA_VEZ,
	ACOMPANHAMENTO;
	
	public String getFormatado() {
		return StringUtils.capitalize(this.toString().toLowerCase().replace("_", " "));
	}
}