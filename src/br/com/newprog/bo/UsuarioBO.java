package br.com.newprog.bo;

import java.util.List;
import java.util.Observable;

import br.com.newprog.dao.UsuarioDAO;
import br.com.newprog.model.Usuario;

public class UsuarioBO extends Observable {

	private static UsuarioBO instance;

	public UsuarioBO() {

	}

	public static UsuarioBO getInstance() {
		if (instance == null) {
			instance = new UsuarioBO();
		}
		return instance;
	}
 
	public List<Usuario> getUsuario() {
		UsuarioDAO dao = UsuarioDAO.getInstance();
		return dao.getUsuarios();
	}

	public String salvar(Usuario usuario) {
		String page = UsuarioDAO.getInstance().adiciona(usuario);
		setChanged();
		notifyObservers();
		return page;
	}
	
	public String alterar(Usuario usuario){
		return UsuarioDAO.getInstance().altera(usuario);
	}

	public void remover(Usuario usuario) {
		UsuarioDAO dao = UsuarioDAO.getInstance();
		dao.remover(usuario);
		setChanged();
		notifyObservers();
	}
	
    public Usuario find(long id){
    	return new UsuarioDAO().find(id);
    }
    
	@SuppressWarnings("rawtypes")
	public List<List> getNomeIdUsuario() {
		return UsuarioDAO.getInstance().getNomes();
	}

	public Usuario getById(long id) {
		return UsuarioDAO.getInstance().findById(id);
	}

	
	public Usuario getUsuario(Usuario obj) {
		return UsuarioDAO.getInstance().findByIdAndlogin(obj);
	}

}
