package br.com.newprog.bo;

import java.util.List;
import java.util.Observable;

import br.com.newprog.dao.EmprestimoDAO;
import br.com.newprog.model.Emprestimo;

public class EmprestimoBO extends Observable {

	private static EmprestimoBO instance;

	public EmprestimoBO() {

	}

	public static EmprestimoBO getInstance() {
		if (instance == null) {
			instance = new EmprestimoBO();
		}
		return instance;
	}

	// Chama a daoEmprestimo e retorna a lista de objs
	public List<Emprestimo> getEmprestimo() {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		return dao.getEmprestimos();
	}
	
	// Chama a daoEmprestimo e retorna a lista de objs
	@SuppressWarnings("rawtypes")
	public List<List> getEmprestimo(long pessoa_id) {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		return dao.getEmprestimos(pessoa_id);
	}
	

	public String salvar(Emprestimo obj) {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		String page = dao.adiciona(obj);
		setChanged();
		notifyObservers();
		return page;
	}

	public String alterar(Emprestimo obj) {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		String page = dao.altera(obj);
		setChanged();
		notifyObservers();
		return page;
	}

	public void remover(Emprestimo obj) {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		dao.remover(obj);
		setChanged();
		notifyObservers();
	}

	public Emprestimo find(long id) {
		return new EmprestimoDAO().find(id);
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomeIdEmprestimo() {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		return dao.getNomes();
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomeId(String nome) {
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		return dao.getNomes(nome);
	}

}
