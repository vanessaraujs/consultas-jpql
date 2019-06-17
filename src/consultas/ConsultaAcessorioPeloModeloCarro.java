package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JPAUtil;

public class ConsultaAcessorioPeloModeloCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = ("select a.descricao from Carro c JOIN c.acessorios a where c.modeloCarro.descricao = 'cruze'");

		List<String> acessorios = em.createQuery(jpql, String.class).getResultList();
		
		for(String acessorio: acessorios) {
			System.out.println("\nAcessório: " + acessorio);
		}
		
		em.close();

	}

}
