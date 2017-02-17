package inicio;


import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class aad_5D_masimeon {

	public static void main(String[] args) {
		
		//Iniciamos la sesión de Hibernate
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//Añadimos empresas a la BBDD
		CrearEmpresas(session);
		
		//Consultas a la BBDD
		ConsultaCIF(session, 32345678);
		ConsultaPedidos(session, 12345678);
		ConsultaNombre(session, "B");
		
		//Cerramos la sesión de Hibernate
		session.close();
		//Cerramos la sesión del Factory
		HibernateUtilities.getSessionFactory().close();
	
	}
	
	//Método para consultar en BBDD una Empresa según su CIF
	public static void ConsultaCIF(Session session, Integer cif){
		
		//Iniciamos la transacción para poder trabajar
		session.beginTransaction();
		
		//Definimos la query de la consulta en HQL de hibernate
		Query consulta = session.createQuery("select empresa from Empresa as empresa where empresa.cif=:n").setInteger("n", cif);
		
		List<Empresa> resultados = consulta.list();
		
		for (Empresa e: resultados){
			System.out.println(e.getNombre());
		}
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
	}

	//Método para consultar en BBDD Pedidos de una empresa según su CIF
	public static void ConsultaPedidos(Session session, Integer cif){
		
		//Iniciamos la transacción para poder trabajar
		session.beginTransaction();
		
		//Definimos la query de la consulta en HQL de hibernate
		Query consulta = session.createQuery("select pedido from Pedido as pedido where pedido.emp.cif = :n").setInteger("n", cif);
		
		List<Pedido> resultados = consulta.list();
		
		for (Pedido p: resultados){
			System.out.println(p.getId()+" - "+p.getFecha()+" - "+p.getEmp());
		}
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
	}
	
	//Método para consultar en BBDD la Empresa según como empiece su nomrbe
	public static void ConsultaNombre(Session session, String n){
		
		//Iniciamos la transacción para poder trabajar
		session.beginTransaction();
		
		//Definimos la query de la consulta en HQL de hibernate
		Query consulta = session.createQuery("select empresa from Empresa as empresa where empresa.nombre like :n").setString("n", n+"%");
		
		List<Empresa> resultados = consulta.list();
		
		for (Empresa e: resultados){
			System.out.println(e.getNombre());
		}
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
	}
	
	//Método para crear las empresas y pedidos
	public static void CrearEmpresas(Session session){
		
		//Iniciamos la transacción para poder trabajar
		session.beginTransaction();
		
		Empresa e1 = new Empresa("Empresa Guay S.L.", 12345678, 59, "C/ Enmigdelterme sn", "En mig del Terme", 46000);
		e1.addPedido(new Pedido(Date.valueOf("2017-01-15")));
		e1.addPedido(new Pedido(Date.valueOf("2017-01-16")));
		e1.addPedido(new Pedido(Date.valueOf("2017-01-17")));
		e1.addPedido(new Pedido(Date.valueOf("2017-01-18")));
		
		Empresa e2 = new Empresa("Dislexicos udinos S.A.", 22345678, 5, "Polígono Lo lo ló", "En un lugar desconocido", 46000);
		e2.addPedido(new Pedido(Date.valueOf("2017-02-12")));
		
		Empresa e3 = new Empresa("En un lugar muy lejano S.L.L.", 32345678, 34, "C/ Persépolis 15", "Puf, a saber", 46000);
		e3.addPedido(new Pedido(Date.valueOf("2017-02-10")));
		
		Empresa e4 = new Empresa("Back to the Future", 42345678, 22, "C/ Doc", "El Futuro City", 46000);
		e4.addPedido(new Pedido(Date.valueOf("2017-02-13")));
		
		
		//guardamos el objeto creado en la session abierta
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		
		//Ejecutamos todo con el commit
		session.getTransaction().commit();
		
	}
}
