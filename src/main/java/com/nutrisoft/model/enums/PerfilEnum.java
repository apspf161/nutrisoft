package com.nutrisoft.model.enums;

import org.springframework.util.StringUtils;

public enum PerfilEnum {
	
	ATENDENTE,
	NUTRICIONISTA,
	ADMINISTRADOR;
	
	public String getFormatado() {
		return StringUtils.capitalize(this.toString().toLowerCase());
	}
}