package br.com.newprog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.newprog.model.Emprestimo;

public class EmprestimoDAO {

	private static EmprestimoDAO instance;

	protected EntityManager entityManager;

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("impacta-unit");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Cria o SingleTon
	public static EmprestimoDAO getInstance() {
		if (instance == null) {
			instance = new EmprestimoDAO();
		}
		return instance;
	}

	// Private para que apenas a classe tenha acesso.
	public EmprestimoDAO() {
		entityManager = getEntityManager();
	}

	public String adiciona(Emprestimo obj) {
		Object c = entityManager.merge(obj);
		entityManager.getTransaction().begin();
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		return "view/listaItens.jsp";
	}

	public void remover(Emprestimo obj) {
		Object c = entityManager.merge(obj);	
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();
	}

	public String altera(Emprestimo obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		return "view/listaItens.jsp";
	}

	public Emprestimo find(Long id) {
		return entityManager.find(Emprestimo.class, id);
	}

	/** Recupera a lista de Emprestimos da base de dados */
	public List<Emprestimo> getEmprestimos() {
		@SuppressWarnings("unchecked")
		List<Emprestimo> lista = entityManager.createQuery("Select p from Emprestimo as p").getResultList();
		return lista;
	}

	
	@SuppressWarnings("rawtypes")
	public List<List> getEmprestimos(long pessoa_id)  {

		return entityManager.createQuery("select new List(p.id,p.dataDevoluvao,p.dataEmprestimo,p.item_id,p.pessoa_id) from Emprestimo as p where p.pessoa_id = ? AND p.entregue = 0", List.class)
				.setParameter(1, pessoa_id)
				.getResultList();

	}
	
	@SuppressWarnings("rawtypes")
	public List<List> getNomes() {
		return entityManager.createQuery("select new List(" + "p.id," + "p.descricao) from Emprestimo as p", List.class)
				.getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	public List<List> getNomes(String nome) {
		return entityManager.createQuery("select new List(" + "p.id,p.descricao,p.tipo,p.especial) from Emprestimo as p where p.descricao like :nome"
		, List.class)
				.setParameter("nome", nome + "%")
				.getResultList();

	}
	
}
