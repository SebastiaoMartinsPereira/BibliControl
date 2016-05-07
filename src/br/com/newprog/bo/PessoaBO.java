package br.com.newprog.bo;

import java.util.List;
import java.util.Observable;

import br.com.newprog.dao.PessoaDAO;
import br.com.newprog.model.Pessoa;

public class PessoaBO extends Observable {

	private static PessoaBO instance;

    private PessoaBO() {
    	
    }

    public static PessoaBO getInstance() {
        if (instance == null) {
            instance = new PessoaBO();
        }
        return instance;
    }
    
    //Chama a daoPessoa e retorna a lista de pessoas
    public List<Pessoa> getClientes() {
    	PessoaDAO dao = PessoaDAO.getInstance();
        return dao.getLista();
    }
    
    public Pessoa salvar(Pessoa pessoa) {
    	PessoaDAO dao = PessoaDAO.getInstance();
    	dao.adiciona(pessoa);
    	setChanged();
    	notifyObservers();
        return pessoa;
    }

    public void remover(Pessoa pessoa) {
    	PessoaDAO dao = PessoaDAO.getInstance();
    	dao.remover(pessoa);
    	setChanged();
    	notifyObservers();
    }
    
}
