
public class Pruebalisbili {

	public static void main(String[] args) {
		
		ListaBilingue dicc=new ListaBilingue();
		dicc.leeDiccionario(args[0]);
		System.out.println("----------------------CASOS NORMALES------------------------");
		dicc.visualizaO();
		System.out.println("------------------------------------------------");
		dicc.visualizaD();
		System.out.println("------------------------------------------------");
		System.out.println("Traduccion de hola : "+dicc.buscaO("hola"));
		System.out.println("------------------------------------------------");
		System.out.println("Traduccion de godbye : "+dicc.buscaD("godbye"));
		System.out.println("------------------------------------------------");
		System.out.println("Indice hola: "+dicc.indiceO("hola"));
		System.out.println("------------------------------------------------");
		System.out.println("Indice hola: "+dicc.indiceD("cat"));
		System.out.println("------------------------------------------------");
		System.out.println("Borra hola: "+dicc.borraO("hola"));
		System.out.println("------------------------------------------------");
		dicc.visualizaO();
		System.out.println("------------------------------------------------");
		dicc.visualizaD();
		System.out.println("------------------------------------------------");
		System.out.println("Inserta hola: "+dicc.inserta("hola", "hello"));
		System.out.println("------------------------------------------------");
		dicc.visualizaO();
		System.out.println("------------------------------------------------");
		dicc.visualizaD();
		System.out.println("----------------------origen--------------------------");
		System.out.println(dicc.getO(0));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getO(1));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getO(2));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getO(3));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getO(4));
		System.out.println("-----------------------destino------------------------");
		System.out.println(dicc.getD(0));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getD(1));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getD(2));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getD(3));
		System.out.println("------------------------------------------------");
		System.out.println(dicc.getD(4));
		System.out.println("----------------------CASOS ESPECIALES------------------------");
		System.out.println("Traduccion de manzana : "+dicc.buscaO("manzana"));
		System.out.println("------------------------------------------------");
		System.out.println("Traduccion de manzano : "+dicc.buscaD("manzano"));
		System.out.println("------------------------------------------------");
		System.out.println("Indice manzana: "+dicc.indiceO("manzana"));
		System.out.println("------------------------------------------------");
		System.out.println("Indice manzano: "+dicc.indiceD("manzano"));
		System.out.println("------------------------------------------------");
		System.out.println("Traduccion de manzana : "+dicc.buscaO(null));
		System.out.println("------------------------------------------------");
		System.out.println("Traduccion de manzano : "+dicc.buscaD(null));
		System.out.println("------------------------------------------------");
		System.out.println("Indice manzana: "+dicc.indiceO(null));
		System.out.println("------------------------------------------------");
		System.out.println("Indice manzano: "+dicc.indiceD(null));
		System.out.println("------------------------------------------------");
		System.out.println("Borra manzana: "+dicc.borraO("manzana"));
		System.out.println("------------------------------------------------");
		System.out.println("Borra manzano: "+dicc.borraD("manzano"));
		System.out.println("------------------------------------------------");
		System.out.println("Borra manzana: "+dicc.borraO(null));
		System.out.println("------------------------------------------------");
		System.out.println("Borra manzano: "+dicc.borraD(null));


	}

}
