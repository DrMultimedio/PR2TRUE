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
		System.out.println();
		System.out.println("Borremos tablet");
		System.out.println();
		System.out.println(lista.borraD("Lamentablet"));
		System.out.println();
		System.out.println("VEAMOS SI SE BORRO EN ORIGEN");
		lista.visualizaO();
		System.out.println("VEAMOS SI SE BORRO EN BILINGUE");
		lista.visualizaD();
		System.out.println();
		System.out.println("Borremos Dark Souls 2: Scholar of the first sin");
		System.out.println();
		System.out.println(lista.borraO("Dark Souls 2: Scholar of the first sin"));
		System.out.println();
		System.out.println("VEAMOS SI SE BORRO EN ORIGEN");
		lista.visualizaO();
	    System.out.println();
		System.out.println("VEAMOS SI SE BORRO EN BILINGUE");
		lista.visualizaD();
		System.out.println("Vamos a borrar cositas que no existen");
		System.out.println(lista.borraO("madres wey"));
		System.out.println(lista.borraD("madres wey"));
		System.out.println(lista.borraO(""));
		System.out.println(lista.borraD(""));
		System.out.println(lista.borraO(null));
		System.out.println(lista.borraD(null));

		System.out.println();
		System.out.println("PRUEBECICAS DE BUSQUEDA");
		System.out.println(lista.buscaO("shoe"));
		System.out.println(lista.buscaO("Dark souls"));
		System.out.println(lista.buscaD("ola"));
		System.out.println(lista.buscaD("holap"));
		System.out.println(lista.buscaD("`lamentablet"));
		System.out.println("PRUEBECICAS DE Indice");
		System.out.println(lista.indiceO("shoe"));
		System.out.println(lista.indiceO("amazin"));
		System.out.println(lista.indiceD("amazin"));
		System.out.println(lista.indiceO("Dark souls"));
		System.out.println(lista.indiceD("ola"));
		System.out.println(lista.indiceD("holap"));
		System.out.println(lista.indiceD("`lamentablet"));
		System.out.println("Pasemosle cosas raras");
		System.out.println(lista.indiceD("f"));
		System.out.println(lista.indiceO("hi"));
		System.out.println(lista.indiceD(""));
		System.out.println(lista.indiceD(null));
		System.out.println(lista.indiceO(""));
		System.out.println(lista.indiceO(null));

		System.out.println();
		System.out.println("PRUEBECICAS DE VECTORES");
		//vamos a pedirle unos cualquiera
		System.out.println(lista.getO(4).toString());
		System.out.println(lista.getD(4).toString());
		//vamos a pedirle los primeros
		System.out.println(lista.getO(0).toString());
		System.out.println(lista.getD(0).toString());
		//vamos a pedirle los ultimos :D
		System.out.println(lista.getD(5).toString());
		System.out.println(lista.getO(5).toString());
		//vamos a pedirle que no estan (tendrian que ser nullsito)
		System.out.println(lista.getO(6));
		System.out.println(lista.getO(-1));
		System.out.println(lista.getO(6000000));


	}
}
