package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JPAUtil;

public class ConsultaModeloCarroPeloFabricanteEspecificoComFiltroIn {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		List<String> modelosEspecificos = em.createQuery(
				"select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'honda' and mc.categoria in ('sedan_medio','sedan_grande')",
				String.class).getResultList();

		for (String modelo : modelosEspecificos) {
			System.out.println(modelo);
		}

		em.close();
	}

}
