package br.com.newprog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.newprog.model.Pessoa;

public class PessoaDAO {

	// declara o objeto static privado para que apenas a classe tenha acesso.
	private static PessoaDAO instance;

	protected EntityManager entityManager;

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("impacta-unit");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Cria o SingleTon
	public static PessoaDAO getInstance() {
		if (instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}

	// Private para que apenas a classe tenha acesso.
	public PessoaDAO() {
		entityManager = getEntityManager();
	}

	public String adiciona(Pessoa pessoa) {
		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();
		entityManager.close();
		return "view/listaPessoas.jsp";
	}

	public void remover(Pessoa pessoa) {
		Object c = entityManager.merge(pessoa);		
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();
	}

	public String altera(Pessoa pessoa) {
		entityManager.getTransaction().begin();
		entityManager.merge(pessoa);
		entityManager.getTransaction().commit();
		return "view/listaPessoas.jsp";
	}

	public Pessoa find(Long id){

		try {
			return entityManager.find(Pessoa.class, id);
		} catch (Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}
		
	}
	
	/** Recupera a lista de Pessoas da base de dados */
	public List<Pessoa> getPessoas() {
		@SuppressWarnings("unchecked")
		List<Pessoa> lista = entityManager.createQuery(
				"Select p from Pessoa as p").getResultList();
		return lista;
	}

	@SuppressWarnings("rawtypes")
	public List<List> getNomes() {
		return entityManager.createQuery(
				"select new List(" + "p.id," + "p.nome) from Pessoa as p",
				List.class).getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	public List<List> getNomes(String nome) {
		return entityManager.createQuery(
				"select new List(" + "p.id,p.nome,p.tipo) from Pessoa as p where p.nome like :nome",
				List.class)
				.setParameter("nome", nome + "%")
				.getResultList();
	}
	
}
