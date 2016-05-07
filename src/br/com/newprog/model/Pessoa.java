package br.com.newprog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.newprog.model.Enums.TipoPessoa;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private Date dataCadastro;
	private TipoPessoa tipo ;
	private String tel_fixo;
	private String tel_celular;
	
	public long getId() {
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public TipoPessoa getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	public String getTel_fixo() {
		return tel_fixo;
	}
	
	public void setTel_fixo(String tel_fixo) {
		this.tel_fixo = tel_fixo;
	}
	
	public String getTel_celular() {
		return tel_celular;
	}
	
	public void setTel_celular(String tel_celular) {
		this.tel_celular = tel_celular;
	}

	
	
}
