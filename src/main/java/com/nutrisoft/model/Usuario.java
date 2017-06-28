package com.nutrisoft.model;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.crypto.codec.Hex;

import com.nutrisoft.model.enums.PerfilEnum;

@Entity
@Table(name="Usuario")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="idUsuario", referencedColumnName="idPessoa")
public class Usuario extends Pessoa {

	@Column(name="login")
	private String login;

	@Column(name="senha")
	private String senha;

	@Column(name="perfil")
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoAcesso;

	@PrePersist
	protected void onCreate()
	{
		dataUltimoAcesso = new Date();
	}

	@PreUpdate
	protected void onUpdate()
	{
		dataUltimoAcesso = new Date();
	}

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

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	@Override
	public String toString() {
		return this.toString() + " - Usuario [login=" + login +", senha=" + senha + ", perfil=" + perfil+ ", dataUltimoAcesso=" + dataUltimoAcesso + "]";
	}

	public static String getSenhaMD5(String senha) throws Exception {
		final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(senha.getBytes(Charset.forName("UTF8")));
		final byte[] resultByte = messageDigest.digest();
		final String result = new String(Hex.encode(resultByte));
		
		return result;
	}
}
