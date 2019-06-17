package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JPAUtil;

public class ConsultaComFiltroLike {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'honda' and mc.categoria like ('%sedan%')";

		List<String> categorias = em.createQuery(jpql, String.class).getResultList();
		
		for(String categoria: categorias) {
			System.out.println(categoria);
		}
		
		em.close();

	}

}
