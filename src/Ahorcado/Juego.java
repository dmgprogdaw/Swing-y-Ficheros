package Ahorcado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Juego extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Lienzo lienzo;
//	String letras = "abcdefghijklmnñopqrstuvwxyz";
	private Font font;
	private JLabel lblPalabra = null;
//	private JButton b;
	private String palabraAzar = null;
	private JPanel inf;
	private int cantidadLetras;
	private JButton jugar, A , B, C, D, E, F, G, H, I, J, K, L, M, N, Ñ, O, P, Q, R, S, T, U, V, W, X, Y, Z;
	private String rayas ="";
	
	public Juego(Lienzo lienzo) throws FontFormatException, IOException {
		this.lienzo = lienzo;
		InputStream in = getClass().getResourceAsStream("/fuentes/Pokemon Hollow.ttf");
		font = Font.createFont(Font.PLAIN, in).deriveFont(30f);
		in.close();
		
		setLayout(new BorderLayout());
		
		JPanel sup = new JPanel(new GridLayout(1, 1));
		lblPalabra = new JLabel("Pulsa Jugar para empezar");
		lblPalabra.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30, 30, 30, 30),
				BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.DARK_GRAY),
						BorderFactory.createEmptyBorder(20, 20, 20, 20))));
		lblPalabra.setHorizontalAlignment(JLabel.CENTER);
		lblPalabra.setFont(font);
		sup.add(lblPalabra);

		inf = new JPanel(new GridLayout(4, 7)); //para poner el teclado en el layout
		inf.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30, 30, 30, 30),
				BorderFactory.createBevelBorder(BevelBorder.RAISED)));
		
		A = new JButton("a"); G = new JButton("g"); M = new JButton("m"); R = new JButton("r"); X = new JButton("x");
		B = new JButton("b"); H = new JButton("h"); N = new JButton("n"); S = new JButton("s"); Y = new JButton("y"); 
		C = new JButton("c"); I = new JButton("i"); Ñ = new JButton("ñ"); T = new JButton("t"); Z = new JButton("z");
		D = new JButton("d"); J = new JButton("j"); O = new JButton("o"); U = new JButton("u"); 
		E = new JButton("e"); K = new JButton("k"); P = new JButton("p"); V = new JButton("v"); 
		F = new JButton("f"); L = new JButton("l"); Q = new JButton("q"); W = new JButton("w"); 
		   
		A.setFont(font); G.setFont(font); M.setFont(font); R.setFont(font); X.setFont(font); 
		B.setFont(font); H.setFont(font); N.setFont(font); S.setFont(font); Y.setFont(font); 
		C.setFont(font); I.setFont(font); Ñ.setFont(font); T.setFont(font); Z.setFont(font);
		D.setFont(font); J.setFont(font); O.setFont(font); U.setFont(font);
		E.setFont(font); K.setFont(font); P.setFont(font); V.setFont(font);
		F.setFont(font); L.setFont(font); Q.setFont(font); W.setFont(font); 
		
		inf.add(A); inf.add(B); inf.add(C); inf.add(D); inf.add(E); inf.add(F); inf.add(G); inf.add(H); inf.add(I); inf.add(J); inf.add(K); inf.add(L); inf.add(M); inf.add(N); 
		inf.add(Ñ); inf.add(O); inf.add(P); inf.add(Q); inf.add(R); inf.add(S); inf.add(T); inf.add(U); inf.add(V); inf.add(W); inf.add(X); inf.add(Y); inf.add(Z); 
		
		A.addActionListener(this); G.addActionListener(this); M.addActionListener(this); R.addActionListener(this); X.addActionListener(this); 
		B.addActionListener(this); H.addActionListener(this); N.addActionListener(this); S.addActionListener(this); Y.addActionListener(this); 
		C.addActionListener(this); I.addActionListener(this); Ñ.addActionListener(this); T.addActionListener(this); Z.addActionListener(this);
		D.addActionListener(this); J.addActionListener(this); O.addActionListener(this); U.addActionListener(this);
		E.addActionListener(this); K.addActionListener(this); P.addActionListener(this); V.addActionListener(this);
		F.addActionListener(this); L.addActionListener(this); Q.addActionListener(this); W.addActionListener(this);  
		
		A.setActionCommand("A"); G.setActionCommand("G"); M.setActionCommand("M"); R.setActionCommand("R"); X.setActionCommand("X");
		B.setActionCommand("B"); H.setActionCommand("H"); N.setActionCommand("N"); S.setActionCommand("S"); Y.setActionCommand("Y");
		C.setActionCommand("C"); I.setActionCommand("I"); Ñ.setActionCommand("Ñ"); T.setActionCommand("T"); Z.setActionCommand("Z");
		D.setActionCommand("D"); J.setActionCommand("J"); O.setActionCommand("O"); U.setActionCommand("U");
		E.setActionCommand("E"); K.setActionCommand("K"); P.setActionCommand("P"); V.setActionCommand("V");
		F.setActionCommand("F"); L.setActionCommand("L"); Q.setActionCommand("Q"); W.setActionCommand("W");
		
		A.setEnabled(false); G.setEnabled(false); M.setEnabled(false); R.setEnabled(false); X.setEnabled(false);
		B.setEnabled(false); H.setEnabled(false); N.setEnabled(false); S.setEnabled(false); Y.setEnabled(false);
		C.setEnabled(false); I.setEnabled(false); Ñ.setEnabled(false); T.setEnabled(false); Z.setEnabled(false);
		D.setEnabled(false); J.setEnabled(false); O.setEnabled(false); U.setEnabled(false);
		E.setEnabled(false); K.setEnabled(false); P.setEnabled(false); V.setEnabled(false);
		F.setEnabled(false); L.setEnabled(false); Q.setEnabled(false); W.setEnabled(false);
