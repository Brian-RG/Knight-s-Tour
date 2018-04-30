import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelBotones extends JPanel{

	JLabel lKnight,
		   lTour,
		   lPor,
		   lNombres;
	JButton botonEmpezar,
			botonReiniciar;
	
	public PanelBotones(Tablero tablero) {
		super();
		lKnight = new JLabel("Knight's Tour");
		lPor = new JLabel("por");
		lNombres = new JLabel("Brian y Rafa");
		
		
		botonEmpezar = new JButton("Empezar");
		botonReiniciar = new JButton("Reiniciar");
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(lKnight);
		this.add(lPor);
		this.add(lNombres);
		this.add(botonEmpezar);
		this.add(botonReiniciar);
		
		botonEmpezar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		botonReiniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
	
}
