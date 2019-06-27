package AgendaGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class Main extends JFrame implements ActionListener, KeyListener, WindowListener{
	
	private Agenda agenda = new Agenda();
	private static JTextArea ta;
	private static JTextField tf;
	
	public Main () throws IOException {
		super("Mi Agenda");
		setIconImage(ImageIO.read(getClass().getResource("/AgendaGrafica/SinCara.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		addWindowListener(this);
		
		JToolBar barraSuperior = new JToolBar();		
		JButton abrir = new JButton(new ImageIcon(getClass().getResource("/AgendaGrafica/Open file.png")));
		abrir.setActionCommand("ABRIR");
		abrir.addActionListener(this);
		JButton guardar = new JButton(new ImageIcon(getClass().getResource("/AgendaGrafica/Save.png")));
		guardar.setActionCommand("GUARDAR");
		guardar.addActionListener(this);
		JButton guardarComo = new JButton(new ImageIcon(getClass().getResource("/AgendaGrafica/Save as.png")));
		guardarComo.setActionCommand("GUARDARCOMO");
		guardarComo.addActionListener(this);
		barraSuperior.add(abrir);
		barraSuperior.add(guardar);
		barraSuperior.add(guardarComo);
		add(BorderLayout.NORTH, barraSuperior);
		
		ta = new JTextArea();
		ta.setFocusable(false);
		ta.setBackground(Color.white);
		add(BorderLayout.CENTER, ta);
		
		JPanel barraInferior = new JPanel();
		barraInferior.setLayout(new BorderLayout());
		tf = new JTextField();
		tf.addKeyListener(this);
		JButton ejecutar = new JButton(new ImageIcon(getClass().getResource("/AgendaGrafica/Play.png")));
		ejecutar.setActionCommand("EJECUTAR");
		ejecutar.addActionListener(this);
		barraInferior.add(BorderLayout.CENTER, tf);
		barraInferior.add(BorderLayout.EAST, ejecutar);
		add(BorderLayout.SOUTH, barraInferior);
	}
	
	public static void main(String[] args)  {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new Main().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		});
	}		
	
	public void EjecutarComando() {
		String resultado = Agenda.miAgenda(tf.getText());
		if (resultado != null) {
			ta.append(resultado + "\n");
		}
		tf.setText("");
	}
	
	public void Guardar(File fichero) {
		
	}
	
	public void GuardarComo() {
		JFileChooser guardarComo = new JFileChooser();
		int seleccion = guardarComo.showOpenDialog(guardarComo);
		if (seleccion == JFileChooser.APPROVE_OPTION)
			agenda.guardarFichero(guardarComo.getSelectedFile());
		
		String resultado = "La agenda se ha guardado en un fichero nuevo";
		ta.append(resultado + "\n");
		tf.setText("");
	}
	
	public void AbrirFichero() {
		JFileChooser abrirFichero = new JFileChooser();
		int seleccion = abrirFichero.showOpenDialog(abrirFichero);
		if (seleccion == JFileChooser.APPROVE_OPTION) 
			agenda.cargarFichero(abrirFichero.getSelectedFile());
		
		String resultado = "Se ha cargado la agenda desde el fichero";
		if (resultado != null) {
			ta.append(resultado + "\n");
		}
		tf.setText("");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("EJECUTAR")) {
			EjecutarComando();
		}
		else if (e.getActionCommand().equals("GUARDAR")) {
			
		}
		else if(e.getActionCommand().equals("GUARDARCOMO")) {
			GuardarComo();
		}
		else if (e.getActionCommand().equals("ABRIR")) {
			AbrirFichero();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_ENTER) {
			EjecutarComando();
		}
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
		int cerrar = JOptionPane.showConfirmDialog(Main.this, "¿Estas seguro?", "Salir de la aplicacion?", JOptionPane.YES_NO_OPTION);
		if(cerrar == JOptionPane.YES_OPTION)
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
