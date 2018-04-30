import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel{
	ArrayList<Cuadro> cuadros= new ArrayList<Cuadro>();
	public ImageIcon[] pre=new ImageIcon[2];
	public ImageIcon[] over=new ImageIcon[2];
	//private Cuadro[] cuadros= new Cuadro[64];
	Cuadro d;
	public Tablero() {
		super();
		pre[0]=new ImageIcon("src/img/Cuadro.png");
		pre[1]=new ImageIcon("src/img/oscuro.png");
		over[0]=new ImageIcon("src/img/over.png");
		over[1]=new ImageIcon("src/img/overn.png");
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(8,8));
		this.setBorder(BorderFactory.createEmptyBorder(36, 36, 36,36));
		
		/*for(int i=0;i<64;i++) {
			this.add(new Cuadro(pre[i%2],i,over[i%2]));
		}*/
		this.setTablero();
		
		
	}
	
	public void setTablero() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				this.add(d=new Cuadro(pre[(((j%2)+i)%2)],i,j,over[(((j%2)+i)%2)] ,this) );
				cuadros.add(d);
			}
		}
	}

}
