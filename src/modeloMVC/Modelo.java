package modeloMVC;

import modelo.Empleado;

public class Modelo {
	
	private static Modelo instancia=null; //aplico el patr�n Singleton para instanciar por �nica vez
	private Empleado empleado=null;
	
	
	
	private Modelo() {}



	public static Modelo getInstancia() {
		if(instancia==null)
			instancia=new Modelo();
		return instancia;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public static void setInstancia(Modelo instancia) {
		Modelo.instancia = instancia;
	}
	
	

}
