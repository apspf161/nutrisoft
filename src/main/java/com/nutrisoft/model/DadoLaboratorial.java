package com.nutrisoft.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Dado_Laboratorial")
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="idCliente",referencedColumnName="idCliente")})
public class DadoLaboratorial extends Cliente {

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private Float acidoUrico;

	private Float creatinina;

	private Float ferritina;

	private Float glicemiaJejum;

	private Float ureia;

	private Float capacFixacaoFerro;

	private Float fosfoquinase;

	private Float glicemiaPosPrandial;

	private Float hemoglobinaGlicada;

	private Float homocisteina;

	private Float insulina;

	private Float saturacaoTransferrina;

	private Float transferrina;

	private Float tgo;

	private Float tgp;

	private Float eritrocitos;

	private Float hematocrito;

	private Float hemoglobina;

	private Float vcm;

	private Float hcm;

	private Float rdw;

	private Float chcm;

	private Float leucocitosTotais;

	private Float basofilo;

	private Float bastonete;

	private Float blastos;

	private Float eosinofilos;

	private Float linfocitos;

	private Float metamielocitos;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getAcidoUrico() {
		return acidoUrico;
	}

	public void setAcidoUrico(Float acidoUrico) {
		this.acidoUrico = acidoUrico;
	}

	public Float getCreatinina() {
		return creatinina;
	}

	public void setCreatinina(Float creatinina) {
		this.creatinina = creatinina;
	}

	public Float getFerritina() {
		return ferritina;
	}

	public void setFerritina(Float ferritina) {
		this.ferritina = ferritina;
	}

	public Float getGlicemiaJejum() {
		return glicemiaJejum;
	}

	public void setGlicemiaJejum(Float glicemiaJejum) {
		this.glicemiaJejum = glicemiaJejum;
	}

	public Float getUreia() {
		return ureia;
	}

	public void setUreia(Float ureia) {
		this.ureia = ureia;
	}

	public Float getCapacFixacaoFerro() {
		return capacFixacaoFerro;
	}

	public void setCapacFixacaoFerro(Float capacFixacaoFerro) {
		this.capacFixacaoFerro = capacFixacaoFerro;
	}

	public Float getFosfoquinase() {
		return fosfoquinase;
	}

	public void setFosfoquinase(Float fosfoquinase) {
		this.fosfoquinase = fosfoquinase;
	}

	public Float getGlicemiaPosPrandial() {
		return glicemiaPosPrandial;
	}

	public void setGlicemiaPosPrandial(Float glicemiaPosPrandial) {
		this.glicemiaPosPrandial = glicemiaPosPrandial;
	}

	public Float getHemoglobinaGlicada() {
		return hemoglobinaGlicada;
	}

	public void setHemoglobinaGlicada(Float hemoglobinaGlicada) {
		this.hemoglobinaGlicada = hemoglobinaGlicada;
	}

	public Float getHomocisteina() {
		return homocisteina;
	}

	public void setHomocisteina(Float homocisteina) {
		this.homocisteina = homocisteina;
	}

	public Float getInsulina() {
		return insulina;
	}

	public void setInsulina(Float insulina) {
		this.insulina = insulina;
	}

	public Float getSaturacaoTransferrina() {
		return saturacaoTransferrina;
	}

	public void setSaturacaoTransferrina(Float saturacaoTransferrina) {
		this.saturacaoTransferrina = saturacaoTransferrina;
	}

	public Float getTransferrina() {
		return transferrina;
	}

	public void setTransferrina(Float transferrina) {
		this.transferrina = transferrina;
	}

	public Float getTgo() {
		return tgo;
	}

	public void setTgo(Float tgo) {
		this.tgo = tgo;
	}

	public Float getTgp() {
		return tgp;
	}

	public void setTgp(Float tgp) {
		this.tgp = tgp;
	}

	public Float getEritrocitos() {
		return eritrocitos;
	}

	public void setEritrocitos(Float eritrocitos) {
		this.eritrocitos = eritrocitos;
	}

	public Float getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(Float hematocrito) {
		this.hematocrito = hematocrito;
	}

	public Float getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(Float hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public Float getVcm() {
		return vcm;
	}

	public void setVcm(Float vcm) {
		this.vcm = vcm;
	}

	public Float getHcm() {
		return hcm;
	}

	public void setHcm(Float hcm) {
		this.hcm = hcm;
	}

	public Float getRdw() {
		return rdw;
	}

	public void setRdw(Float rdw) {
		this.rdw = rdw;
	}

	public Float getChcm() {
		return chcm;
	}

	public void setChcm(Float chcm) {
		this.chcm = chcm;
	}

	public Float getLeucocitosTotais() {
		return leucocitosTotais;
	}

	public void setLeucocitosTotais(Float leucocitosTotais) {
		this.leucocitosTotais = leucocitosTotais;
	}

	public Float getBasofilo() {
		return basofilo;
	}

	public void setBasofilo(Float basofilo) {
		this.basofilo = basofilo;
	}

	public Float getBastonete() {
		return bastonete;
	}

	public void setBastonete(Float bastonete) {
		this.bastonete = bastonete;
	}

	public Float getBlastos() {
		return blastos;
	}

	public void setBlastos(Float blastos) {
		this.blastos = blastos;
	}

	public Float getEosinofilos() {
		return eosinofilos;
	}

	public void setEosinofilos(Float eosinofilos) {
		this.eosinofilos = eosinofilos;
	}

	public Float getLinfocitos() {
		return linfocitos;
	}

	public void setLinfocitos(Float linfocitos) {
		this.linfocitos = linfocitos;
	}

	public Float getMetamielocitos() {
		return metamielocitos;
	}

	public void setMetamielocitos(Float metamielocitos) {
		this.metamielocitos = metamielocitos;
	}

}
