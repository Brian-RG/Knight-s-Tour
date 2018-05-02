// Brian Reyes - A01633401
// Rafael Elu - A01634309
// Clase: Tablero
// 02 de mayo de 2018

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
	int vel;
	public Tablero() {
		super();
		background = new ImageIcon("img/chessBoard.jpg").getImage();
		
		pre[0]=new ImageIcon("img/Cuadro.png");
		pre[1]=new ImageIcon("img/oscuro.png");
		over[0]=new ImageIcon("img/over.png");
		over[1]=new ImageIcon("img/overn.png");
		caballito[0]=new ImageIcon("img/caballo.png");
		caballito[1]=new ImageIcon("img/cnegro.png");
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(8,8));
		this.setBorder(BorderFactory.createEmptyBorder(36, 36, 36,36));
		//this.animar.start();
		current=null;
		this.setTablero();
		this.vel=5;
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
		this.animar= new Thread(this);
		this.animar.start();
	}

	public Cuadro[][] getCuadros() {
		return this.cuadros;
	}
	
	@Override
	public void run() {
		for(int i=1;i<64;i++) {
			if(this.current != null) {
				this.current.visitado(i);
			this.current=cuadros[this.pasos.peek().x][this.pasos.pop().y];
			//System.out.println("Entr�");
			current.pintacaballo();
			try {
				Thread.sleep(1000 - (vel*100));
			}
			catch(Exception e) {
				System.out.println("hola");
			}
			}
		}
	}
	
	public void reiniciarTablero() {
		this.removeAll();
		this.setTablero();
		this.revalidate();
		this.repaint();
	}
	public void setvel(int vel) {
		this.vel=vel;
	}
	
}
