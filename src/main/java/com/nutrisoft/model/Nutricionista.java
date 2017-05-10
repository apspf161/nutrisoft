package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NUTRICIONISTA")
public class Nutricionista  { /*extends Person {*/

	@Id
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
