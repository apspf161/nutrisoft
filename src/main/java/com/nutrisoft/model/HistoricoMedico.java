package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HISTORICO_MEDICO")
public class HistoricoMedico {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@Column (name = "doencasPreExist", nullable = false, length = 255)
	private String doencasPreExist;
	
	@Column (name = "histDoencaFamiliar", nullable = false, length = 255)
	private String histDoencaFamiliar;
	
	@Column (name = "exameLaboratorial", nullable = false, length = 255)
	private String exameLaboratorial;
	
	@Column (name = "obs", nullable = false, length = 255)
	private String obs;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoencasPreExist() {
		return doencasPreExist;
	}

	public void setDoencasPreExist(String doencasPreExist) {
		this.doencasPreExist = doencasPreExist;
	}

	public String getHistDoencaFamiliar() {
		return histDoencaFamiliar;
	}

	public void setHistDoencaFamiliar(String histDoencaFamiliar) {
		this.histDoencaFamiliar = histDoencaFamiliar;
	}

	public String getExameLaboratorial() {
		return exameLaboratorial;
	}

	public void setExameLaboratorial(String exameLaboratorial) {
		this.exameLaboratorial = exameLaboratorial;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
}