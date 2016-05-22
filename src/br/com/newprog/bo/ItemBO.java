package br.com.newprog.bo;

import java.util.List;
import java.util.Observable;

import br.com.newprog.dao.ItemDAO;
import br.com.newprog.model.Item;

public class ItemBO extends Observable {

	private static ItemBO instance;

	public ItemBO() {

	}

	public static ItemBO getInstance() {
		if (instance == null) {
			instance = new ItemBO();
		}
		return instance;
	}

	// Chama a daoItem e retorna a lista de objs
	public List<Item> getItem() {
		ItemDAO dao = ItemDAO.getInstance();
		return dao.getItems();
	}

	public Item salvar(Item obj) {
		ItemDAO dao = ItemDAO.getInstance();
		dao.adiciona(obj);
		setChanged();
		notifyObservers();
		return obj;
	}

	public void remover(Item obj) {
		ItemDAO dao = ItemDAO.getInstance();
		dao.remover(obj);
		setChanged();
		notifyObservers();
	}

	public Item find(long id) {
		return new ItemDAO().find(id);
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomeIdItem() {
		ItemDAO dao = ItemDAO.getInstance();
		return dao.getNomes();
	}
}
