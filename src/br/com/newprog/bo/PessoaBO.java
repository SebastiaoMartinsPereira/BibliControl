package br.com.newprog.bo;

import java.util.List;
import java.util.Observable;

import br.com.newprog.dao.PessoaDAO;
import br.com.newprog.model.Pessoa;

public class PessoaBO extends Observable {

	private static PessoaBO instance;

    public PessoaBO() {
    	
    }

    public static PessoaBO getInstance() {
        if (instance == null) {
            instance = new PessoaBO();
        }
        return instance;
    }
    
    //Chama a daoPessoa e retorna a lista de pessoas
    public List<Pessoa> getPessoa() {
    	PessoaDAO dao = PessoaDAO.getInstance();
        return dao.getPessoas();
    }
    
    public String salvar(Pessoa pessoa) {
    	PessoaDAO dao = PessoaDAO.getInstance();
    	String page = dao.adiciona(pessoa);
    	setChanged();
    	notifyObservers();
        return page;
    }

    public String alterar(Pessoa pessoa) {
    	PessoaDAO dao = PessoaDAO.getInstance();
    	String page = dao.altera(pessoa);
    	setChanged();
    	notifyObservers();
        return page;
    }
    
    public void remover(Pessoa pessoa) {
    	PessoaDAO dao = PessoaDAO.getInstance();
    	dao.remover(pessoa);
    	setChanged();
    	notifyObservers();
    }
    
    
    public Pessoa find(long id){
    	return new PessoaDAO().find(id);
    }
    
    @SuppressWarnings("rawtypes")
	public List<List> getNomeIdPessoa(){
    	PessoaDAO dao = PessoaDAO.getInstance();
    	return dao.getNomes();
    }
}
