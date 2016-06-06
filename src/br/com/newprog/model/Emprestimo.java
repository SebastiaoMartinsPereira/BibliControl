package br.com.newprog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue
	private long id;

	private Date dataEmprestimo;
	private Date dataDevoluvao;
	private boolean entregue;

	private long pessoa_id;

	private long item_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevoluvao() {
		return dataDevoluvao;
	}

	public void setDataDevoluvao(Date dataDevoluvao) {
		this.dataDevoluvao = dataDevoluvao;
	}

	public long getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(long l) {
		this.pessoa_id = l;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long l) {
		this.item_id = l;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

}
