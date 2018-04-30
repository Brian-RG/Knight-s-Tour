import javax.swing.JFrame;


public class Knights extends JFrame{
	public Tablero t= new Tablero();
	public Knights() {
		super();
		//this.setSize(960,800);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(350,50);
		this.add(t);
		this.pack();
	}
	
	public static void main(String[] args) {
		Knights k = new Knights();
	}

}
