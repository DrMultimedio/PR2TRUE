public class PruebaDiccionarios {
	//buscar que me da la palabra central de busqueda binaria
	//meter de nuevo family en el diccionario con el inserta de palabra
		  public static void main(String[] args){
			//SENYORES ESTE MAIN ES UN CHEETO, PERMITE PROBAR 3.JAVA
			//PARA ELLO SOLO TENEIS QUE CAMBIAR LA DECLARACION DE DICCIONARIO
			//SI QUEREIS METERLE MAS MIERDA Y SER MALOS , MODIFICAD LO QUE QUERAIS
			//Diccionario diccio=new DiccMiLista();
			//Diccionario diccio=new DiccLisJava();
		    Diccionario diccio=new DiccVector();
		    
		    //creacion de palabras
		    String lexeme=new String("family");
		    String[] meaning=new String[3];
		    char[] language=new char[3];
		    meaning[0]=new String("famille");
		    language[0]='F';
		    meaning[1]=new String("familia");
		    language[1]='E';
		    meaning[2]=new String("famalia");
		    language[2]='P';
		    
		    if(args.length>=1){
		      diccio.leeDiccionario(args[0]);
		      diccio.visualiza();
		      System.out.println("----------------------CASOS NORMALES----------------------------");
		      System.out.println("Posicion de family: "+diccio.busca("family")); // 3
		      System.out.println("---------------------------------------------------------------------");
		      System.out.println("Borra family: "+diccio.borra("family")); //true
		      System.out.println("---------------------------------------------------------------------");
		      System.out.println("Posicion de family: "+diccio.busca("family")); //-9
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza();
		      System.out.println("---------------------------------------------------------------------");
		      System.out.println("Traduccion de wrong a espanyol: "+diccio.traduce("wrong",'E')); //equivocado
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza(15);
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza(5);
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza(1);
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza(15,'E');
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza(5,'E');
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza(1,'E');
		      System.out.println("---------------------------------------------------------------------");
		     ///meto la palabra borrada
		      Palabra2 p=new Palabra2(lexeme,language);
		      for(int i=0;i<language.length;i++){
		    	     p.setTrad(meaning[i],language[i]);
		    	    }
		      System.out.println("Inserta family: "+diccio.inserta(p)); //true
		      System.out.println("---------------------------------------------------------------------");
		      diccio.visualiza();
		      System.out.println("----------------------CASOS RAROS----------------------------");
		      diccio.visualiza(-1); //PREGUNTAR A ALICIA SI NOS PUEDEN PASAR NUMEROS NEGATIVOS Y QUE HACER EN CASO AFIRMATIVO
		      System.out.println("Posicion de ¡null!: "+diccio.busca(null)); //-3(lista) //-3(vector) //-10(milista)
		      System.out.println("---------------------------------------------------------------------");
		      System.out.println("Borra toya: "+diccio.borra("toya")); //false
		      System.out.println("---------------------------------------------------------------------");
		      System.out.println("Borra un null: "+diccio.borra(null)); //false
		      System.out.println("---------------------------------------------------------------------");
		      System.out.println("Traduccion de wrong a una lengua que no existe: "+diccio.traduce("wrong",'I')); //null
		      
		      
		      
		    }
		    else
		     System.out.println("Forma uso: java p05 p05.dic");
		    
		  }
}
