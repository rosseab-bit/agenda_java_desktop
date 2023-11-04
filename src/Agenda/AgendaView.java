package Agenda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AgendaView {

	private JFrame frame;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldDNI;
	private JTextField textFieldFechaNac;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldBuscarDNI;
	private JTextField textFieldActualizarDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaView window = new AgendaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgendaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/* prueba de conexion a la base de datos */
		String servidor = "localhost:3306";
		String baseDatos = "agenda";
		String usuario = "ricardo";
		String clave = "1234ricardo*";
		String url = "jdbc:mysql://" + servidor + "/" +baseDatos+"?serverTimezone=America/Argentina/Buenos_Aires";
		java.sql.Connection cnx;
		try
		{
		cnx = java.sql.DriverManager.getConnection(url, usuario, clave);
		System.out.println("Connect mysql success");
		}
		catch (java.sql.SQLException ex)
		{
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
		}
		/* prueba de conexion a la base de datos */
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 706, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(23, 76, 60, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(23, 119, 60, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(23, 161, 60, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(92, 159, 170, 21);
		frame.getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(92, 117, 170, 21);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(92, 72, 170, 21);
		frame.getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(342, 76, 60, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(342, 119, 60, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fech. Nacimiento");
		lblNewLabel_5.setBounds(342, 161, 109, 17);
		frame.getContentPane().add(lblNewLabel_5);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(469, 159, 170, 21);
		frame.getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(469, 117, 170, 21);
		frame.getContentPane().add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(469, 74, 170, 21);
		frame.getContentPane().add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblFaltancampos = new JLabel("");
		lblFaltancampos.setForeground(new Color(224, 27, 36));
		lblFaltancampos.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		lblFaltancampos.setBounds(41, 277, 441, 21);
		frame.getContentPane().add(lblFaltancampos);
		
		JLabel lblDNIActualizado = new JLabel("");
		lblDNIActualizado.setFont(new Font("Fira Code", Font.BOLD, 13));
		lblDNIActualizado.setBounds(232, 430, 170, 17);
		frame.getContentPane().add(lblDNIActualizado);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDNIActualizado.setText("");
				String Apellido = textFieldApellido.getText();
				String Nombre = textFieldNombre.getText();
				String DNI = textFieldDNI.getText();
				String Direccion = textFieldDireccion.getText();
				String Telefono = textFieldTelefono.getText();
				String FechaNac = textFieldFechaNac.getText();
				System.out.println("^.^ Touch button save");
				System.out.println("Tu apellido es: " + Apellido);
				String sqlTest = "INSERT INTO Contactos (dni, nombre, apellido, direccion, telefono, fech_nac) VALUES (%s, '%s', '%s', '%s', %s, '%s')".formatted(DNI, Nombre, Apellido, Direccion, Telefono, FechaNac);
				System.out.println("^.^ sql query: " + sqlTest);
				/* Se guardan los datos en la base de datos */
				String servidor = "localhost:3306";
				String baseDatos = "agenda";
				String usuario = "ricardo";
				String clave = "1234ricardo*";
				String url = "jdbc:mysql://" + servidor + "/" +baseDatos+"?serverTimezone=America/Argentina/Buenos_Aires";
				
				if (Apellido.isEmpty() || Nombre.isEmpty() || DNI.isEmpty() || Direccion.isEmpty() || Telefono.isEmpty() || FechaNac.isEmpty()) {
					lblFaltancampos.setText("Accion no realizada: Faltan completar campos");	
				}else {
					java.sql.Connection cnx;
					try
					{
					/* Se crea una sentencia jdbc para realizar la consulta */
					cnx = java.sql.DriverManager.getConnection(url, usuario, clave);
					java.sql.Statement stmt = cnx.createStatement();
					/* Se prepara el string SQL de la inserción */
					String sql = "INSERT INTO Contactos (dni, nombre, apellido, direccion, telefono, fech_nac) VALUES (%s, '%s', '%s', '%s', %s, '%s')".formatted(DNI, Nombre, Apellido, Direccion, Telefono, FechaNac);
					/*  Se ejecuta la inserción */
					stmt.execute(sql);
					/* Se retornan los recursos utilizados cerrando la sentencia */
					stmt.close();
					lblFaltancampos.setText("");
					}
					catch (java.sql.SQLException ex)
					{
					System.out.println("Mensaje: " + ex.getMessage()); // Mensaje retornado por MySQL
					System.out.println("Código: " + ex.getErrorCode()); // Código de error de MySQL 
					System.out.println("SQLState: " + ex.getSQLState()); // Código de error del SQL standart
					}
					/* Se guardan los datos en la base de datos */	
				}
				
				
				
			}
		});
		btnNewButton.setBounds(23, 359, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		textFieldBuscarDNI = new JTextField();
		textFieldBuscarDNI.setBounds(186, 15, 170, 21);
		frame.getContentPane().add(textFieldBuscarDNI);
		textFieldBuscarDNI.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DNI");
		lblNewLabel_6.setBounds(146, 17, 60, 17);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblSinResultados = new JLabel("");
		lblSinResultados.setFont(new Font("Fira Code", Font.BOLD, 12));
		lblSinResultados.setBounds(186, 43, 171, 17);
		frame.getContentPane().add(lblSinResultados);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* vacio los campos antes de la busqueda */
				textFieldApellido.setText("");
				textFieldNombre.setText("");
				textFieldDNI.setText("");
				textFieldDireccion.setText("");
				textFieldTelefono.setText("");
				textFieldFechaNac.setText("");
				/* vacio los campos antes de la busqueda */
				
				String BuscarDNI = textFieldBuscarDNI.getText();
				/* Se guardan los datos en la base de datos */
				String servidor = "localhost:3306";
				String baseDatos = "agenda";
				String usuario = "ricardo";
				String clave = "1234ricardo*";
				String url = "jdbc:mysql://" + servidor + "/" +baseDatos+"?serverTimezone=America/Argentina/Buenos_Aires";
				
				if (BuscarDNI.isEmpty()) {
					lblFaltancampos.setText("Accion no realizada: Faltan completar campos");	
				}else {
					java.sql.Connection cnx;
					try
					{
					/* Se crea una sentencia jdbc para realizar la consulta */
					cnx = java.sql.DriverManager.getConnection(url, usuario, clave);
					java.sql.Statement stmt = cnx.createStatement();
					/* Se prepara el string SQL de la inserción */
					String sql = "SELECT dni, nombre, apellido, direccion, telefono, fech_nac FROM Contactos where dni=%s".formatted(BuscarDNI);
					/*  Se ejecuta la inserción */
					java.sql.ResultSet rs = stmt.executeQuery(sql);
					
					while (rs.next()) {
						String Nombre = rs.getString("nombre");
						textFieldNombre.setText(Nombre);
						String Apellido = rs.getString("apellido");
						textFieldApellido.setText(Apellido);
						Integer DNI = rs.getInt("dni");
						textFieldDNI.setText(String.valueOf(DNI));
						String Direccion = rs.getString("direccion");
						textFieldDireccion.setText(Direccion);
						Integer Telefono = rs.getInt("telefono");
						textFieldTelefono.setText(String.valueOf(Telefono));
						String FechaNac = rs.getString("fech_nac");
						textFieldFechaNac.setText(FechaNac);
						lblSinResultados.setText("");
						lblFaltancampos.setText("");
						
					}
					String Apellido = textFieldApellido.getText();
					String Nombre = textFieldNombre.getText();
					String DNI = textFieldDNI.getText();
					String Direccion = textFieldDireccion.getText();
					String Telefono = textFieldTelefono.getText();
					String FechaNac = textFieldFechaNac.getText();
					if (Apellido.isEmpty() || Nombre.isEmpty() || String.valueOf(DNI).isEmpty() || Direccion.isEmpty() || String.valueOf(Telefono).isEmpty() || FechaNac.isEmpty()) {
						System.out.println("^.^ no se encontro el nombre ");
						lblSinResultados.setText("Sin resultados");
						lblFaltancampos.setText("");
					}
					
					
					/* Se retornan los recursos utilizados cerrando la sentencia */
					rs.close();
					stmt.close();
					}
					catch (java.sql.SQLException ex)
					{
					System.out.println("Mensaje: " + ex.getMessage()); // Mensaje retornado por MySQL
					System.out.println("Código: " + ex.getErrorCode()); // Código de error de MySQL 
					System.out.println("SQLState: " + ex.getSQLState()); // Código de error del SQL standart
					}
					/* Se guardan los datos en la base de datos */	
				}
			}
		});
		btnNewButton_1.setBounds(23, 12, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblActualizarDNI = new JLabel("Actualizar DNI");
		lblActualizarDNI.setBounds(132, 403, 93, 17);
		frame.getContentPane().add(lblActualizarDNI);
		
		
		textFieldActualizarDNI = new JTextField();
		textFieldActualizarDNI.setBounds(232, 401, 170, 21);
		frame.getContentPane().add(textFieldActualizarDNI);
		textFieldActualizarDNI.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Actualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Apellido = textFieldApellido.getText();
				String Nombre = textFieldNombre.getText();
				String DNI = textFieldDNI.getText();
				String DNIBuscar = textFieldActualizarDNI.getText();
				String Direccion = textFieldDireccion.getText();
				String Telefono = textFieldTelefono.getText();
				String FechaNac = textFieldFechaNac.getText();
				System.out.println("^.^ Touch button update");
				System.out.println("Tu dni es: %s".formatted(DNI));
				String sqlTest = "UPDATE Contactos SET nombre='%s', apellido='%s', direccion='%s', telefono=%s, fech_nac='%s' WHERE dni=%s".formatted(Nombre, Apellido, Direccion, Telefono, FechaNac, DNI);
				System.out.println("^.^ sql query: " + sqlTest);
				/* Se guardan los datos en la base de datos */
				String servidor = "localhost:3306";
				String baseDatos = "agenda";
				String usuario = "ricardo";
				String clave = "1234ricardo*";
				String url = "jdbc:mysql://" + servidor + "/" +baseDatos+"?serverTimezone=America/Argentina/Buenos_Aires";
				
				if (Apellido.isEmpty() || Nombre.isEmpty() || DNI.isEmpty() || Direccion.isEmpty() || Telefono.isEmpty() || FechaNac.isEmpty() || DNIBuscar.isEmpty()) {
					lblFaltancampos.setText("Accion no realizada: Faltan completar campos");	
				}else {
					java.sql.Connection cnx;
					try
					{
					/* Se crea una sentencia jdbc para realizar la consulta */
					cnx = java.sql.DriverManager.getConnection(url, usuario, clave);
					java.sql.Statement stmt = cnx.createStatement();
					/* Se prepara el string SQL de la inserción */
					String sql = "UPDATE Contactos SET nombre='%s' ,apellido='%s', direccion='%s', telefono=%s, fech_nac='%s' where dni=%s".formatted(Nombre, Apellido, Direccion, Telefono, FechaNac, DNIBuscar);
					/*  Se ejecuta la inserción */
					stmt.execute(sql);
					/* Se retornan los recursos utilizados cerrando la sentencia */
					stmt.close();
					lblFaltancampos.setText("");
					lblDNIActualizado.setText("Contacto actualizado");
					}
					catch (java.sql.SQLException ex)
					{
					System.out.println("Mensaje: " + ex.getMessage()); // Mensaje retornado por MySQL
					System.out.println("Código: " + ex.getErrorCode()); // Código de error de MySQL 
					System.out.println("SQLState: " + ex.getSQLState()); // Código de error del SQL standart
					}
					/* Se guardan los datos en la base de datos */	
				}
			}
		});
		btnNewButton_2.setBounds(23, 398, 105, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		JLabel lblDNIEliminado = new JLabel("");
		lblDNIEliminado.setFont(new Font("Fira Code", Font.BOLD, 12));
		lblDNIEliminado.setBounds(469, 43, 158, 17);
		frame.getContentPane().add(lblDNIEliminado);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDNIActualizado.setText("");
				String Apellido = textFieldApellido.getText();
				String Nombre = textFieldNombre.getText();
				String DNI = textFieldDNI.getText();
				String Direccion = textFieldDireccion.getText();
				String Telefono = textFieldTelefono.getText();
				String FechaNac = textFieldFechaNac.getText();
				System.out.println("^.^ Touch button update");
				System.out.println("Tu dni es: %s".formatted(DNI));
				String sqlTest = "DELETE FROM Contactos where dni=%s".formatted(DNI);
				System.out.println("^.^ sql query: " + sqlTest);
				/* Se guardan los datos en la base de datos */
				String servidor = "localhost:3306";
				String baseDatos = "agenda";
				String usuario = "ricardo";
				String clave = "1234ricardo*";
				String url = "jdbc:mysql://" + servidor + "/" +baseDatos+"?serverTimezone=America/Argentina/Buenos_Aires";
				
				if (DNI.isEmpty()) {
					lblFaltancampos.setText("Accion no realizada: Se necesita el DNI para continuar...");	
				}else {
					java.sql.Connection cnx;
					try
					{
					lblDNIEliminado.setText("");
					/* Se crea una sentencia jdbc para realizar la consulta */
					cnx = java.sql.DriverManager.getConnection(url, usuario, clave);
					java.sql.Statement stmt = cnx.createStatement();
					/* Se prepara el string SQL de la inserción */
					String sql = "DELETE FROM Contactos where dni=%s".formatted(DNI);
					/*  Se ejecuta la inserción */
					stmt.execute(sql);
					/* Se retornan los recursos utilizados cerrando la sentencia */
					stmt.close();
					lblFaltancampos.setText("");
					lblDNIEliminado.setText("DNI Eliminado");
					}
					catch (java.sql.SQLException ex)
					{
						
					System.out.println("Mensaje: " + ex.getMessage()); // Mensaje retornado por MySQL
					System.out.println("Código: " + ex.getErrorCode()); // Código de error de MySQL 
					System.out.println("SQLState: " + ex.getSQLState()); // Código de error del SQL standart
					lblDNIEliminado.setText("No se encontro DNI");
					}
					/* Se guardan los datos en la base de datos */	
				}
				
			}
		});
		btnNewButton_3.setBounds(469, 12, 105, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("/home/hunter/eclipse-workspace/AgendaPersonal/img/agendaIcon.png"));
		lblNewLabel_7.setBounds(469, 216, 247, 256);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Agenda");
		lblNewLabel_8.setFont(new Font("Fira Code Retina", Font.BOLD, 20));
		lblNewLabel_8.setBounds(545, 470, 93, 33);
		frame.getContentPane().add(lblNewLabel_8);
		
		
		
		
		
		
		
		
	}
}
