package com.nutrisoft.model.enums;

public enum PerfilEnum {
	ATENDENTE (1),
	NUTRICIONISTA (2),
	ADMINISTRADOR(3);
	
	private Integer id;
	
	private PerfilEnum (Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public static PerfilEnum getById(Integer id) {
		for (PerfilEnum perfil : PerfilEnum.values()) {
			if (perfil.getId().equals(id)) {
				return perfil;
			}
		}
		
		return null;
	}
}