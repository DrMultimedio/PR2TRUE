//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL<
import java.io.*;
import java.util.*;

public class DiccVector implements Diccionario{
	
	private int nlenguas;
	private Vector<Character> lenguas;
	private Vector<Palabra2> dicc;
	private char[] lenguasaux; //defino un array de caracteres extra para pasarlo a palabra2
	
	public DiccVector()
	{
		nlenguas=-1;
		dicc = new Vector<Palabra2>();
		lenguas = new Vector<Character>();

	}
	
	public void leeDiccionario(String f){
		
		//definimos las variables de instancia
		
		FileReader fichero= null;
		BufferedReader lectura= null;
		
		try{ 
			//inicializamos las variables de instancia

			fichero= new FileReader(f);
			lectura= new BufferedReader(fichero);
			String linea = lectura.readLine();
			int i=0;
			while (linea!=null){
				leerLineaDicc(linea, i);
				linea=lectura.readLine(); //leemos el documento lonea a lonea
				i++;
			}
		}catch(IOException e){
			System.err.println("Error con el archivo");
			System.out.println(f);
		}
		//y cerramos el fichero
		try{
			if (fichero!=null)//comprobamos que fichero no sea null
				fichero.close();
			if (lectura!=null)//ni que lectura sea null
				lectura.close();
		}catch (IOException ex){//si esto falla lanzaremos la excepcion
			System.out.println(ex);
		}
		
		
	}

	private void leerLineaDicc(String texto, int linea) {
		
		if(linea==0){ //si es la primera linea, es donde este el numero de lenguas
			nlenguas= Integer.parseInt(texto);
 			lenguas = new Vector<Character>();
 			lenguasaux= new char[nlenguas];
		}
		if(linea==1){//si es la segunda, es donde estan las lenguas
			String separador= " ";
			String [] s = texto.split( separador ) ;
			for(int i=0; i<nlenguas;i++){
				lenguas.add(s[i].charAt(0)); //meto las lenguas en un vector de caracteres
				lenguasaux[i]=s[i].charAt(0); //y en un array de caracteres para  enviarsealas a las palabras2
			}
			
		}
		
		if(linea>1){
			String separador1= "[ ]*\\*[ ]*";
			
			String[] s = texto.split(separador1);
			Palabra2 p=new Palabra2(s[0], lenguasaux);
			
			//recorro el array que he creado separando la linea, menos uno, dado que 
			//origen ya la he almacenado
			for(int j=0; j<s.length-1 && j<p.getLenguas().length;j++){
				if (s[j]!=null)
				{
					//j+1 porque s[0] es la palabra origen
					p.setTrad(s[j+1], p.getLenguas()[j]);	

				}

			}
				inserta(p);

			}
		}
		

	
	
	public boolean inserta(Palabra2 p) {
		boolean rep=false, ret= true;
		int actual = 0;
		//compruebo que la palabra tenga los mismos idiomas que mi diccionario
		for(int i=0; i<nlenguas; i++){
			if(lenguas.get(i)!=p.getLenguas()[i]){
				return false;
			}
			
		}
		//compruebo si tengo la palabra en el diccionario
		for (int i=0; i<dicc.size();i++)
		{
			if (p.getOrigen().equalsIgnoreCase(dicc.get(i).getOrigen()))
			{
				rep=true;
				actual= i;
				break;
			}
		}
		
		if (rep == true){
			//si la palabra esta repetida, la combino
			dicc.get(actual).combinaPalabra(p);
			ret=false;
		}
		else
		{
			//si no esta repetida, la agrego al final 
			dicc.add(p);
			ret=true;
			ordenaDicc();
			//una vez dentro, ordenare el vector
		}
		

		return ret;
	}

	private void ordenaDicc() {//ordeno usando el algoritmo de burbuja
		
		//vamos a sacar primero el numero de palabras que hay en el diccionario.
		Palabra2 aux;
		for (int j=0;j<dicc.size();j++){
			for (int k=0; k<dicc.size()-1;k++){
					if(dicc.get(j).getOrigen().compareToIgnoreCase(dicc.get(k).getOrigen())<0){
						aux=dicc.set(j, dicc.get(k));
						dicc.set(k, aux);
					}
			}
		}
	}

	
	public boolean borra(String s) {

		for (int i=0; i<dicc.size();i++)
		{
			if (dicc.get(i).getOrigen().equalsIgnoreCase(s))
			{
				dicc.remove(i);
				return true;
			}
		}
		return false;
	}

