package gestionficherosapp;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

import gestionficheros.FormatoVistas;
import gestionficheros.GestionFicheros;
import gestionficheros.GestionFicherosException;
import gestionficheros.TipoOrden;

public class GestionFicherosImpl implements GestionFicheros {
	private File carpetaDeTrabajo = null;
	private Object[][] contenido;
	private int filas = 0;
	private int columnas = 3;
	private FormatoVistas formatoVistas = FormatoVistas.NOMBRES;
	private TipoOrden ordenado = TipoOrden.DESORDENADO;

	public GestionFicherosImpl() {
		carpetaDeTrabajo = File.listRoots()[0];
		actualiza();
	}

	private void actualiza() {

		String[] ficheros = carpetaDeTrabajo.list(); // obtener los nombres
		// calcular el número de filas necesario
		filas = ficheros.length / columnas;
		if (filas * columnas < ficheros.length) {
			filas++; // si hay resto necesitamos una fila más
		}

		// dimensionar la matriz contenido según los resultados

		contenido = new String[filas][columnas];
		// Rellenar contenido con los nombres obtenidos
		for (int i = 0; i < columnas; i++) {
			for (int j = 0; j < filas; j++) {
				int ind = j * columnas + i;
				if (ind < ficheros.length) {
					contenido[j][i] = ficheros[ind];
				} else {
					contenido[j][i] = "";
				}
			}
		}
	}

	@Override
	public void arriba() {

		System.out.println("holaaa");
		if (carpetaDeTrabajo.getParentFile() != null) {
			carpetaDeTrabajo = carpetaDeTrabajo.getParentFile();
			actualiza();
		}

	}

