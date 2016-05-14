package br.com.newprog.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.newprog.model.Enums.TipoPessoa;

@Entity
@SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "PESSOA_SEQ", allocationSize = 1, initialValue = 0)
public class Pessoa {

	@Id
/*	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")*/
	private long id;

	@OneToOne(cascade = javax.persistence.CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private Date dataCadastro;
	private TipoPessoa tipo;
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

	private Pessoa(PessoaBuilder builder) {
		this.setCpf(builder.cpf);
		this.setRg(builder.rg);
		this.setEmail(builder.email);
		this.setNome(builder.nome);
		this.setTel_fixo(builder.tel_fixo);
		this.setTel_celular(builder.tel_celular);
		this.setTipo(builder.tipo);
		new Date();
		this.setDataCadastro(Date.from(Instant.now()));
	}

	
	public Pessoa(){}
	
	public static class PessoaBuilder {

		// parametros obrigatorios
		private String nome;
		private String cpf;

		// parametros opcionais
		private String rg;
		private String email;
		private TipoPessoa tipo;
		private String tel_fixo;
		private String tel_celular;

		public PessoaBuilder(String nome, String cpf) {
			this.nome = nome;
			this.cpf = cpf;
		}

		public PessoaBuilder comRg(String rg) {
			this.rg = rg;
			return this;
		}

		public PessoaBuilder comEmail(String email) {
			this.email = email;
			return this;
		}

		public PessoaBuilder comTipo(TipoPessoa tipo) {
			this.tipo = tipo;
			return this;
		}

		public PessoaBuilder comTel(String tel_fixo) {
			this.tel_fixo = tel_fixo;
			return this;
		}

		public PessoaBuilder comCelular(String celular) {
			this.tel_celular = celular;
			return this;
		}

		public Pessoa builder() {
			return new Pessoa(this);
		}

	}
}
