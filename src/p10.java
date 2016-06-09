
public class p10 {
	/**
	 * @author Rafael Navarro Estrella
	 * Se crea un objeto de tipo DiccVector y se invoca su método leeDiccionario con
	 * un diccionario desordenado, sin palabras repetidas. Se invoca su método busca
	 * con palabras que unas veces sí que están en el diccionario y otras no.
	 */
		public static void main(String[] args) {
			DiccVector dv = new DiccVector();
			dv.leeDiccionario("dicc10.txt");
			System.out.println("-------DICCIONARIO------");
			System.out.println("--------E F P I V-------");
			dv.visualiza();
			System.out.println("-------BUSQUEDA------");
			
			System.out.println("PALABRAS QUE SI ESTAN");
			System.out.print("Buscar en el diccionario amalgamated(primera): ");
			System.out.println(dv.busca("amalgamated"));
			System.out.print("Buscar en el diccionario gun(por en medio): ");
			System.out.println(dv.busca("gun"));
			System.out.print("Buscar en el diccionario chair(por en medio): ");
			System.out.println(dv.busca("chair"));
			System.out.print("Buscar en el diccionario button(por en medio): ");
			System.out.println(dv.busca("button"));
			System.out.print("Buscar en el diccionario revenant(ultima): ");
			System.out.println(dv.busca("revenant"));
			
			System.out.println("PALABRAS QUE NO ESTAN");
			System.out.print("Buscar en el diccionario euphoria: ");
			System.out.println(dv.busca("euphoria"));
			System.out.print("Buscar en el diccionario feminism: ");
			System.out.println(dv.busca("feminism"));
			System.out.print("Buscar en el diccionario kill: ");
			System.out.println(dv.busca("kill"));
			System.out.print("Buscar en el diccionario justice: ");
			System.out.println(dv.busca("justice"));
			
		}
}
