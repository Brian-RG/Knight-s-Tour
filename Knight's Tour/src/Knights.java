import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Knights extends JFrame{
	
	public Tablero t = new Tablero();
	
	public PanelBotones botones = new PanelBotones(t);
	
	public Knights() {
		super();
		//this.setSize(960,800);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(350,50);
		this.setLayout(new BorderLayout());
		this.add(t, BorderLayout.CENTER);
		this.add(botones, BorderLayout.WEST);
		this.pack();
	}
	
	public static void main(String[] args) {
		Knights k = new Knights();
	}

}
