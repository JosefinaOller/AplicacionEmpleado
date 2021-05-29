package modeloEmpleado;

public class Sistema {
	
	private static Sistema instancia=null; //aplico el patrón Singleton para instanciar por única vez
	private Empleado empleado=null;
	
	private Sistema() {}



	public static Sistema getInstancia() {
		if(instancia==null)
			instancia=new Sistema();
		return instancia;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public static void setInstancia(Sistema instancia) {
		Sistema.instancia = instancia;
	}
	
}
