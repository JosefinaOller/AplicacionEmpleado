package vistaEmpleado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	//Boton
	private JButton siguienteUsuario;
	private JButton siguienteDocumento;
	//Controlador
	private ActionListener actionlistener;
	//Textos
	private JTextPane documentoUsuario;
	private JTextPane boxEmpleado;

	
	public void limpiarDNI() {
		this.documentoUsuario.setText(""); 
		
	}
	public VentanaPrincipal() {
		setTitle("EMPLEADO");
		setBackground(new Color(255, 250, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel panel_5 = new Panel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel panel_7 = new Panel();
		panel_5.add(panel_7);
		
		JLabel lblNewLabel = new JLabel("BOX");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 40));
		panel_7.add(lblNewLabel);
		
		Panel panel_8 = new Panel();
		panel_5.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		boxEmpleado = new JTextPane();
		boxEmpleado.setEditable(false);
		boxEmpleado.setForeground(Color.RED);
		boxEmpleado.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 35));
		panel_8.add(boxEmpleado);
		
		Panel panel_6 = new Panel();
		panel.add(panel_6);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 240));
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("TURNO");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 35));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 250, 240));
		contentPane.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_3.add(panel_2);
		
		siguienteUsuario= new JButton("SIGUIENTE");
		panel_2.add(siguienteUsuario);
		siguienteUsuario.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		this.siguienteUsuario.setActionCommand("Siguiente usuario");
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "DOCUMENTO DEL CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(255, 250, 240));
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		documentoUsuario = new JTextPane();
		documentoUsuario.setEditable(false);
		documentoUsuario.setForeground(Color.BLACK);
		documentoUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 30));
		panel_4.add(documentoUsuario);
		
		this.setVisible(true);
		this.setMaximumSize(this.getSize());
		
	}
	
	public void setActionlistener(ActionListener actionlistener) {
		this.siguienteUsuario.addActionListener(actionlistener);

		this.actionlistener = actionlistener;
	}
	
	public void setBox(String box) {
		this.boxEmpleado.setText("Nº: " + box);
	}
	
	public void setDocumentoUsuario(String documento) {
		this.documentoUsuario.setText(""); //limpio
		this.documentoUsuario.setText("DNI: " + documento);
	}

}

