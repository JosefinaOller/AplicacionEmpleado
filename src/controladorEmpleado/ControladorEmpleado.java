package controladorEmpleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import modeloEmpleado.Empleado;
import modeloEmpleado.Sistema;

import vistaEmpleado.VentanaPrincipalEmpleado;


/**
 * @author Grupo 7
 * <br>
 *Clase que representa el controlador que cumple su función de controlar y gestionar datos al modelo
 */
public class ControladorEmpleado implements ActionListener{

	public Sistema sistema;
	private  VentanaPrincipalEmpleado vistaPrincipal;
	private int cambio=0;
	
	public ControladorEmpleado() {
		this.vistaPrincipal = new VentanaPrincipalEmpleado();
		vistaPrincipal.setVisible(true);
		vistaPrincipal.setActionlistener(this);
		sistema = Sistema.getInstancia();
		String box = JOptionPane.showInputDialog("Escribe tu box");
		sistema.setEmpleado(new Empleado(Integer.parseInt(box)));
		this.vistaPrincipal.setBox(box);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equalsIgnoreCase("Siguiente usuario")) {
			this.vistaPrincipal.limpiarDNI();
			try {	
				Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),asignarPuerto()); 
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
		        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		        out.println(sistema.getEmpleado().getBox()); //le mando el box
		        
		        String documento = in.readLine();
	            if(Integer.parseInt(documento)==0) { //no hay clientes esperando
	            	JOptionPane.showMessageDialog(null,"No hay cliente esperando", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
	            }
	            else { //muestro en la vista de empleado
	            		setDocumentoUsuario(documento);
	            	
	            }
	            socket.close();
	            out.close();
	            in.close();

		        
			} catch (UnknownHostException e1) {
	        	//JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 2.EMPLEADO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
	        	e1.printStackTrace();
			} catch (IOException e1) {
	        	//JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 3.EMPLEADO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
			
				
		}		
	
		
	}

	private int asignarPuerto() {
		return sistema.getEmpleado().getPuerto();
	}

	private void setDocumentoUsuario(String documento) {
		this.vistaPrincipal.setDocumentoUsuario(documento);
	}

	public void cambiarServidor() {
		if(cambio==0) {
			System.out.println("Empleado cambiando de puerto...");
			this.sistema.getEmpleado().setPuerto(asignarPuerto()+200);
			System.out.println(sistema.getEmpleado().getPuerto());
			cambio=1;
		}
		
		
	}
}
