
public class p06 {
/**
 * @author Rafael Navarro Estrella
 * Se crea un objeto de tipo DiccLisJava, se invoca su método leeDiccionario con
 * un diccionario desordenado con palabras repetidas literales y con palabras que
 * no tienen todas las traducciones. Se invoca su método traduce para diferentes
 * palabras y diferentes lenguas, de manera que unas veces devuelve la traducción
 * y otras no.	
 */
	public static void main(String[] args) {
		DiccLisJava dlj = new DiccLisJava();
		dlj.leeDiccionario("dicc06.txt");
		System.out.println("-------DICCIONARIO-------");
		System.out.println("---------E F P I---------");
		dlj.visualiza();
		
		System.out.println("-------TRADUCIR PALABRAS-------");
		
		System.out.println("PALABRAS CON TRADUCCION");
		System.out.print("Traducir cat a F: ");
		System.out.println(dlj.traduce("cat", 'F'));
		System.out.print("Traducir perro a E: ");
		System.out.println(dlj.traduce("dog", 'E'));
		System.out.print("Traducir demon a I: ");
		System.out.println(dlj.traduce("demon", 'I'));
		
		System.out.println("PALABRAS SIN TRADUCCION");
		System.out.print("Traducir friend a F: ");
		System.out.println(dlj.traduce("friend", 'F'));
		System.out.print("Traducir cat a E: ");
		System.out.println(dlj.traduce("cat", 'E'));
		System.out.print("Traducir car a I: ");
		System.out.println(dlj.traduce("car", 'I'));
		System.out.print("Traducir amalgamated a P: ");
		System.out.println(dlj.traduce("amalgamated", 'P'));

	}

}
