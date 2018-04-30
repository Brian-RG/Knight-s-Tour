import java.awt.Point;

public class Modelo {
	
	int n;
	Celda[][] tablero;
	
	public Modelo(int n) {
		this.n = n;
		tablero = new Celda[this.n][this.n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				tablero[i][j] = new Celda(i,j);
			}
		}
	}
	
	public void imprimeTablero() {
		for(int i = 0; i < this.n; i++) {
			for(int j = 0; j < this.n; j++) {
				if(this.tablero[i][j].getValor() < 10) {
					System.out.print("0" + this.tablero[i][j].getValor() + " ");
				} else {
					System.out.print(this.tablero[i][j].getValor() + " ");
				}
			}
			System.out.println();
		}
	}
	
	public boolean knightsTour(int x, int y) {
		Point p = new Point(x,y);
		return knightsTour(p,0);
	}
	
	private boolean knightsTour(Point p, int movimientos) {
		marcarCelda(p,movimientos);
		if(movimientos == this.n*this.n -1) {
			return true;
		} else {
			Celda[] posiblesCaminos = calculaPosiblesCaminos(p, movimientos);
			for(int i = 0; i < posiblesCaminos.length; i++) {
				int mejorCamino = calculaMejorCamino(posiblesCaminos);
				if(mejorCamino >= 0) {
					Point punto = new Point(posiblesCaminos[mejorCamino].getX(), posiblesCaminos[mejorCamino].getY());
					if(knightsTour(punto, movimientos+1)) {
						return true;
					} else {
						posiblesCaminos[mejorCamino] = null;
					}
				}
			}
		}
		desmarcarCelda(p);
		return false;
	}
	
	private void marcarCelda(Point p, int movimientos) {
		this.tablero[p.x][p.y].setVisitada(true);
		this.tablero[p.x][p.y].setValor(movimientos);
	}
	
	private void desmarcarCelda(Point p) {
		this.tablero[p.x][p.y].setVisitada(false);
		this.tablero[p.x][p.y].setValor(88);
	}
	
	private Celda[] calculaPosiblesCaminos(Point p, int movimientos) {
		Celda[] posiblesCaminos = new Celda[8];
		int grado = 0;
		if(celdaDisponible(p.x-2,p.y-1)) {
			grado = calculaGrado(new Point(p.x-2,p.y-1));
			tablero[p.x-2][p.y-1].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[0] = tablero[p.x-2][p.y-1];				
			}
		}
		if(celdaDisponible(p.x-1,p.y-2)) {
			grado = calculaGrado(new Point(p.x-1,p.y-2));
			tablero[p.x-1][p.y-2].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[1] = tablero[p.x-1][p.y-2];				
			}
		}
		if(celdaDisponible(p.x+1,p.y-2)) {
			grado = calculaGrado(new Point(p.x+1,p.y-2));
			tablero[p.x+1][p.y-2].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[2] = tablero[p.x+1][p.y-2];
			}
		}
		if(celdaDisponible(p.x+2,p.y-1)) {
			grado = calculaGrado(new Point(p.x+2,p.y-1));
			tablero[p.x+2][p.y-1].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[3] = tablero[p.x+2][p.y-1];				
			}
		}
		if(celdaDisponible(p.x+2,p.y+1)) {
			grado = calculaGrado(new Point(p.x+2,p.y+1));
			tablero[p.x+2][p.y+1].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[4] = tablero[p.x+2][p.y+1];				
			}
		}
		if(celdaDisponible(p.x+1,p.y+2)) {
			grado = calculaGrado(new Point(p.x+1,p.y+2));
			tablero[p.x+1][p.y+2].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[5] = tablero[p.x+1][p.y+2];				
			}
		}
		if(celdaDisponible(p.x-1,p.y+2)) {
			grado = calculaGrado(new Point(p.x-1,p.y+2));
			tablero[p.x-1][p.y+2].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[6] = tablero[p.x-1][p.y+2];				
			}
		}
		if(celdaDisponible(p.x-2,p.y+1)) {
			grado = calculaGrado(new Point(p.x-2,p.y+1));
			tablero[p.x-2][p.y+1].setGrado(grado);
			if(grado > 0 || movimientos == this.n*this.n-2) {
				posiblesCaminos[7] = tablero[p.x-2][p.y+1];				
			}
		}
		return posiblesCaminos;
	}
	
	private int calculaGrado(Point p) {
		int respuesta = 0;
		if(celdaDisponible(p.x-2,p.y-1)) {	respuesta += 1;	}
		if(celdaDisponible(p.x-1,p.y-2)) {	respuesta += 1;	}
		if(celdaDisponible(p.x+1,p.y-2)) {	respuesta += 1;	}
		if(celdaDisponible(p.x+2,p.y-1)) {	respuesta += 1;	}
		if(celdaDisponible(p.x+2,p.y+1)) {	respuesta += 1;	}
		if(celdaDisponible(p.x+1,p.y+2)) {	respuesta += 1;	}
		if(celdaDisponible(p.x-1,p.y+2)) {	respuesta += 1;	}
		if(celdaDisponible(p.x-2,p.y+1)) {	respuesta += 1;	}
		return respuesta;
	}
	
	private boolean celdaDisponible(int x, int y) {
		if(x >= 0 && x <= this.n-1 && y >= 0 && y <= this.n-1) {
			if(!this.tablero[x][y].Visitada()) {
				return true;
			}
		}
		return false;
	}
	
	private int calculaMejorCamino(Celda[] posiblesCaminos) {
		int indiceDelMejorCamino = -1;
		int gradosDelMejorCamino = 8;
		for(int i = 0; i < posiblesCaminos.length; i++) {
			if(posiblesCaminos[i] != null) {
				if(posiblesCaminos[i].getGrado() < gradosDelMejorCamino) {
					indiceDelMejorCamino = i;
					gradosDelMejorCamino = posiblesCaminos[i].getGrado();
				}
			}
		}
		return indiceDelMejorCamino;
	}
	
}
