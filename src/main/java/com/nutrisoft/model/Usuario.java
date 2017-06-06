package com.nutrisoft.model;

import java.sql.Timestamp;

import com.nutrisoft.model.enums.PerfilEnum;

public class Usuario extends Pessoa {
	
	private String login;
	private String senha;
	private PerfilEnum perfil;
	private Timestamp dataUltimoAcesso;
	private String tokenEsqueciSenha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	public Timestamp getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}
	public void setDataUltimoAcesso(Timestamp dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}
	public String getTokenEsqueciSenha() {
		return tokenEsqueciSenha;
	}
	public void setTokenEsqueciSenha(String tokenEsqueciSenha) {
		this.tokenEsqueciSenha = tokenEsqueciSenha;
	}
}