package br.com.newprog.bo;

import java.util.List;
import java.util.Observable;

import br.com.newprog.dao.UsuarioDAO;
import br.com.newprog.model.Usuario;

public class UsuarioBO extends Observable{

	private static UsuarioBO instance;
	
	public UsuarioBO() {
    	
    }

	public static UsuarioBO getInstance() {
		if (instance == null) {
			instance = new UsuarioBO();
		}
		return instance;
	}

	// Chama a daoPessoa e retorna a lista de pessoas
	public List<Usuario> getPessoa() {
		UsuarioDAO dao = UsuarioDAO.getInstance();
		return dao.getUsuarios();
	}

	public Usuario salvar(Usuario usuario) {
		UsuarioDAO dao = UsuarioDAO.getInstance();
		dao.adiciona(usuario);
		setChanged();
		notifyObservers();
		return usuario;
	}

	public void remover(Usuario usuario) {
		UsuarioDAO dao = UsuarioDAO.getInstance();
		dao.remover(usuario);
		setChanged();
		notifyObservers();
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomeIdUsuario() {
		UsuarioDAO dao = UsuarioDAO.getInstance();
		return dao.getNomes();
	}

}
