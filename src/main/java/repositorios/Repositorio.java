package repositorios;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class Repositorio<T> {
	protected EntityManager em;

	public abstract Class<T> minhaClasse();

	public void save(T aluno) {
		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();
	}

	public List<T> findAll() {
		return this.em.createQuery("Select aluno from " + minhaClasse().getSimpleName() + " aluno ", minhaClasse())
				.getResultList();
	}

}
