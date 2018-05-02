// Brian Reyes - A01633401
// Rafael Elu - A01634309
// Clase: Celda
// 02 de mayo de 2018

public class Celda {
	
	int valor,
			 x,
			 y,
			 grado;
	boolean visitada;
	
	public Celda(int x, int y) {
		this.x = x;
		this.y = y;
		this.visitada = false;
	}
	
	public int getValor() {
		return this.valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getGrado() {
		return this.grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	public boolean Visitada() {
		return this.visitada;
	}
	public void setVisitada(boolean visitada) {
		this.visitada = visitada;
	}
	
}
