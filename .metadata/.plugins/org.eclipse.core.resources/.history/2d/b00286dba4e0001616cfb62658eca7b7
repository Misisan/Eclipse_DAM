package inicio;

import java.sql.Date;
import org.hibernate.Session;

public class aad_5B_masimeon {

	public static void main(String[] args) {
		
		//Iniciamos la sesión de Hibernate
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//Iniciamos la transacción para poder trabajar
		session.beginTransaction();
		
		//Empresa e1 = new Empresa("Empresa de prueba 1", "12345678A", 78, "C. Desconocida sn");
		Pedido p1 = new Pedido(Date.valueOf("2017-01-15"));
		p1.getItem().setNombre("Caucho blanco");
		p1.getItem().setCantidad(99);
				
		//guardamos el objeto creado en la session abierta
		//session.save(e1);
		session.save(p1);
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
/*
		//Creamos una nueva transacción para recuperar los datos almacenados
		session.beginTransaction();
		
		//Recuperamos los datos
		//Empresa e2 = session.get(Empresa.class, "12345678A");
		Pedido p2 = session.get(Pedido.class, 1);
		
		System.out.println("Se ha recuperado el pedido de "+p2.getFecha()+" con "+p2.getItem().getCantidad()+" del ítem: "+p2.getItem().getNombre());
			
		session.getTransaction().commit();
*/		
		//Cerramos la sesión de Hibernate
		session.close();
		//Cerramos la sesión del Factory
		HibernateUtilities.getSessionFactory().close();
	
	}

}
