package com.nutrisoft.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NUTRICIONISTA")
@AttributeOverrides({@AttributeOverride(name="id", column=@Column(name="id"))})  
public class Nutricionista extends Person {

	@Column(name="registro")
	private String reg;

	@Column(name="nomeN")
	private String nomeN;

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getNomeN() {
		return nomeN;
	}

	public void setNomeN(String nomeN) {
		this.nomeN = nomeN;
	}
	
	

}
