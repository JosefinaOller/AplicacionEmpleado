package main;

import controladorEmpleado.ControladorEmpleado;
import monitoreoEmpleado.ErroresEmpleado;

public class Main {

	public static void main(String[] args) {
		
		ControladorEmpleado controlador = new ControladorEmpleado();
		ErroresEmpleado error= new ErroresEmpleado(controlador);

	}

}
