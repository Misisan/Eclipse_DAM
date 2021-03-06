package inicio;

import java.awt.List;
import java.sql.Date;
import org.hibernate.Session;

public class aad_5B_masimeon {

	public static void main(String[] args) {
		
		//Iniciamos la sesi�n de Hibernate
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//Iniciamos la transacci�n para poder trabajar
		session.beginTransaction();
		
		Pedido p1 = new Pedido(Date.valueOf("2017-01-15"));
		p1.getItem().add(new Item("Caucho blanco", 99));
		
		//guardamos el objeto creado en la session abierta
		session.save(p1);
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
	
		//Cerramos la sesi�n de Hibernate
		session.close();
		//Cerramos la sesi�n del Factory
		HibernateUtilities.getSessionFactory().close();
	
	}

}
