public class KnightsTour {
	
	public static void main(String[] args) {
		Modelo m = new Modelo(8);
		System.out.println(m.knightsTour(0,0));
		m.imprimeTablero();
	}
	
}
