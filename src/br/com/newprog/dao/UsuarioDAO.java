package br.com.newprog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.newprog.model.Usuario;

public class UsuarioDAO {

	// declara o objeto static privado para que apenas a classe tenha acesso.
	private static UsuarioDAO instance;

	protected EntityManager entityManager;

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("impacta-unit");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Cria o SingleTon
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	// Private para que apenas a classe tenha acesso.
	public UsuarioDAO() {
		entityManager = getEntityManager();
	}

	public String adiciona(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		return "redirect:lista-Usuarios";
	}

	public void remover(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
	}

	public String altera(Usuario Usuario) {
		entityManager.getTransaction().begin();
		entityManager.merge(Usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		return "redirect:lista-Usuarios";
	}

	/** Recupera a lista de Usuarios da base de dados */
	public List<Usuario> getUsuarios() {
		@SuppressWarnings("unchecked")
		List<Usuario> lista = entityManager.createQuery("Select p from Usuario as p").getResultList();
		return lista;
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomes() {

		return entityManager.createQuery("select new List(" + "p.id," + "p.nome) from Usuario as p", List.class)
				.getResultList();

	}

}
