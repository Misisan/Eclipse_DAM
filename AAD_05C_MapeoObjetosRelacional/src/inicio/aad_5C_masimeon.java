package inicio;

import java.awt.List;
import java.sql.Date;
import org.hibernate.Session;

public class aad_5C_masimeon {

	public static void main(String[] args) {
		
		//Iniciamos la sesi�n de Hibernate
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//Iniciamos la transacci�n para poder trabajar
		session.beginTransaction();
		
		Empresa e1 = new Empresa("Empresa Guay S.L.", 12345678, 59, "C/ Enmigdelterme sn", "En mig del Terme", 46000);
		e1.addPedido(new Pedido(Date.valueOf("2017-01-15")));
		
		//guardamos el objeto creado en la session abierta
		session.save(e1);
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
	
		//Cerramos la sesi�n de Hibernate
		session.close();
		//Cerramos la sesi�n del Factory
		HibernateUtilities.getSessionFactory().close();
	
	}

}