package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JPAUtil;

public class ConsultaFabricantePeloModeloCarro {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<String> fabricanteModelos = em.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class).getResultList();
		
		for(String fm : fabricanteModelos) {
			System.out.println("\nFabricante: " + fm);
		}
		em.close();
		
	}	
}
