package repositorios;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public abstract class Repositorio<T, U> {
	protected EntityManager em;

	public abstract Class<T> minhaClasse();

	public void save(T aluno) {
		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();
	}

	public List<T> findAll() {
		return this.em.createQuery("Select Fulano from " + minhaClasse().getSimpleName() + " Fulano ", minhaClasse())
				.getResultList();
	}

	public void atualiza(T aluno) {
		this.em.getTransaction().begin();
		this.em.merge(aluno);
		this.em.getTransaction().commit();
	}
	public T findById(U id) {
		return this.em.find(minhaClasse(), id);
	}
	public void remove(T aluno) {
		this.em.getTransaction().begin();
		this.em.remove(aluno);
		this.em.getTransaction().commit();
	}
	public List<T> buscaGenerica(Map<String,Object> params) {
		String query = "Select * from tabela where "+ params.keySet().stream().map(k -> k + " = ?").collect(Collectors.joining(" and "));
		this.em.createNativeQuery(query);
		int i = 1;
		for (String key:params.keySet()) {
			System.out.println(i + " "+params.get(key));
			i+=1;
		}
		return null;
	}
}