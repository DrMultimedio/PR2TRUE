public class main2 {
		  public static void main(String[] args){
			  

			  //////// lectura de DICCVECTOR
		    Diccionario diccio=new DiccVector();
		      diccio.leeDiccionario("pruebameplease.txt");
		     
		      System.out.println(" BIENVENID@ A LA PRUEBA DE DICCVECTOR ");
		      
		      diccio.visualiza();
		      diccio.borra(null); //false
		      System.out.println();
		      System.out.println("VISUALIZA PARA MI PEQUE");
		      diccio.visualiza(5);
		      System.out.println(diccio.traduce(null, 'O')); //NULL
		      System.out.println(diccio.traduce(null, 'E')); //NULL
		      
		      System.out.println();
		      
		      System.out.println(diccio.busca("Yuri HARD"));
		      System.out.println(diccio.borra("debe") + " te borra"); //true
		      System.out.println(diccio.busca("Yuri HARD"));
		      System.out.println(diccio.busca("DeBe") + " ha sido borrado"); //-1
		     
		      System.out.println("DICCVECTOR");
		      
		      System.out.println(diccio.traduce("YuRi HarD", 'F')); //pornoso
		      System.out.println(diccio.traduce("YuRi hard", 'E')); //sexy
		      System.out.println(diccio.busca(null));
		      System.out.println(diccio.borra("debe") + " no borra"); //false
		      System.out.println(diccio.borra("YURI hard") + " TRUE"); //true
		      System.out.println(diccio.busca("Yuri HARD"));	//-1
		      System.out.println(diccio.traduce("Yuri hard", 'E') + " null"); //null
		      
		      
		      System.out.println();
		      System.out.println("DICCVECTOR");
		      
		      
		      System.out.println("no hay nada que visualizar");
		      diccio.visualiza(-100); System.out.println("nothing"); 
		      diccio.visualiza(); System.out.println("nothing");  //nada
		      diccio.visualiza(5,'E'); System.out.println("nothing");  //nada
		      diccio.visualiza(-5,'E'); System.out.println("nothing"); //nada
		      System.out.println("a partir de aqui");
		      System.out.println();
		      System.out.println();
		      
		      Diccionario diccio2=new DiccVector();
		      diccio2.leeDiccionario("yuri.txt");
		      diccio2.visualiza();
		      System.out.println("DICCVECTOR");
		      System.out.println(diccio2.busca("The Blue-Eye Material65")); //a mi me sale 8
		      System.out.println(diccio2.traduce("Citrus", 'E')); //como que null?? mei guarra
		      System.out.println(diccio2.busca("Ano Ko no Ie")); //a mi me sale 6
		      System.out.println(diccio2.traduce("Cirque Arachne97", 'F')); //dynasty
		      System.out.println(diccio2.borra("citrus"));
		      System.out.println(diccio2.borra("Cat's Eye Hall85")); //true
		      
		      System.out.println();
		      System.out.println();
		      
		      System.out.println("mira la ultima palabra");
		      
		      char idi[] ={'E', 'F'};
		      Palabra2 deboserultima= new Palabra2("ZZTOP", idi);
		      System.out.println( diccio2.inserta(deboserultima)); //false
		      diccio2.visualiza();
		      
		      System.out.println();
		      System.out.println();
		      System.out.println("ahora el orden de las letras es el correcto");
		      System.out.println();
		      
		      char cusa[] ={'F', 'E'};
		      Palabra2 deboserultima2= new Palabra2("ZZTOP", cusa);
		      System.out.println( diccio2.inserta(deboserultima2)); //true
		      diccio2.visualiza();
		      
		      System.out.println();
		      System.out.println();
		      System.out.println();
		      System.out.println("AHORA DICCLIS");
		      
		      /////LECTURA DE DICCLIS
			    Diccionario diccio3=new DiccLisJava();
			      diccio3.leeDiccionario("pruebameplease.txt");
			      System.out.println(" BIENVENID@ A LA PRUEBA DE DICCLIS ");
			      
			      diccio3.visualiza();
			      diccio3.borra(null); //false
			      diccio3.visualiza(5);
			      System.out.println(diccio3.traduce(null, 'O'));
			      System.out.println(diccio3.traduce(null, 'E')); //-1
			      
			      System.out.println();
			      
			      
			      System.out.println(diccio3.borra("debe") + " te borra"); //true
			      System.out.println(diccio3.busca("DeBe") + " ha sido borrado"); //-1
			     
			      System.out.println();
			      
			      System.out.println(diccio3.traduce("YuRi HarD", 'F')); //pornoso
			      System.out.println(diccio3.traduce("YuRi", 'E')); //excitante
			      System.out.println(diccio3.busca(null));
			      System.out.println(diccio3.borra("debe") + " no borra"); //false
			      System.out.println(diccio3.borra("YURI hard") + " TRUE"); //true
			      System.out.println(diccio3.busca("Yuri HARD"));	//-1
			      System.out.println(diccio3.traduce("Yuri hard", 'E') + " null"); //null
			      
			      
			      System.out.println();
			      System.out.println("DICCLIS");
			      
			      
			      System.out.println("no hay nada que visualizar");
			      diccio3.visualiza(-100); System.out.println("nothing"); 
			      diccio3.visualiza(); System.out.println("nothing");  //nada
			      diccio3.visualiza(5,'E'); System.out.println("nothing");  //nada
			      diccio3.visualiza(-5,'E'); System.out.println("nothing"); //nada
			      System.out.println("a partir de aqui");
			      System.out.println();
			      System.out.println();
			      
			      Diccionario diccio4=new DiccLisJava();
			      diccio4.leeDiccionario("yuri.txt");
			      diccio4.visualiza();
			      System.out.println();
			      System.out.println(diccio4.busca("The Blue-Eye Material65")); //a mi me sale 8
			      System.out.println(diccio4.traduce("Citrus", 'E')); //como que null?? mei guarra
			      System.out.println(diccio4.busca("Ano Ko no Ie")); //a mi me sale 6
			      System.out.println(diccio4.traduce("Cirque Arachne97", 'F')); //dynasty
			      System.out.println(diccio4.borra("citrus")); 
			      System.out.println(diccio4.borra("Cat's Eye Hall85")); //true
			      
			      System.out.println();
			      System.out.println("DICCLIS");
			      
			      System.out.println("mira la ultima palabra");
			      
			      
			      System.out.println( diccio4.inserta(deboserultima)); //false
			      diccio4.visualiza();
			      
			      System.out.println();
			      System.out.println("DICCLIS");
			      System.out.println("ahora el orden de las letras es el correcto");
			      System.out.println();
			      
			     
			      System.out.println( diccio4.inserta(deboserultima2)); //true
			      diccio4.visualiza();
		      
			      
			      /////LECTURA DE DICCmyLIS
				    Diccionario diccio5=new DiccMiLista();
				      diccio5.leeDiccionario("pruebameplease.txt");
				     
				      System.out.println(" BIENVENID@ A LA PRUEBA DE DICCMYLIS ");
				      
				      diccio5.visualiza();
				      diccio5.borra(null); //false
				      diccio5.visualiza(5);
				      System.out.println(diccio5.traduce(null, 'O'));
				      System.out.println(diccio5.traduce(null, 'E')); //-1
				      
				      System.out.println("DICCMYLIS");
				      
				      
				      System.out.println(diccio5.borra("debe") + " te borra"); //true
				      System.out.println(diccio5.busca("DeBe") + " ha sido borrado"); //-1
				     
				      System.out.println();
				      
				      System.out.println(diccio5.traduce("YuRi HarD", 'F')); //pornoso
				      System.out.println(diccio5.traduce("YuRi", 'E')); //excitante
				      System.out.println(diccio5.busca(null));
				      System.out.println(diccio5.borra("debe") + " no borra"); //false
				      System.out.println(diccio5.borra("YURI hard") + " TRUE"); //true
				      System.out.println(diccio5.busca("Yuri HARD"));	//-1
				      System.out.println(diccio5.traduce("Yuri hard", 'E') + " null"); //null
				      
				      
				      System.out.println();
				      System.out.println("DICCMYLIS");
				      
				      
				      System.out.println("no hay nada que visualizar");
				      diccio5.visualiza(-100); System.out.println("nothing"); 
				      diccio5.visualiza(); System.out.println("nothing");  //nada
				      diccio5.visualiza(5,'E'); System.out.println("nothing");  //nada
				      diccio5.visualiza(-5,'E'); System.out.println("nothing"); //nada
				      System.out.println("a partir de aqui");
				      System.out.println();
				      System.out.println();
				      
				      Diccionario diccio6=new DiccMiLista();
				      diccio6.leeDiccionario("yuri.txt");
				      diccio6.visualiza();
				      System.out.println("DICCMYLIS");
				      System.out.println(diccio6.busca("The Blue-Eye Material65")); //a mi me sale 8
				      System.out.println(diccio6.traduce("Citrus", 'E')); //como que null?? mei guarra
				      System.out.println(diccio6.busca("Ano Ko no Ie")); //a mi me sale 6
				      System.out.println(diccio6.traduce("Cirque Arachne97", 'F')); //dynasty
				      System.out.println(diccio6.borra("citrus"));
				      System.out.println(diccio6.borra("Cat's Eye Hall85")); //true
				      
				      System.out.println();
				      System.out.println("DICCMYLIS");
				      
				      System.out.println("mira la ultima palabra");
				      
				      
				      System.out.println( diccio6.inserta(deboserultima)); //false
				      diccio6.visualiza();
				      
				      System.out.println();
				      System.out.println();
				      System.out.println("ahora el orden de las letras es el correcto");
				      System.out.println("DICCMYLIS");
				      
				     
				      System.out.println( diccio6.inserta(deboserultima2)); //true
				      diccio6.visualiza();
			      
		  }}