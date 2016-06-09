
public class p05 {
/**
 * @author Rafael Navarro Estrella
 * Se crea un objeto de tipo DiccMiLista, se invoca su método leeDiccionario con
 * un diccionario ordenado sin palabras repetidas pero alguna palabra no tiene
 * traducciones para cada idioma. Se invoca su método inserta con objetos de tipo
 * Palabra2 cuya cadena en la lengua origen no está en el diccionario, de manera
 * que unas veces inserta en la cabeza, otras en la cola y otras en medio de la lista.
 * Se invoca su método visualiza.
 */
	public static void main(String[] args) {
		DiccMiLista dml = new DiccMiLista();
		dml.leeDiccionario("dicc07.txt");
		System.out.println("-------DICCIONARIO------");
		System.out.println("----------E F P---------");
		dml.visualiza();
		
		char[] lenguas = {'E' , 'F', 'P'};	
		//Palabras a insertar
		Palabra2 account = new Palabra2("account", lenguas);
		account.setTrad("cuenta", 'E');
		account.setTrad("cuentinha", 'P');
		Palabra2 abacus = new Palabra2("abacus", lenguas);
		abacus.setTrad("abaco", 'E');
		abacus.setTrad("le abaquette", 'F');
		Palabra2 more = new Palabra2("more", lenguas);
		more.setTrad("mas", 'E');
		more.setTrad("le masette", 'F');
		more.setTrad("masinho", 'P');
		Palabra2 frankly = new Palabra2("frankly", lenguas);
		frankly.setTrad("francamente", 'E');
		frankly.setTrad("francamentinho", 'P');
		Palabra2 congratulations = new Palabra2("congratulations", lenguas);
		congratulations.setTrad("enhorabuena", 'E');
		congratulations.setTrad("enhorabueninha", 'P');
		congratulations.setTrad("le enhorabuenette", 'F');
		Palabra2 totally = new Palabra2("totally", lenguas);
		totally.setTrad("totalmente", 'E');
		totally.setTrad("totalmentinho", 'P');
		
		System.out.println("-------PALABRAS------");
		account.escribeInfo();
		abacus.escribeInfo();
		more.escribeInfo();
		frankly.escribeInfo();
		congratulations.escribeInfo();
		totally.escribeInfo();
		
		System.out.println("-------INSERTAR------");
		System.out.print("Insertar account en la cabeza de la lista: ");
		System.out.println(dml.inserta(account));
		System.out.print("Insertar abacus en la cabeza de la lista: ");
		System.out.println(dml.inserta(abacus));
		System.out.print("Insertar more en la cola de la lista: ");
		System.out.println(dml.inserta(more));
		System.out.print("Insertar frankly por en medio de la lista: ");
		System.out.println(dml.inserta(frankly));
		System.out.print("Insertar congratulations por en medio de la lista: ");
		System.out.println(dml.inserta(congratulations));
		System.out.print("Insertar totally en la cola de la lista: ");
		System.out.println(dml.inserta(totally));
		
		System.out.println("-------DICCIONARIO------");
		System.out.println("----------E F P---------");
		dml.visualiza();
		
	}

}
