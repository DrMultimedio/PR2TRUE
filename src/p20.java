//BIENVENIDO/A A LA PRUEBA 20 :D
//AUTOR: JOSE MANUEL PALAU ALEGRIA
// La prueba consiste en borrar cositas de diccvector
public class p20 {
	  public static void main(String[] args){
		  DiccVector v = new DiccVector();
		  v.leeDiccionario("p20.dic");
		  v.visualiza();
		  
		  System.out.println(v.borra("address"));
		  System.out.println(v.borra("please"));
		  System.out.println(v.borra("wrong"));
		  System.out.println(v.borra(null));
		  System.out.println(v.borra("OVERWATCH :D"));

		  System.out.println();
		  System.out.println("Ahora con los borradicos");
		  v.visualiza();
		  v.visualiza(400, 'K');

		  System.out.println();
		  System.out.println("Vamos a borrar ahora todos desde la cabeza");
		  v.borra("badly");
		  v.borra("family");
		  v.borra("lay");
		  v.borra("normal");
		  v.borra("photograph");
		  v.borra("toy");
		  v.borra("vowel");
		  v.visualiza();
		  System.out.println();
		  System.out.println("No deberia quedar nada aqui ^^");
		  System.out.println("¿Todo correcto? :)");

		  v.visualiza(5);
		  v.visualiza(5000);
		  v.visualiza(400, 'K');
		  v.visualiza(5, 'E');
	  }
}
