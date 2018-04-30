import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cuadro extends JButton implements MouseListener{
	private int width=66;
	private int height=66;
	private int posX,posY;
	private int id;
	private boolean active=true;
	private ImageIcon img,over,c;
	private Tablero t;
	public Cuadro(ImageIcon imagen, int x, int y,ImageIcon ovr, Tablero t, ImageIcon c) {
		super(imagen);
		this.setMargin(new Insets(0,0,0,0));
		this.posX = x;
		this.posY = y;
		this.img=imagen;
		this.over=ovr;
		this.t=t;
		this.c=c;
		this.addMouseListener(this);
		//this.setBounds(posX, posY, width, height);
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Iterator<Cuadro> i =t.cuadros.iterator();
		this.setIcon(this.c);
		if(t.getCurrent()!=null) {
			t.getCurrent().setActive();
			t.getCurrent().borracaballo();
		}
		t.setCurrent(this);
		this.setActive();
		Point p = new Point(t.getCurrent().getPosX(),t.getCurrent().getPosY());
		System.out.println(p);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(this.active) {	
			this.setIcon(this.over);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(this.active) {
			this.setIcon(this.img);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setActive() {
		this.active=!this.active;
	}
	public void borracaballo() {
		this.setIcon(this.img);
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
}
