import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel implements Runnable{
	//ArrayList<Cuadro> cuadros= new ArrayList<Cuadro>();
	private Cuadro[][] cuadros= new Cuadro[8][8];
	public ImageIcon[] pre=new ImageIcon[2];
	public ImageIcon[] over=new ImageIcon[2];
	public ImageIcon[] caballito=new ImageIcon[2];
	private Cuadro current;
	private Image background;
	Thread animar;
	Cuadro d;
	Stack<Point> pasos;
	public Tablero() {
		super();
		
		background = new ImageIcon("src/img/chessBoard.jpg").getImage();
		
		pre[0]=new ImageIcon("src/img/Cuadro.png");
		pre[1]=new ImageIcon("src/img/oscuro.png");
		over[0]=new ImageIcon("src/img/over.png");
		over[1]=new ImageIcon("src/img/overn.png");
		caballito[0]=new ImageIcon("src/img/caballo.png");
		caballito[1]=new ImageIcon("src/img/cnegro.png");
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(8,8));
		this.setBorder(BorderFactory.createEmptyBorder(36, 36, 36,36));
		this.animar= new Thread(this);
		//this.animar.start();
		current=null;
		this.setTablero();
		
	}
	
	public void setTablero() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				this.add(d=new Cuadro(pre[(((j%2)+i)%2)],i,j,over[(((j%2)+i)%2)] ,this, caballito[(((j%2)+i)%2)]) );
				cuadros[i][j]=d;
			}
		}
		if(current != null) {
			current.borracaballo();
			current = null;
		}
	}
	public Cuadro getCurrent() {
		return this.current;
	}
	
	public void setCurrent(Cuadro c) {
		this.current=c;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.background, 0, 0, this);
	}
	
	public void resuelve(Stack<Point> stack) {
		this.pasos=stack;
		animar.start();
	}

	public Cuadro[][] getCuadros() {
		return this.cuadros;
	}
	
	@Override
	public void run() {
		for(int i=1;i<64;i++) {
			this.current.visitado(i);
			this.current=cuadros[this.pasos.peek().x][this.pasos.pop().y];
			//System.out.println("Entré");
			current.pintacaballo();
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				System.out.println("hola");
			}
		}
	}
	
}
