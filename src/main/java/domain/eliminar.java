package domain;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class eliminar {

	public static void main(String[] args) {
		
		
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	        EntityManager manager = factory.createEntityManager();

	        EntityTransaction tx = manager.getTransaction();
	        tx.begin();

	        Long empleadoId = 1L; 

	        Empleado empleado = manager.find(Empleado.class, empleadoId);
	        if (empleado != null) {
	            manager.remove(empleado);
	        }

	        tx.commit();
	        
	        List<Empleado> lista = manager.createQuery("from Empleado", Empleado.class).getResultList();
			for (Empleado departamento : lista) {
				System.out.println(departamento);
			}

	        factory.close();

	}

}
