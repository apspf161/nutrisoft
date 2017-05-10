package com.nutrisoft.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
@AttributeOverrides({@AttributeOverride(name="id", column=@Column(name="id"))})
public class Cliente extends Person {

	@Column(name="cpfCli")
	private String cpfCli;

	public String getCpfCli() {
		return cpfCli;
	}

	public void setCpfCli(String cpfCli) {
		this.cpfCli = cpfCli;
	}
	
}
