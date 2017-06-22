package com.nutrisoft.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="Nutricionista")
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="idNutricionista",referencedColumnName="idUsuario")})
public class Nutricionista extends Usuario {
    
	private String registro;

	@Override
	public String toString() {
		return this.toString() + " - Nutricionista [registro=" + registro + "]";
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
}
