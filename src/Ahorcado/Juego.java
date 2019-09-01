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
import javax.swing.ImageIcon;
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
	
	public static String escribirLetra(String s, int num, char c) {
		char[] palabraOculta = new char[s.length()];
		String palabraCorrecta;
		palabraOculta = s.toCharArray();
		palabraOculta[num] = c;
		palabraCorrecta = new String(palabraOculta);
		return palabraCorrecta;
	}
	
	public void ganar() {
		if(lblPalabra.getText().contains(palabraAzar)) {
			int mensaje = JOptionPane.showConfirmDialog(null, "AHORA BUSCA TRABAJO VAGO", "HAS GANADO EL JUEGO", JOptionPane.CLOSED_OPTION);
			if (mensaje == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		else if (lienzo.getFallos() == 11) {
			int mensaje = JOptionPane.showConfirmDialog(null, "Cierre el Juego", "HAS PERDIDO EL JUEGO", JOptionPane.CLOSED_OPTION);
			if (mensaje == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("JUGAR")) {
			jugar.setEnabled(false);
			String ruta = "/res/palabras.txt";
			ArrayList<String> palabras = new ArrayList<String>();
			FileReader fl = null;
			try {
				fl = new FileReader(ruta);
			} catch (FileNotFoundException e2) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Introduce la ruta manualmente", "El fichero palabras.txt no se encuenntra", JOptionPane.CLOSED_OPTION);
				if (respuesta == JOptionPane.YES_OPTION ) {
					String res =  JOptionPane.showInputDialog("Introduce la ruta del fichero palabras.txt");
					ruta = res;
					try {
						fl = new FileReader(ruta);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			BufferedReader br = new BufferedReader(fl);
			String linea = null;
			try {
				while ((linea = br.readLine()) != null) {
					palabras.add(linea);
				}
				Random r = new Random();
				Object array [] = palabras.toArray();
				palabraAzar = (String) array[r.nextInt(palabras.size())];
				cantidadLetras = palabraAzar.length();
				for(int i=0; i<cantidadLetras; i++) {
					rayas += "_";
					lblPalabra.setText(rayas);
				}

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
		int cont = 0;
		if (e.getActionCommand().equals("A")) {
			A.setEnabled(false); 			
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'a' | palabraAzar.charAt(i) == 'á') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'a'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("B")) {
			B.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'b') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'b'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("C")) {
			C.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'c') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'c'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("D")) {
			D.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'd') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'd'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("E")) {
			E.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'e' | palabraAzar.charAt(i) == 'é') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'e'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("F")) {
			F.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'f') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'f'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("G")) {
			G.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'g') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'g'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("H")) {
			H.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'h') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'h'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("I")) {
			I.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'i' | palabraAzar.charAt(i) == 'í') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'i'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("J")) {
			J.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'j') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'j'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("K")) {
			K.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'k') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'k'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("L")) {
			L.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'l') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'l'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("M")) {
			M.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'm') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'm'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("N")) {
			N.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'n') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'n'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("Ñ")) {
			Ñ.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'ñ') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'ñ'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("O")) {
			O.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'o' | palabraAzar.charAt(i) == 'ó') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'o'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("P")) {
			P.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'p') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'p'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("Q")) {
			Q.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'q') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'q'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("R")) {
			R.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'r') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'r'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("S")) {
			S.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 's') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 's'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("T")) {
			T.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 't') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 't'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("U")) {
			U.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'u' | palabraAzar.charAt(i) == 'ú' | palabraAzar.charAt(i) == 'ü') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'u'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("V")) {
			V.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'v') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'v'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("W")) {
			W.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'w') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'w'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("X")) {
			X.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'x') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'x'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("Y")) {
			Y.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'y') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'y'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
		else if (e.getActionCommand().equals("Z")) {
			Z.setEnabled(false);
			for (int i=0; i<palabraAzar.length(); i++) {
				if(palabraAzar.charAt(i) == 'z') {
					lblPalabra.setText(escribirLetra(lblPalabra.getText(), i, 'z'));
					cont++;
				}
			}
			if (cont == 0) {
				lienzo.incFallos();
			}
			ganar();
		}
	}
}