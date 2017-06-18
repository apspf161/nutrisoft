package com.nutrisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="Dieta_Nutricional")
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="idConsulta",referencedColumnName="idConsulta")})
public class DietaNutricional extends Consulta {
    
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
		
	
}
