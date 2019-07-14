package AgendaBaseDeDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class Main extends JFrame implements ActionListener, KeyListener, WindowListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField tf;
	private JTextArea ta;
	private Connection conexion;
	
	public Main() {
		super("Mi Agenda");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		addWindowListener(this);
		
		JToolBar tb = new JToolBar();
		tb.setBackground(Color.DARK_GRAY);
		JButton borrar = new JButton(new ImageIcon(getClass().getResource("/img/SinCara.png")));
		borrar.setActionCommand("BORRAR");
		borrar.addActionListener(this);
		tb.add(borrar);
		add(BorderLayout.NORTH, tb);
		
		ta = new JTextArea();
		ta.setBackground(Color.LIGHT_GRAY);
		ta.setEditable(false);
		ta.setFocusable(false);
		add(BorderLayout.CENTER, ta);
		
		JScrollPane scroll = new JScrollPane(ta);
		getContentPane().add(scroll);
		
		JPanel barraInferior = new JPanel();
		barraInferior.setLayout(new BorderLayout());
		tf = new JTextField();
		tf.addKeyListener(this);
		JButton ejecutar = new JButton(new ImageIcon(getClass().getResource("/img/Play.png")));
		ejecutar.setActionCommand("EJECUTAR");
		ejecutar.addActionListener(this);
		barraInferior.add(BorderLayout.CENTER, tf);
		barraInferior.add(BorderLayout.EAST, ejecutar);
		add(BorderLayout.SOUTH, barraInferior);
		
		
		String url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", usuario = "root", contraseña = "Zuko";
		try {
			conexion = DriverManager.getConnection(url, usuario, contraseña);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				new Main().setVisible(true);				
			}
			
		});
	}
	
	public void Ejecutar() {
		try {
			Statement sentencia = conexion.createStatement();
			if (sentencia.execute(tf.getText())) {
				ResultSet rs = sentencia.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				String linea = "";
				for (int i=1; i<=columns; i++) {
					linea = linea +  "| " + rsmd.getColumnLabel(i) + " ";
				}
				ta.append(linea + "|\n");
				while(rs.next()) {
					for(int i=1; i<=columns; i++) {
						linea = "| ";
						int tipo = rsmd.getColumnType(i);
						switch(tipo) {
							case Types.VARCHAR:
								linea = linea + rs.getString(i);
								break;
							case Types.INTEGER:
								linea = linea + rs.getInt(i);
								break;
							case Types.CHAR:
								linea = linea + rs.getString(i);
								break;
						}
						ta.append(linea);
					}
					ta.append("\n");
				}	
				ta.append("\n");
			}
		} catch (SQLException e1) {
			ta.append(e1.getMessage() + "\n");
		}
		tf.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("EJECUTAR"))
			Ejecutar();
		if(e.getActionCommand().equals("BORRAR")) {
			ta.setText("");
			tf.requestFocus();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();	
		if (key == KeyEvent.VK_ENTER)
			Ejecutar();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		tf.requestFocus();
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		int cerrar = JOptionPane.showConfirmDialog(Main.this, "¿Estas seguro?", "Desea cerrar la aplicacion", JOptionPane.YES_NO_OPTION);
		if (cerrar == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}
}
