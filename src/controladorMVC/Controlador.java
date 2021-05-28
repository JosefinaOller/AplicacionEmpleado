package controladorMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import modelo.Empleado;
import modeloMVC.Modelo;
import vista.ventanaPrincipal;

/**
 * @author Grupo 7
 * <br>
 *Clase que representa el controlador que cumple su función de controlar y gestionar datos al modelo
 */
public class Controlador implements ActionListener,Runnable{

	protected Modelo sistema;
	private ventanaPrincipal vistaPrincipal;
	
	public Controlador() {
		this.vistaPrincipal = new ventanaPrincipal();
		vistaPrincipal.setActionlistener(this);
		sistema = Modelo.getInstancia();
		String box = JOptionPane.showInputDialog("Escribe tu box");
		sistema.setEmpleado(new Empleado(Integer.parseInt(box)));
		this.vistaPrincipal.setBox(box);
	}

	
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equalsIgnoreCase("Siguiente usuario")) {
			this.vistaPrincipal.limpiarDNI();
			try {
				
				Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),asignarPuerto()); //puerto 1230 es para el empleado
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //inicia el flujo para enviar los mensajes
		        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Se obtiene el flujo entrante desde el cliente
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
	        	JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 2.EMPLEADO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

				//e1.printStackTrace();
			} catch (IOException e1) {
	        	JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 3.EMPLEADO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

				//e1.printStackTrace();
			}
			
		}		
	
		
	}

	private int asignarPuerto() {
		return sistema.getEmpleado().getPuerto();
	}

	private void setDocumentoUsuario(String documento) {
		this.vistaPrincipal.setDocumentoUsuario(documento);
	}

	
	
	public static void main(String[] args) {
			Controlador c= new Controlador();
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
