package Jugador;
import javax.swing.ImageIcon;

//DEFINICIÓN DE CLASE
public class Jugador { //Definimos una class nueva llamada Jugador

//DEFINICIÓN DE OBJETOS**********************************************************************************DEFINICIÓN OBJETOS
	
	private ImageIcon foto;
	
//FIN DEFINICIÓN OBJETOS---------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//DECLARACIÓN DE VARIABLES****************************************************************************************VARIABLES
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int puntos;
	private boolean flag=false;
	private String contestacion;
	
//FIN DECLARACIÓN VARIABLES--------------------------------------------------------------------------------------VARIABLES	

//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	public Jugador() {
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
	
//MÉTODOS**********************************************************************************************************MÉTODOS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		if (nombre.length()==0){
			flag=true;
		}
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
		if (apellido1.length()==0){
			flag=true;
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad<0){
			this.edad=0;
			flag=true;
		}else{
			this.edad = edad;
		}
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public boolean getFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public String getContestacion() {
		return "Error. Falta introducir datos.";
	}


	public void setContestacion(String contestacion) {
		this.contestacion = contestacion;
	}

	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString(){
		return this.id+": "+this.nombre+" "+this.apellido1;
	}
	
//FIN MÉTODOS------------------------------------------------------------------------------------------------------MÉTODOS
}