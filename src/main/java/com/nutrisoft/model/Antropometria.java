package com.nutrisoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Antropometria")
public class Antropometria implements Serializable {

	private static final long serialVersionUID = 6442541897068880914L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAntropometria;
	
	@MapsId
	@OneToOne(mappedBy="antropometria")
	@JoinColumn(name="idConsulta")
	private Consulta consulta;

	@Column(name = "pesoUsual", precision = 4, scale = 1)  
	private Float pesoUsual;	

	@Column(name = "pesoDesejavel", precision = 4, scale = 1)  
	private Float pesoDesejavel;
	
	private Integer torax;

	private Integer bracoRelaxado;
	
	private Integer bracoFletido;
	
	private Integer cintura;
	
	private Integer abdomen;
	
	private Integer quadril;
	
	private Integer coxa;
	
	private Integer coxaProximal;
	
	private Integer coxaMedial;
	
	private Integer panturrilha;
	
	private Integer triciptal;

	private Integer peitoral;
	
	private Integer axilarMedia;

	private Integer subescapular;
	
	private Integer abdominal;

	private Integer suparaliaca;
	
	private Integer somatorio;

	public Float getPesoUsual() {
		return pesoUsual;
	}

	public void setPesoUsual(Float pesoUsual) {
		this.pesoUsual = pesoUsual;
	}

	public Float getPesoDesejavel() {
		return pesoDesejavel;
	}

	public void setPesoDesejavel(Float pesoDesejavel) {
		this.pesoDesejavel = pesoDesejavel;
	}

	public Integer getTorax() {
		return torax;
	}

	public void setTorax(Integer torax) {
		this.torax = torax;
	}

	public Integer getBracoRelaxado() {
		return bracoRelaxado;
	}

	public void setBracoRelaxado(Integer bracoRelaxado) {
		this.bracoRelaxado = bracoRelaxado;
	}

	public Integer getBracoFletido() {
		return bracoFletido;
	}

	public void setBracoFletido(Integer bracoFletido) {
		this.bracoFletido = bracoFletido;
	}

	public Integer getCintura() {
		return cintura;
	}

	public void setCintura(Integer cintura) {
		this.cintura = cintura;
	}

	public Integer getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(Integer abdomen) {
		this.abdomen = abdomen;
	}

	public Integer getQuadril() {
		return quadril;
	}

	public void setQuadril(Integer quadril) {
		this.quadril = quadril;
	}

	public Integer getCoxa() {
		return coxa;
	}

	public void setCoxa(Integer coxa) {
		this.coxa = coxa;
	}

	public Integer getCoxaProximal() {
		return coxaProximal;
	}

	public void setCoxaProximal(Integer coxaProximal) {
		this.coxaProximal = coxaProximal;
	}

	public Integer getCoxaMedial() {
		return coxaMedial;
	}

	public void setCoxaMedial(Integer coxaMedial) {
		this.coxaMedial = coxaMedial;
	}

	public Integer getPanturrilha() {
		return panturrilha;
	}

	public void setPanturrilha(Integer panturrilha) {
		this.panturrilha = panturrilha;
	}

	public Integer getTriciptal() {
		return triciptal;
	}

	public void setTriciptal(Integer triciptal) {
		this.triciptal = triciptal;
	}

	public Integer getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Integer peitoral) {
		this.peitoral = peitoral;
	}

	public Integer getAxilarMedia() {
		return axilarMedia;
	}

	public void setAxilarMedia(Integer axilarMedia) {
		this.axilarMedia = axilarMedia;
	}

	public Integer getSubescapular() {
		return subescapular;
	}

	public void setSubescapular(Integer subescapular) {
		this.subescapular = subescapular;
	}

	public Integer getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(Integer abdominal) {
		this.abdominal = abdominal;
	}

	public Integer getSuparaliaca() {
		return suparaliaca;
	}

	public void setSuparaliaca(Integer suparaliaca) {
		this.suparaliaca = suparaliaca;
	}

	public Integer getSomatorio() {
		return somatorio;
	}

	public void setSomatorio(Integer somatorio) {
		this.somatorio = somatorio;
	}

	public Integer getIdAntropometria() {
		return idAntropometria;
	}

	public void setIdAntropometria(Integer idAntropometria) {
		this.idAntropometria = idAntropometria;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
}
