package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JPAUtil;

public class ConsultaFabricante {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<String> nomeFabricantes = em.createQuery("select f.nome from Fabricante f", String.class).getResultList();
		
		for(String nome : nomeFabricantes) {
			System.out.println("\nFabricante: " + nome);
		}
		em.close();

	}

}
