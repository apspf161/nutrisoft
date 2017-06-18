package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="Historico_Medico")
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="idCliente",referencedColumnName="idCliente")})
public class HistoricoMedico extends Cliente{

	@Column(name = "doencasPreExist", columnDefinition = "TEXT")
	private String doencasPreExist;
	
    @Column(name = "histDoencaFamiliar", columnDefinition = "TEXT")
	private String histDoencaFamiliar;
	
    @Column(name = "exameLaboratorial", columnDefinition = "TEXT")
	private String exameLaboratorial;
	
    @Column(name = "obs", columnDefinition = "TEXT")
	private String obs;
	
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