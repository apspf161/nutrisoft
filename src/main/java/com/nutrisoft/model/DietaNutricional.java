package com.nutrisoft.model;

public class DietaNutricional {

	private Consulta consulta;
	private String cafeDaManha;
	private String lancheDaManha;
	private String almoco;
	private String lanceDaTarde;
	private String jantar;
	private String ceia;

	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public String getCafeDaManha() {
		return cafeDaManha;
	}
	public void setCafeDaManha(String cafeDaManha) {
		this.cafeDaManha = cafeDaManha;
	}
	public String getLancheDaManha() {
		return lancheDaManha;
	}
	public void setLancheDaManha(String lancheDaManha) {
		this.lancheDaManha = lancheDaManha;
	}
	public String getAlmoco() {
		return almoco;
	}
	public void setAlmoco(String almoco) {
		this.almoco = almoco;
	}
	public String getLanceDaTarde() {
		return lanceDaTarde;
	}
	public void setLanceDaTarde(String lanceDaTarde) {
		this.lanceDaTarde = lanceDaTarde;
	}
	public String getJantar() {
		return jantar;
	}
	public void setJantar(String jantar) {
		this.jantar = jantar;
	}
	public String getCeia() {
		return ceia;
	}
	public void setCeia(String ceia) {
		this.ceia = ceia;
	}
	
}
