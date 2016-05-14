package br.com.newprog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "usuario_id_seq", allocationSize = 1, initialValue = 0)
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String login;
	
	@Column
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	
}
