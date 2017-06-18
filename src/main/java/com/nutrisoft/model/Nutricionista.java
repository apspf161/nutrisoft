package com.nutrisoft.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="Nutricionista")
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="idNutricionista",referencedColumnName="idUsuario")})
public class Nutricionista extends Usuario {
    
	private String reg;

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	@Override
	public String toString() {
		return this.toString() + " - Nutricionista [reg=" + reg + "]";
	}
}
