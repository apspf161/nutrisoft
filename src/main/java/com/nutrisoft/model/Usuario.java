package com.nutrisoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
/*	@Column(name="USUARIO")
	private Usuario usuario;*/
	
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "EMAIL", nullable = false, length = 50)
	private String email;
	
	@Column(name = "SENHA", nullable = false, length = 10)
	private String senha;

	@Column(name = "PERFIL", nullable = false, length = 50)
	private String perfil;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ULTIMO_ACESSO")
	private Date dtUltimoAcesso;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Date getDtUltimoAcesso() {
		return dtUltimoAcesso;
	}

	public void setDtUltimoAcesso(Date dtUltimoAcesso) {
		this.dtUltimoAcesso = dtUltimoAcesso;
	}

	
}
