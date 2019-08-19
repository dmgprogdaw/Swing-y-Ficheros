package Ahorcado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorListener;

public class Juego extends JPanel implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Lienzo lienzo;
	String letras = "abcdefghijklmnñopqrstuvwxyz";
	private Font font;
	private JLabel lblPalabra = null;
	private JButton b;
	
	public Juego(Lienzo lienzo) throws FontFormatException, IOException {
		this.lienzo = lienzo;
		InputStream in = getClass().getResourceAsStream("/fuentes/Pokemon Hollow.ttf");
		font = Font.createFont(Font.PLAIN, in).deriveFont(30f);
		in.close();
		
		setLayout(new BorderLayout());
		
		JPanel sup = new JPanel(new GridLayout(1, 1));
		lblPalabra = new JLabel("PALABRA");
		lblPalabra.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30, 30, 30, 30),
				BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.DARK_GRAY),
						BorderFactory.createEmptyBorder(20, 20, 20, 20))));
		lblPalabra.setHorizontalAlignment(JLabel.CENTER);
		lblPalabra.setFont(font);
		sup.add(lblPalabra);

		JPanel inf = new JPanel(new GridLayout(4, 7)); //para poner el teclado en el layout
		inf.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30, 30, 30, 30),
				BorderFactory.createBevelBorder(BevelBorder.RAISED)));
		for (int i=0; i<letras.length(); i++) {
			b = new JButton("" + letras.charAt(i)); //o usar (letras.subString(i, i + 1))
			b.setFont(font);
			inf.add(b);
			b.setEnabled(false);//Todas la letras estan deshabilitadas
			b.addActionListener(this);
			b.setActionCommand("JUGAR");
		}
//		inf.add(new JButton("Jugar"));
		JButton jugar = new JButton("Jugar");
		jugar.setActionCommand("JUGAR");
		jugar.addActionListener(this);
		inf.add(jugar);

		add(sup, BorderLayout.CENTER);
		add(inf, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("JUGAR")) {
			b.setEnabled(true);
			ArrayList<String> palabras = new ArrayList<String>();
			FileReader fl = null;
			try {
				fl = new FileReader("C:/users/usuario/git/Swing-y-Ficheros/res/palabras.txt");
			} catch (FileNotFoundException e2) {
				System.out.println("El fichero no ha sido encontrado");
			}
			BufferedReader br = new BufferedReader(fl);
			String linea = null;
			try {
				while ((linea = br.readLine()) != null) {
					String palabra = linea;
					palabras.add(palabra);
				}
				Random r = new Random();
				Object array [] = palabras.toArray();
				String palabraAzar = (String) array[r.nextInt(palabras.size())];
				int cantidadLetras = palabraAzar.length();
				String simbolo = " _ ";
				for(int i=0; i<cantidadLetras; i++) {
					System.out.print(simbolo);
				}
					
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}	
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
