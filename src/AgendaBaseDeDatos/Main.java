package AgendaBaseDeDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements ActionListener, KeyListener, WindowListener{
	
	JTextField tf;
	
	public Main() {
		super("Mi Agenda");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		addWindowListener(this);
		
		JTextArea ta = new JTextArea();
		ta.setBackground(Color.red);
		ta.setEditable(false);
		add(BorderLayout.CENTER, ta);
		
		JPanel barraInferior = new JPanel();
		barraInferior.setLayout(new BorderLayout());
		add(BorderLayout.SOUTH, barraInferior);
		tf = new JTextField();
		barraInferior.add(BorderLayout.CENTER, tf);
		JButton ejecutar = new JButton(new ImageIcon(getClass().getResource("/img/Play.png")));
		barraInferior.add(BorderLayout.EAST, ejecutar);
		ejecutar.setActionCommand("EJECUTAR");
		ejecutar.addActionListener(this);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);				
			}
			
		});
	}
	
	public void Ejecutar() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("EJECUTAR"))
			Ejecutar();
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