	@Override
	public void creaCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo,arg0);
		//que se pueda escribir -> lanzará una excepción
		//que no exista -> lanzará una excepción
		//crear la carpeta -> lanzará una excepción
		actualiza();
	}

	@Override
	public void creaFichero(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void entraA(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo, arg0);
		// se controla que el nombre corresponda a una carpeta existente
		if (!file.isDirectory()) {
			throw new GestionFicherosException("Error. Se ha encontrado "
					+ file.getAbsolutePath()
					+ " pero se esperaba un directorio");
		}
		// se controla que se tengan permisos para leer carpeta
		if (!file.canRead()) {
			throw new GestionFicherosException("Alerta. No se puede acceder a "
					+ file.getAbsolutePath() + ". No hay permiso");
		}
		// nueva asignación de la carpeta de trabajo
		carpetaDeTrabajo = file;
		// se requiere actualizar contenido
		actualiza();

	}

	@Override
	public int getColumnas() {
		return columnas;
	}

	@Override
	public Object[][] getContenido() {
		return contenido;
	}

	@Override
	public String getDireccionCarpeta() {
		return carpetaDeTrabajo.getAbsolutePath();
	}

	@Override
	public String getEspacioDisponibleCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEspacioTotalCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFilas() {
		return filas;
	}

	@Override
	public FormatoVistas getFormatoContenido() {
		return formatoVistas;
	}

	@Override
	public String getInformacion(String ficheroSeleccionado) throws GestionFicherosException {
		//Recordar que el throws de arriba hace que si hay un error este se envie al lugar que ha
		//llamado a este método, donde habrá un try&catch para recibirlo
		
		//Primero creamos un objeto StringBuilder para realizar la concatenación de
		//la info que saldrá en la ventana de propiedades
		StringBuilder infoConcatenada=new StringBuilder();
		
		//Definimos un objeto tipo fichero para poder obtener la información de él
		File file = new File(carpetaDeTrabajo,ficheroSeleccionado);
	
		//Lanzamos excepciones para controlar los posibles errores
			//Lanzamos una excepción para asegurarnos que el fichero existe
			if (!file.exists()) {
				throw new GestionFicherosException("El fichero no existe");
			}
			
			//Lanzamos una excepción para comprobar los permisos de lectura sobre la carpeta de origen
			if (!carpetaDeTrabajo.canRead()) {
				throw new GestionFicherosException("No tienes permisos de lectura sobre esta carpeta: "+carpetaDeTrabajo);
			}
		
		//Con .append vamos añadiendo strings a la cadena, podríamos ir concatenando con el + también,
		//pero así queda más ordenado visualmente
		
		DecimalFormat formatoNum = new DecimalFormat("###,###.##"); //Darle formato a los números de las cantidades
		
		//TÍTULO DE LA VENTANA DE INFO
		infoConcatenada.append("INFORMACIÓN DEL SISTEMA"); 
		infoConcatenada.append("\n\n");//Recordar que \n es un salto de linea
		
		//NOMBRE DEL ARCHIVO
		infoConcatenada.append("Nombre: ");
		infoConcatenada.append(ficheroSeleccionado);
		infoConcatenada.append("\n");
		
		//TIPO DE ARCHIVO: FICHERO-CARPETA
		infoConcatenada.append("Tipo: ");
		
		//Condicionamos el texto con if
		if(file.isDirectory()){
			infoConcatenada.append("Carpeta");
		}else if(file.isFile()){
			infoConcatenada.append("Fichero");
		}else{ 
			infoConcatenada.append("Desconocido");
		}
		infoConcatenada.append("\n");
		
		//UBICACIÓN PATH COMPLETO
		infoConcatenada.append("Ubicación: ");
		infoConcatenada.append(file.getAbsolutePath());
		infoConcatenada.append("\n");
		
		//FECHA DE SU ÚLTIMA MODIFICACIÓN
		infoConcatenada.append("Última modificación: ");
		Date fechaUltModf = new Date(file.lastModified());
		infoConcatenada.append(fechaUltModf);
		infoConcatenada.append("\n");
		
		//FICHERO OCULTO
		infoConcatenada.append("Fichero oculto: ");
		if(file.isHidden()){
			infoConcatenada.append("Sí");
		}else{
			infoConcatenada.append("No");
		}
		infoConcatenada.append("\n");
		
		//INFO FICHERO
		if(file.isFile()){
			infoConcatenada.append("Tamaño: ");
			infoConcatenada.append(formatoNum.format(file.length())+" bytes");
			infoConcatenada.append("\n");
		}
		
		//INFO DIRECTORIO
		if(file.isDirectory()){
			infoConcatenada.append("Elementos internos: ");
			infoConcatenada.append(formatoNum.format(file.list().length));
			infoConcatenada.append("\n");
			infoConcatenada.append("Espacio libre: ");
			infoConcatenada.append(formatoNum.format(file.getFreeSpace())+" bytes");
			infoConcatenada.append("\n");
			infoConcatenada.append("Espacio disponible: ");
			infoConcatenada.append(formatoNum.format(file.getUsableSpace())+" bytes");
			infoConcatenada.append("\n");
			infoConcatenada.append("Espacio total: ");
			infoConcatenada.append(formatoNum.format(file.getTotalSpace())+" bytes");
			infoConcatenada.append("\n");
		}
		
		return infoConcatenada.toString();
	}

	@Override
	public boolean getMostrarOcultos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNombreCarpeta() {
		return carpetaDeTrabajo.getName();
	}

	@Override
	public TipoOrden getOrdenado() {
		return ordenado;
	}

	@Override
	public String[] getTituloColumnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUltimaModificacion(String arg0)
			throws GestionFicherosException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nomRaiz(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numRaices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void renombra(String arg0, String arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean sePuedeEjecutar(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeEscribir(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeLeer(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColumnas(int arg0) {
		columnas = arg0;

	}

	@Override
	public void setDirCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(arg0);

		// se controla que la dirección exista y sea directorio
		if (!file.isDirectory()) {
			throw new GestionFicherosException("Error. Se esperaba "
					+ "un directorio, pero " + file.getAbsolutePath()
					+ " no es un directorio.");
		}

		// se controla que haya permisos para leer carpeta
		if (!file.canRead()) {
			throw new GestionFicherosException(
					"Alerta. No se puede acceder a  " + file.getAbsolutePath()
							+ ". No hay permisos");
		}

		// actualizar la carpeta de trabajo
		carpetaDeTrabajo = file;

		// actualizar el contenido
		actualiza();

	}

	@Override
	public void setFormatoContenido(FormatoVistas arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMostrarOcultos(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOrdenado(TipoOrden arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeEjecutar(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeEscribir(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeLeer(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUltimaModificacion(String arg0, long arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

}
