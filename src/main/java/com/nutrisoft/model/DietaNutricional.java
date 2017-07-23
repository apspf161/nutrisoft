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
@Table(name="Dieta_Nutricional")
public class DietaNutricional implements Serializable {
	
	private static final long serialVersionUID = 6442541897068880914L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDietaNutricional;

	@MapsId
	@OneToOne(mappedBy="dietaNutricional")
	@JoinColumn(name="idConsulta")
	private Consulta consulta;

    @Column(name = "cafeDaManha", columnDefinition = "TEXT")
    private String cafeDaManha;
    
    @Column(name = "lancheDaManha", columnDefinition = "TEXT")
    private String lancheDaManha;
    
    @Column(name = "almoco", columnDefinition = "TEXT")
    private String almoco;
    
    @Column(name = "lancheTarde", columnDefinition = "TEXT")
    private String lancheTarde;
    
    @Column(name = "jantar", columnDefinition = "TEXT")
    private String jantar;
    
    @Column(name = "ceia", columnDefinition = "TEXT")
    private String ceia;

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

	public String getLancheTarde() {
		return lancheTarde;
	}

	public void setLancheTarde(String lancheTarde) {
		this.lancheTarde = lancheTarde;
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

	public Integer getIdDietaNutricional() {
		return idDietaNutricional;
	}

	public void setIdDietaNutricional(Integer idDietaNutricional) {
		this.idDietaNutricional = idDietaNutricional;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
}