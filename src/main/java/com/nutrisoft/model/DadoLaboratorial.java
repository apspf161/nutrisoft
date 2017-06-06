package com.nutrisoft.model;

import java.math.BigDecimal;
import java.sql.Date;

public class DadoLaboratorial {
	
	private Cliente cliente;
	private Date data;
	private BigDecimal acidoUrico;
	private BigDecimal creatinina;
	private BigDecimal ferritina;
	private BigDecimal glicemiaJejum;
	private BigDecimal ureia;
	private BigDecimal capacFixacaoFerro;
	private BigDecimal fosfoquinase;
	private BigDecimal glicemiaPosPrandial;
	private BigDecimal hemoglobinaGlicada;
	private BigDecimal homocisteina;
	private BigDecimal insulina;
	private BigDecimal saturacaoTransferrina;
	private BigDecimal transferrina;
	private BigDecimal tgo;
	private BigDecimal tgp;
	private BigDecimal eritrocitos;
	private BigDecimal hematocrito;
	private BigDecimal hemoglobina;
	private BigDecimal vcm;
	private BigDecimal hcm;
	private BigDecimal rdw;
	private BigDecimal chcm;
	private BigDecimal leucocitosTotais;
	private BigDecimal basofilo;
	private BigDecimal bastonete;
	private BigDecimal blastos;
	private BigDecimal eosinofilos;
	private BigDecimal linfocitos;
	private BigDecimal metamielocitos;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getAcidoUrico() {
		return acidoUrico;
	}
	public void setAcidoUrico(BigDecimal acidoUrico) {
		this.acidoUrico = acidoUrico;
	}
	public BigDecimal getCreatinina() {
		return creatinina;
	}
	public void setCreatinina(BigDecimal creatinina) {
		this.creatinina = creatinina;
	}
	public BigDecimal getFerritina() {
		return ferritina;
	}
	public void setFerritina(BigDecimal ferritina) {
		this.ferritina = ferritina;
	}
	public BigDecimal getGlicemiaJejum() {
		return glicemiaJejum;
	}
	public void setGlicemiaJejum(BigDecimal glicemiaJejum) {
		this.glicemiaJejum = glicemiaJejum;
	}
	public BigDecimal getUreia() {
		return ureia;
	}
	public void setUreia(BigDecimal ureia) {
		this.ureia = ureia;
	}
	public BigDecimal getCapacFixacaoFerro() {
		return capacFixacaoFerro;
	}
	public void setCapacFixacaoFerro(BigDecimal capacFixacaoFerro) {
		this.capacFixacaoFerro = capacFixacaoFerro;
	}
	public BigDecimal getFosfoquinase() {
		return fosfoquinase;
	}
	public void setFosfoquinase(BigDecimal fosfoquinase) {
		this.fosfoquinase = fosfoquinase;
	}
	public BigDecimal getGlicemiaPosPrandial() {
		return glicemiaPosPrandial;
	}
	public void setGlicemiaPosPrandial(BigDecimal glicemiaPosPrandial) {
		this.glicemiaPosPrandial = glicemiaPosPrandial;
	}
	public BigDecimal getHemoglobinaGlicada() {
		return hemoglobinaGlicada;
	}
	public void setHemoglobinaGlicada(BigDecimal hemoglobinaGlicada) {
		this.hemoglobinaGlicada = hemoglobinaGlicada;
	}
	public BigDecimal getHomocisteina() {
		return homocisteina;
	}
	public void setHomocisteina(BigDecimal homocisteina) {
		this.homocisteina = homocisteina;
	}
	public BigDecimal getInsulina() {
		return insulina;
	}
	public void setInsulina(BigDecimal insulina) {
		this.insulina = insulina;
	}
	public BigDecimal getSaturacaoTransferrina() {
		return saturacaoTransferrina;
	}
	public void setSaturacaoTransferrina(BigDecimal saturacaoTransferrina) {
		this.saturacaoTransferrina = saturacaoTransferrina;
	}
	public BigDecimal getTransferrina() {
		return transferrina;
	}
	public void setTransferrina(BigDecimal transferrina) {
		this.transferrina = transferrina;
	}
	public BigDecimal getTgo() {
		return tgo;
	}
	public void setTgo(BigDecimal tgo) {
		this.tgo = tgo;
	}
	public BigDecimal getTgp() {
		return tgp;
	}
	public void setTgp(BigDecimal tgp) {
		this.tgp = tgp;
	}
	public BigDecimal getEritrocitos() {
		return eritrocitos;
	}
	public void setEritrocitos(BigDecimal eritrocitos) {
		this.eritrocitos = eritrocitos;
	}
	public BigDecimal getHematocrito() {
		return hematocrito;
	}
	public void setHematocrito(BigDecimal hematocrito) {
		this.hematocrito = hematocrito;
	}
	public BigDecimal getHemoglobina() {
		return hemoglobina;
	}
	public void setHemoglobina(BigDecimal hemoglobina) {
		this.hemoglobina = hemoglobina;
	}
	public BigDecimal getVcm() {
		return vcm;
	}
	public void setVcm(BigDecimal vcm) {
		this.vcm = vcm;
	}
	public BigDecimal getHcm() {
		return hcm;
	}
	public void setHcm(BigDecimal hcm) {
		this.hcm = hcm;
	}
	public BigDecimal getRdw() {
		return rdw;
	}
	public void setRdw(BigDecimal rdw) {
		this.rdw = rdw;
	}
	public BigDecimal getChcm() {
		return chcm;
	}
	public void setChcm(BigDecimal chcm) {
		this.chcm = chcm;
	}
	public BigDecimal getLeucocitosTotais() {
		return leucocitosTotais;
	}
	public void setLeucocitosTotais(BigDecimal leucocitosTotais) {
		this.leucocitosTotais = leucocitosTotais;
	}
	public BigDecimal getBasofilo() {
		return basofilo;
	}
	public void setBasofilo(BigDecimal basofilo) {
		this.basofilo = basofilo;
	}
	public BigDecimal getBastonete() {
		return bastonete;
	}
	public void setBastonete(BigDecimal bastonete) {
		this.bastonete = bastonete;
	}
	public BigDecimal getBlastos() {
		return blastos;
	}
	public void setBlastos(BigDecimal blastos) {
		this.blastos = blastos;
	}
	public BigDecimal getEosinofilos() {
		return eosinofilos;
	}
	public void setEosinofilos(BigDecimal eosinofilos) {
		this.eosinofilos = eosinofilos;
	}
	public BigDecimal getLinfocitos() {
		return linfocitos;
	}
	public void setLinfocitos(BigDecimal linfocitos) {
		this.linfocitos = linfocitos;
	}
	public BigDecimal getMetamielocitos() {
		return metamielocitos;
	}
	public void setMetamielocitos(BigDecimal metamielocitos) {
		this.metamielocitos = metamielocitos;
	}
}