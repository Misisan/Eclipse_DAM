
public class Cumple {

	
// VARIABLES
	
	private String nombre;
	private int edad;
	private int dia;
	private int mes;
	private int ano;

// CONSTRUCTOR
	
	public Cumple() {
	}

	
// MÉTODOS
	
	//Variable nombre
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getNombre(){
		return nombre;
	}
	
	//Variable edad
	public void setEdad(int edad){
		if(edad<0){
			this.edad=0;
		}else{
		this.edad = edad;
		}
	}
	public int getEdad(){
		return edad;
	}
	
	//Variable mes
	public void setMes(int mes){
		if(mes<1){
			this.mes = 1;
		}else if (mes>12){
			this.mes = 12;
		}else{
		this.mes = mes;
		}
	}
	public int getMes(){
		return mes;
	}
	
	//Variable año/ano
	public void setAno(int ano){
		this.ano = ano;
	}
	public int getAno(){
		return ano;
	}
	
	//Variable dia
		public void setDia(int dia){
			if(dia<1){
				this.dia = 1;
			}else if (dia>28){
				switch (mes){
				case 2:
					if (ano % 4 == 0){
						if (ano % 100 == 0){
							if (ano % 400 == 0){
								this.dia = 29;
								break;
							}else{
								this.dia = 28;
								break;
							}
						}else{
							this.dia = 29;
							break;
						}
					}else{
						this.dia = 28;
						break;
					}
				}
			}else if (dia>29){
				switch (mes){
					case 1:
						this.dia=31;
						break;
					case 3:
						this.dia = 31;
						break;
					case 4:
						this.dia = 30;
						break;
					case 5:
						this.dia = 31;
						break;
					case 6:
						this.dia = 30;
						break;
					case 7:
						this.dia = 31;
						break;
					case 8:
						this.dia = 31;
						break;
					case 9:
						this.dia = 30;
						break;
					case 10:
						this.dia = 31;
						break;
					case 11:
						this.dia = 30;
						break;
					case 12:
						this.dia = 31;
				}	
					
			}else{
			this.dia = dia;
			}
		}
		public int getDia(){
			return dia;
		}
		
	

}
