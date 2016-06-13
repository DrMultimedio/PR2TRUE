
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Modulos añadidos
		
		///////////////////Se ha añadido Numleng en palabras qeu devuelve el numero de lenguas
		///////////////////Y un get idiomas qeu devuelve los idiomas char[]
		///////////////////Editar la clase palabra2 para que tenga inicialmente valores para los idiomas EFP
	
		
		
		////////////////Palabra//////////////////////////////
		//Probando el constructor de palabra2
		System.out.println("///PALABRA////");
		System.out.println();
		
		Palabra2 hola = new Palabra2("Buenos dias", null);
		char[] idiomasac = hola.getidiomas();
		System.out.println(	hola.getNumleng()); //3
		for (int a=0; a<hola.getNumleng(); a++){
			System.out.print(idiomasac[a]); 	//EFP
		}
		
		System.out.println();
		System.out.println(hola.getOrigen()); //buenos dias
		System.out.println();
		
		char[] idi={'a', 'b', 'c'};
		hola = new Palabra2("bolleria industrial", idi);
		System.out.println(	hola.getNumleng()); //3
		idiomasac = hola.getidiomas();
		for (int a=0; a<hola.getNumleng(); a++){
			System.out.print(idiomasac[a]);	//abc
		}
		
		System.out.println();
		System.out.println(hola.getOrigen()); //bolleria industrial
		System.out.println();
		
		char[] idiomas={'h', 'o', 'l', 'a'};
		hola = new Palabra2("madoka", idiomas);
		System.out.println(	hola.getNumleng()); //4
		idiomasac = hola.getidiomas();
		for (int a=0; a<hola.getNumleng(); a++){
			System.out.print(idiomasac[a]);	//hola
		}
		
		System.out.println();
		System.out.println(hola.getOrigen()); //madoka
		System.out.println();
		
		//Probando setTraduccion de palabra
		
		Palabra2 opai = new Palabra2("dog", null); //EFP idiomas
		
		System.out.println(opai.setTrad(null, 'E')); //-1
		System.out.println(opai.setTrad(null, 'O')); //-1
		System.out.println(opai.getTraduccion('O')); //null
		System.out.println(opai.getTraduccion('E')); //null
		System.out.println(opai.getTraduccion('F')); //null
		System.out.println(opai.getTraduccion('P')); //null
		System.out.println(opai.setTrad("perro", 'O')); //-1
		opai.escribeInfo(); //dog:::
		System.out.println();
		System.out.println();
		
		System.out.println(opai.setTrad("perro", 'E')); //0
		System.out.println(opai.getTraduccion('E')); //perro
		System.out.println(opai.getTraduccion('F')); //null
		System.out.println(opai.getTraduccion('P')); //null
		opai.escribeInfo(); //dog:perro::
		System.out.println();
		System.out.println();
		
		System.out.println(opai.setTrad("yo", 'E')); //0
		System.out.println(opai.getTraduccion('E')); //yo
		System.out.println(opai.getTraduccion('F')); //null
		System.out.println(opai.getTraduccion('P')); //null
		System.out.println(opai.setTrad(null, 'E')); //-1
		opai.escribeInfo(); //dog:yo::
		System.out.println();
		System.out.println();
		
		System.out.println(opai.setTrad("chien", 'F')); //1
		System.out.println(opai.getTraduccion('E')); //yo
		System.out.println(opai.getTraduccion('F')); //chien
		System.out.println(opai.getTraduccion('P')); //null
		opai.escribeInfo(); //dog:yo:chien:
		System.out.println();
		System.out.println();
		
		System.out.println(opai.setTrad("cao", 'P')); //2
		System.out.println(opai.getTraduccion('E')); //yo
		System.out.println(opai.getTraduccion('F')); //chien
		System.out.println(opai.getTraduccion('P')); //cao
		opai.escribeInfo(); //dog:yo:chien:cao
		System.out.println();
		System.out.println();
		
		System.out.println(opai.setTrad("perro", 'E')); //0
		System.out.println(opai.getTraduccion('E')); //perro
		System.out.println(opai.getTraduccion('F')); //chien
		System.out.println(opai.getTraduccion('P')); //cao
		opai.escribeInfo(); //dog:yo:chien:cao
		System.out.println();
		System.out.println();
		
		System.out.println(opai.setTrad("chien", 'F')); //-1
		System.out.println(opai.getTraduccion('E')); //perro
		System.out.println(opai.getTraduccion('F')); //chien
		System.out.println(opai.getTraduccion('P')); //cao
		opai.escribeInfo(); //dog:perro:chien:cao
		System.out.println();
		
		System.out.println(opai.getOrigen()); //dog
		
		Palabra2 opai2 = new Palabra2("dog", null);
		System.out.println(opai2.setTrad("perro", 'E'));
		System.out.println(opai2.setTrad("chien", 'F'));
		System.out.println(opai2.setTrad("cao", 'P'));
		
		
		//// Interface diccionario
		DiccVector soy = new DiccVector();
		Palabra2 distinta = new Palabra2("minimanitas", null);
		System.out.println(distinta.setTrad("perro", 'E'));
		System.out.println(distinta.setTrad("chien", 'F'));
		System.out.println(distinta.setTrad("caos", 'P'));
		
		Palabra2 convacios = new Palabra2("madoka", null);
		System.out.println(convacios.setTrad("perro", 'E'));
		System.out.println(convacios.setTrad("chien", 'P'));
		
		Palabra2 busca = new Palabra2("comprobando", null);
		
		
		//Insertando palabras y comprobando su busqueda con binario
		System.out.println(soy.inserta(opai)); //true
		System.out.println(soy.inserta(opai2));  //false
		soy.visualiza(); //dog:perro:chien:cao
		System.out.println();
		System.out.println(soy.inserta(hola)); //false
		soy.visualiza(); //dog:perro:chien:cao
		System.out.println(soy.inserta(distinta)); // true
		soy.visualiza(); //dog:perro:chien:cao   minimanitas:perro:chien:caos
		System.out.println(soy.inserta(convacios)); //true
		soy.visualiza(); //dog:perro:chien:cao madoka:perro::chien	minimanitas:perro:chien:caos 
		System.out.println(soy.busca("lolis")); //-1
		System.out.println(soy.busca("minimanitas")); //2
		System.out.println(soy.busca("madoka")); //num
		System.out.println(soy.busca("dog"));  //num1
		System.out.println(soy.inserta(busca));	//true
		System.out.println(soy.inserta(busca));	//false
		soy.visualiza();
		System.out.println(soy.busca("madoka")); //devulve un numero
		System.out.println(soy.busca("comprobando")); //num
		System.out.println(soy.busca("dog")); //num
		
		System.out.println();
		System.out.println();
		
		
		// Traducee 
		System.out.println(soy.traduce(null, 'E'));	//null
		System.out.println(soy.traduce("madoka", 'E')); //perro
		System.out.println(soy.traduce("madoka", 'I')); //null
		System.out.println(soy.traduce("minimanitas", 'P')); //caos
		System.out.println(soy.traduce("pedo", 'E')); //null
		
		
		System.out.println();
		System.out.println();
		
		//Borrando elementos de DiccVector
		System.out.println(soy.borra("madoka")); //true
		System.out.println(soy.borra("me")); //false
		System.out.println(soy.borra("madoka")); //false
		System.out.println(soy.borra(null)); //false
		soy.visualiza(); //comprobando::: 	dog:perro:chien:cao 	minimanitas:perro:chien:cao
		System.out.println(soy.inserta(convacios));
		soy.visualiza(); // comprobando::: 	dog:perro:chien:cao		madoka:perro::chien 	minimanitas:perro:chien:caos
		
		//Comprobando las visualizaciones
		
		System.out.println();
		System.out.println();

		System.out.println("visualizaciones");
		soy.visualiza(-6); //null
		//System.out.println();
		soy.visualiza(2); // comprobando::: dog:perro:chien:cao
		//System.out.println();
		soy.visualiza(200000);// comprobando::: dog:perro:chien:cao madoka:perro::chien minimanitas:perro:chien:caos
		//System.out.println();
		soy.visualiza(-6, 'E'); // null
		System.out.println();
		soy.visualiza(2, 'J'); //null
		System.out.println();
		soy.visualiza(1, 'E'); // comprobando:
		soy.visualiza(0, 'E'); //null
		
		
		System.out.println();
		soy.visualiza(8, 'P'); // comprobando: dog:cao madoka:chien minimanitas:caos
		
		DiccVector Cosavacia= new DiccVector();
		System.out.println(Cosavacia.busca(null)); //-1
		System.out.println(Cosavacia.busca("madoka")); //-1
		System.out.println(Cosavacia.borra("madoka")); //false
		Cosavacia.visualiza(); //null
		Cosavacia.visualiza(8); //null
		Cosavacia.visualiza(10, 'E'); //null
		
	}

}
