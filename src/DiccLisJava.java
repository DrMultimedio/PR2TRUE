//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class DiccLisJava implements Diccionario{
	

	private int nlenguas;
	private Vector<Character> lenguas;
	private LinkedList<Palabra2> dicc;
	private char[] lenguasaux; //defino un array de caracteres extra para pasarlo a palabra2
	
	public DiccLisJava()
	{
		nlenguas=-1;
		dicc = new LinkedList<Palabra2>();
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
				linea=lectura.readLine(); //leemos el documento linea a linea
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
		}catch (IOException ex){//si esto falla lanzaremos la excepci�n
			System.out.println(ex);
		}
		
		
	}

	private void leerLineaDicc(String texto, int linea) {
		
		if(linea==0){ //si es la primera l�nea, es donde est� el n�mero de lenguas
			nlenguas= Integer.parseInt(texto);
 			lenguas = new Vector<Character>();
 			lenguasaux= new char[nlenguas];
		}
		if(linea==1){//si es la segunda, es donde est�n las lenguas
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
			for(int j=0; j<s.length-1;j++){
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
			if (p.getOrigen().equals(dicc.get(i).getOrigen()))
			{
				rep=true;
				actual= i;
				break;
			}
		}
		
		if (rep == true){
			//si la palabra esta repetida, la combino
			if(dicc.get(actual).combinaPalabra(p)>0)
				ret=true;
			else
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
		
		//vamos a sacar primero el n�mero de palabras que hay en el diccionario.
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
			if (dicc.get(i).getOrigen().equals(s))
			{
				dicc.remove(i);
				return true;
			}
		}
		return false;
	}

	public int busca(String s) {
		//este metodo busca la cadena s en el diccionario y devuelve las comparaciones que tuvo que hacer (pero �ptimamente)
		//para este caso implementar� una b�squeda binaria, consistente en dividir el array en dos para averiguar en que zona est� del array
		int i=0;
		for(;i<dicc.size();i++){
			if (dicc.get(i).getOrigen().equals(s)){
				return i;
			}
		}
		return -i;

	}

	public int buscaMetodos(String s) {
		//este metodo hace lo mismo que busca, pero devuelve la posicion de la traduccion
		//en lugar de devolver el numero de iteraciones
		int i=0;
		for(;i<dicc.size();i++){
			if (dicc.get(i).getOrigen().equals(s)){
				return i;
			}
		}
		return -i;
	}
	
	public String traduce(String s, char l) {
		
		int pos= buscaMetodos(s);
		if (pos > 0)
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
