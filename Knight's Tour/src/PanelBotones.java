import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelBotones extends JPanel{

	JLabel lKnight,
		   lTour,
		   lPor,
		   lNombres;
	JButton botonEmpezar,
			botonReiniciar;
	Tablero tablero;
	
	public PanelBotones(Tablero tablero) {
		super();
		this.tablero = tablero;
		lKnight = new JLabel("Knight's Tour",SwingConstants.CENTER);
		lPor = new JLabel("por",SwingConstants.CENTER);
		lNombres = new JLabel("Brian y Rafa",SwingConstants.CENTER);
		
		
		botonEmpezar = new JButton("Empezar");
		botonReiniciar = new JButton("Reiniciar");
		
		this.setLayout(new GridLayout(3,1));
		
		JPanel letras = new JPanel();
		letras.setLayout(new GridLayout(3,1));

		letras.add(lKnight);
		letras.add(lPor);
		letras.add(lNombres);
		this.add(letras);
		this.add(botonEmpezar);
		this.add(botonReiniciar);
		
		lKnight.setFont(lKnight.getFont().deriveFont(24.0f));
		lNombres.setFont(lNombres.getFont().deriveFont(22.0f));
		
		botonEmpezar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(tablero.getCurrent() != null) {
					Modelo modelo = new Modelo(8);
					Stack<Point> stack = modelo.knightsTour(tablero.getCurrent().getPosX(), tablero.getCurrent().getPosY());
					modelo.imprimeTablero();
				}
			}
			
		});
		
		botonReiniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tablero.setTablero();
			}
			
		});
	}
	
}
