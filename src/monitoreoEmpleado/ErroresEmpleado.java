package monitoreoEmpleado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

import controladorEmpleado.ControladorEmpleado;

public class ErroresEmpleado {
	
	private ControladorEmpleado controladorEmpleado;
	private int puerto;
	
	public ErroresEmpleado(ControladorEmpleado controladorEmpleado) {
		this.controladorEmpleado = controladorEmpleado;
		this.setPuerto(controladorEmpleado.sistema.getEmpleado().getBox());
		recibirError();
	}

	public void recibirError() {
		new Thread() {
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(puerto); //serverSocket de empleado desde el monitor
                    while (true) {

                        Socket socket= server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String aviso=null; 
                        aviso=in.readLine();
                        if(aviso.equals("cambio"))
                        	cambioDeServidor();
                        else
                        	System.out.println("Se envio cualquier cosa");
                    }
                                                                                                                                                                                         

                } catch (Exception e) {
                	e.printStackTrace();
                    
                }
        
            }
	
        }.start();
	}

	protected void cambioDeServidor() {
		this.controladorEmpleado.cambiarServidor();
		
	}

	public ControladorEmpleado getControladorEmpleado() {
		return controladorEmpleado;
	}

	public void setControladorEmpleado(ControladorEmpleado controladorEmpleado) {
		this.controladorEmpleado = controladorEmpleado;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto+2030;
	}
	
	

	
	
}
