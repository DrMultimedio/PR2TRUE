
public class p11 {
/**
 * @author Rafael Navarro Estrella
 * Se crea un objeto de tipo DiccMiLista y se invoca su método leeDiccionario con
 * un diccionario desordenado, sin palabras repetidas. Se invoca su método busca
 * con palabras que unas veces sí que están en el diccionario y otras no.
 */
	public static void main(String[] args) {
		DiccMiLista dml = new DiccMiLista();
		dml.leeDiccionario("dicc11.txt");
		System.out.println("-------DICCIONARIO------");
		System.out.println("--------E F P I V-------");
		dml.visualiza();
		System.out.println("-------BUSQUEDA------");
		
		System.out.println("PALABRAS QUE SI ESTAN");
		System.out.print("Buscar en el diccionario amalgamated(primera): ");
		System.out.println(dml.busca("amalgamated"));
		System.out.print("Buscar en el diccionario gun(por en medio): ");
		System.out.println(dml.busca("gun"));
		System.out.print("Buscar en el diccionario chair(por en medio): ");
		System.out.println(dml.busca("chair"));
		System.out.print("Buscar en el diccionario button(por en medio): ");
		System.out.println(dml.busca("button"));
		System.out.print("Buscar en el diccionario revenant(ultima): ");
		System.out.println(dml.busca("revenant"));
		
		System.out.println("PALABRAS QUE NO ESTAN");
		System.out.print("Buscar en el diccionario euphoria: ");
		System.out.println(dml.busca("euphoria"));
		System.out.print("Buscar en el diccionario feminism: ");
		System.out.println(dml.busca("feminism"));
		System.out.print("Buscar en el diccionario kill: ");
		System.out.println(dml.busca("kill"));
		System.out.print("Buscar en el diccionario justice: ");
		System.out.println(dml.busca("justice"));
	}
}

