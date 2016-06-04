package br.com.newprog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.newprog.model.Item;

public class ItemDAO {
	private static ItemDAO instance;

	protected EntityManager entityManager;

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("impacta-unit");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Cria o SingleTon
	public static ItemDAO getInstance() {
		if (instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}

	// Private para que apenas a classe tenha acesso.
	public ItemDAO() {
		entityManager = getEntityManager();
	}

	public String adiciona(Item obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		return "view/listaItens.jsp";
	}

	public void remover(Item obj) {
		Object c = entityManager.merge(obj);	
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();
	}

	public String altera(Item obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		return "view/listaItens.jsp";
	}

	public Item find(Long id) {
		return entityManager.find(Item.class, id);
	}

	/** Recupera a lista de Items da base de dados */
	public List<Item> getItems() {
		@SuppressWarnings("unchecked")
		List<Item> lista = entityManager.createQuery("Select p from Item as p").getResultList();
		return lista;
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomes() {

		return entityManager.createQuery("select new List(" + "p.id," + "p.descricao) from Item as p", List.class)
				.getResultList();

	}
}
