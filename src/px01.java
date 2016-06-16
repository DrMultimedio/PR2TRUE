//esto es una prueba extra (de ahi la x)
//Autor Jose Manuel Palau Alegria
//vamos a insertar unas cuantas palabras a mano en ListaBilingue
public class px01 {
	public static void main(String[] args) {
		ListaBilingue lista = new ListaBilingue();
		lista.inserta("Shoe", "Zapato");
		lista.inserta("TeM", "TEM");
		lista.inserta("hOi!", "ola");
		lista.inserta("Greetings", "Holap");
		lista.inserta("Tablet", "Lamentablet");
		lista.inserta("Crossword00", "Crucigramo");
		lista.inserta("Dark Souls", "Almas oscuritas");
		lista.inserta("Dark Souls 2: Scholar of the first sin", "Almas Oscuritas 2: Miarma ");
		
		lista.visualizaO();

	}
}