	public int busca(String s) {
		//este metodo busca la cadena s en el diccionario y devuelve las comparaciones que tuvo que hacer (pero optimamente)
		//para este caso implementare una busqueda binaria, consistente en dividir el array en dos para averiguar en que zona esto del array
			int i =0 ;
		if(s!=null){
			int centro, max=dicc.size()-1, min=0;
			//centro cero el centro de donde estoy buscando
			//max es el rango maximo que estoy buscando
			//min es el rango manimo 
			//i es el nomero de iteracciones que realiza el programa
			while (min<=max){
				i++;
				centro = (max + min)/2;
				if(dicc.get(centro).getOrigen().compareToIgnoreCase(s)==0){
					return i;
				}
				else if(dicc.get(centro).getOrigen().compareToIgnoreCase(s)>0){
					max=centro-1;
				}
				else{
					min = centro +1;
				}
				

				/*centro=(max+min)/2;
				if (dicc.get(centro).getOrigen().compareToIgnoreCase(s)==0){ //si me devuelve 0, las palabras son las mismas, y no tengo que buscar mos
					return i;
				}
				else{
					if(dicc.get(centro).getOrigen().compareToIgnoreCase(s)>0){//se devuelve un nomero mayor que uno, el objeto del diccionario es mayor que el que me pasan
						max=centro-1; //y por tanto, no estaro mos arriba que en el centro.
					}
					else{ //si devuelve un nomero menor que uno, la palabra buscada no estaro mos abajo del centro
						min=centro+1; // y por tanto el monimo pasaro a ser el centro
					}
				}
				*/
			}
		}
		return -i;

	}

	public int buscaMetodos(String s) {
		//este metodo hace lo mismo que busca, pero devuelve la posicion de la traduccion
		//en lugar de devolver el numero de iteraciones
		//este motodo busca la cadena s en el diccionario y devuelve las comparaciones que tuvo que hacer (pero optimamente)
		//para este caso implementaro una bosqueda binaria, consistente en dividir el array en dos para averiguar en que zona esto del array
		if(s != null){
			int centro, max=dicc.size()-1, min=0;
			//centro sero el centro de donde estoy buscando
			//max es el rango moximo que estoy buscando
			//min es el rango monimo 
			//i es el nomero de iteracciones que realiza el programa
			while (min<=max){
				centro=(max+min)/2;			
				if (dicc.get(centro).getOrigen().compareToIgnoreCase(s)==0){ //si me devuelve 0, las palabras son las mismas, y no tengo que buscar mos
					return centro;
				}
				else{
					if(dicc.get(centro).getOrigen().compareToIgnoreCase(s)>0){//se devuelve un nomero mayor que uno, el objeto del diccionario es mayor que el que me pasan
						max=centro-1; //y por tanto, no estaro mos arriba que en el centro.
					}
					else{ //si devuelve un nomero menor que uno, la palabra buscada no estaro mos abajo del centro
						min=centro+1; // y por tanto el monimo pasaro a ser el centro
					}
				}
			}
		}
		return -1;

	}
	
	public String traduce(String s, char l) {
		
		int pos= buscaMetodos(s);
		if (pos >= 0)
		{
			return dicc.get(pos).getTraduccion(l);
			
		}
		return null;
	}

	
	public void visualiza() {
		
		for(int i = 0; i<dicc.size();i++)
		{
			dicc.get(i).escribeInfo();
		}
		
	}

	
	public void visualiza(int j) {


		for(int i = 0; i<dicc.size()&&i<j;i++)
		{
			dicc.get(i).escribeInfo();
		}
				
	}

	public void visualiza(int j, char l) {

		for(int i = 0; i<dicc.size()&&i<j;i++)
		{
			dicc.get(i).escribeInfoTrad(l);
		}
	}
}
