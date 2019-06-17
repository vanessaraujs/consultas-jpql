package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JPAUtil;

public class ConsultaCategoriaEDescricaoDeModeloCarro {

	public static void main(String[] args) {

		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "select mc.descricao, mc.categoria from ModeloCarro mc";

		@SuppressWarnings("unchecked")
		List<Object[]> modeloCarros = em.createQuery(jpql).getResultList();

		for (Object[] object : modeloCarros) {
			System.out.println("Desrição: " + object[0] + " | " + " Categoria: " + object[1]);
		}

		em.close();
	}
}
