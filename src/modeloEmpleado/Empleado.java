package modeloEmpleado;


public class Empleado {

	private int box;
	private int puerto;
	
	
	public Empleado(int box) {
		super();
		this.box = box;
		this.puerto = box + 1230;
	}



	public int getBox() {
		return box;
	}



	public void setBox(int box) {
		this.box = box;
	}



	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

}