//		for (int i=0; i<letras.length(); i++) {
//			b = new JButton("" + letras.charAt(i)); //o usar (letras.subString(i, i + 1))
//			b.setFont(font);
//			inf.add(b);
//			b.setEnabled(false);//Todas la letras estan deshabilitadas		
//			b.addActionListener(this);
//			b.setActionCommand("LETRAS");
//		}
		
//		inf.add(new JButton("Jugar"));
		jugar = new JButton("Jugar");
		jugar.setActionCommand("JUGAR");
		jugar.addActionListener(this);
		inf.add(jugar);

		add(sup, BorderLayout.CENTER);
		add(inf, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("JUGAR")) {
			jugar.setEnabled(false);
			ArrayList<String> palabras = new ArrayList<String>();
			FileReader fl = null;
			try {
				fl = new FileReader("C:/users/usuario/git/Swing-y-Ficheros/res/palabras.txt");/*Esta ruta absoluta me funciona en el ordenador de casa, si se esta probando en
			otro ordenador hay que cambiar la carpeta de usuario. C:/users/carpeta_de_usuario_del_ordenador_donde_se_prueba/git/Swing-y-Ficheros/res/palabras.txt.*/
			} catch (FileNotFoundException e2) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Cierre el juego", "El fichero con las palabras no ha sido encontrado", JOptionPane.CLOSED_OPTION);
				if (respuesta == JOptionPane.YES_OPTION ) {
					System.exit(0);
				}
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
				palabraAzar = (String) array[r.nextInt(palabras.size())];
				cantidadLetras = palabraAzar.length();
				for(int i=0; i<cantidadLetras; i++) {
					rayas += "_ ";
					lblPalabra.setText(rayas);
				}
				System.out.println(palabraAzar);
				A.setEnabled(true); G.setEnabled(true); M.setEnabled(true); R.setEnabled(true); X.setEnabled(true);
				B.setEnabled(true); H.setEnabled(true); N.setEnabled(true); S.setEnabled(true); Y.setEnabled(true);
				C.setEnabled(true); I.setEnabled(true); Ñ.setEnabled(true); T.setEnabled(true); Z.setEnabled(true);
				D.setEnabled(true); J.setEnabled(true); O.setEnabled(true); U.setEnabled(true);
				E.setEnabled(true); K.setEnabled(true); P.setEnabled(true); V.setEnabled(true);
				F.setEnabled(true); L.setEnabled(true); Q.setEnabled(true); W.setEnabled(true);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals("A")) {
			A.setEnabled(false); 
			if(palabraAzar.contains("a") | palabraAzar.contains("á")){
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("B")) {
			B.setEnabled(false);
			if(palabraAzar.contains("b")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("C")) {
			C.setEnabled(false);
			if(palabraAzar.contains("c")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("D")) {
			D.setEnabled(false);
			if(palabraAzar.contains("d")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("E")) {
			E.setEnabled(false);
			if(palabraAzar.contains("e") | palabraAzar.contains("é")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("F")) {
			F.setEnabled(false);
			if(palabraAzar.contains("f")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("G")) {
			G.setEnabled(false);
			if(palabraAzar.contains("g")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("H")) {
			H.setEnabled(false);
			if(palabraAzar.contains("h")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("I")) {
			I.setEnabled(false);
			if(palabraAzar.contains("i") | palabraAzar.contains("í")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("J")) {
			J.setEnabled(false);
			if(palabraAzar.contains("j")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("K")) {
			K.setEnabled(false);
			if(palabraAzar.contains("k")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("L")) {
			L.setEnabled(false);
			if(palabraAzar.contains("l")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("M")) {
			M.setEnabled(false);
			if(palabraAzar.contains("m")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("N")) {
			N.setEnabled(false);
			if(palabraAzar.contains("n")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("Ñ")) {
			Ñ.setEnabled(false);
			if(palabraAzar.contains("Ñ")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("O")) {
			O.setEnabled(false);
			if(palabraAzar.contains("o") | palabraAzar.contains("ó")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("P")) {
			P.setEnabled(false);
			if(palabraAzar.contains("p")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("Q")) {
			Q.setEnabled(false);
			if(palabraAzar.contains("q")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("R")) {
			R.setEnabled(false);
			if(palabraAzar.contains("r")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("S")) {
			S.setEnabled(false);
			if(palabraAzar.contains("s")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("T")) {
			T.setEnabled(false);
			if(palabraAzar.contains("t")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("U")) {
			U.setEnabled(false);
			if(palabraAzar.contains("u") | palabraAzar.contains("ü") | palabraAzar.contains("ú")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("V")) {
			V.setEnabled(false);
			if(palabraAzar.contains("W")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("W")) {
			W.setEnabled(false);
			if(palabraAzar.contains("w")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("X")) {
			X.setEnabled(false);
			if(palabraAzar.contains("x")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("Y")) {
			Y.setEnabled(false);
			if(palabraAzar.contains("y")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
		else if (e.getActionCommand().equals("Z")) {
			Z.setEnabled(false);
			if(palabraAzar.contains("z")){	
				
			}
			else {
				lienzo.incFallos();
			}
		}
	}
}

