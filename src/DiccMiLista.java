//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class NodoL {
	private Palabra2 pal;
	private NodoL next;

	public NodoL()
	{
		pal = null;
		next = null;

	}
	public NodoL(Palabra2 p){
		pal = p;
		next = null;
	}

	public void cambiaNext(NodoL n){ 

		next= n;

	}

	void setPalabra2(Palabra2 p){ //cambia la palabra del nodo
		pal = p;
	}
	public Palabra2 getPalabra2(){ //devuelve la palabra del nodo
		return pal;
	}
	public NodoL getNext(){
		return next;
	}
}

public class DiccMiLista implements Diccionario{
	private int nlenguas;
	private Vector<Character> lenguas; //E spanish, P portugues, F frances
	private NodoL first; //este es el primer nodo
	private char[] lenguasaux;
	public DiccMiLista(){
		nlenguas= - 1;
		lenguas = new Vector<Character>();
		first = null;
	}

	@Override
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
	public void leerLineaDicc(String texto, int linea) {

		if(linea==0){ //si es la primera linea, es donde este el numero de lenguas
			nlenguas= Integer.parseInt(texto);
			lenguas = new Vector<Character>();
			lenguasaux = new char[nlenguas];
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
		NodoL nuevo = new NodoL(), naux = null , recorre = null; //defino un nuevo nodo, nodol
		boolean rep=false, ret= false, found=false; //defino dos boolean, uno por si encuentro que p esta repetida
		//y otro que es la variable que devolvere
		nuevo.setPalabra2(p); //hago un nuevo nodo con la palabra nueva

		if (first == null)
		{
			//si es la primera vez, first sera null, y por tanto, pondre recorre a first
			//y first sera el nuevo
			first=nuevo;
			ret = true;
		}
		else{
			recorre = first; // ponemos recorre a first
			while (recorre!=null&&rep==false){ //mientras que haya algo en recorre, y rep no sea true
				if(recorre.getPalabra2().getOrigen().equalsIgnoreCase(nuevo.getPalabra2().getOrigen())){
					rep=true;
				}
				if(rep != true){
				recorre=recorre.getNext();
				}
			}
				
			if(rep==false){
				//si  rep es falso volvemos a recorrer la lista, para ordenarla
				recorre = first; // ponemos recorre a first
					
				if(p.getOrigen().equalsIgnoreCase("Butterfly Kiss Blade74"))
					System.out.println("here we go ma boi");
				
				while (recorre!=null&&found==false){  //mientras que haya algo en recorre, y rep no sea true
					
					if(recorre.getPalabra2().getOrigen().compareToIgnoreCase(nuevo.getPalabra2().getOrigen())>0){
						//si la palabra de recorre es menor que la de nuevo, meto antes de reccorre el nuevo

						if (recorre.getPalabra2().getOrigen().equalsIgnoreCase(first.getPalabra2().getOrigen())){
							//si recorre es el primero
							nuevo.cambiaNext(first); //recorre apunta a first
							first=nuevo; //y first pasa a ser el nuevo
							ret = true;
							System.out.println("insertado " + p.getOrigen());

						}

						else{//si no es el primero
							nuevo.cambiaNext(recorre.getNext());
							naux.cambiaNext(nuevo);
							recorre = nuevo;
						}
						found=true;
						ret = true;
					}
					naux= recorre;
					recorre= recorre.getNext();
				}
				if (found == false){
					naux.cambiaNext(nuevo);
				}


			}
			else{
				Palabra2 aux = recorre.getPalabra2();
				int check = aux.combinaPalabra(p);
				if (check>0);
			}
		}
		return ret;
	}

	public boolean borra(String s) {
		boolean found=false;
		NodoL naux = null;
		NodoL recorre = first;
		while (recorre!=null&&found==false){ //mientras que haya algo en recorre, y found no sea true
			if(recorre.getPalabra2().getOrigen().equalsIgnoreCase(s)){
				if (recorre == first){
					first = first.getNext();
					found = true;
				}
				else{
					found=true;
					naux.cambiaNext(recorre.getNext());
				}
			}
			naux = recorre; //igualo naux a recorre, para cuando encuentre la palabra a borrar
			recorre = recorre.getNext();
		}
		return found;
	}

	@Override
	public int busca(String s) {

		int i = 0; 
		NodoL recorre = first;
		while (recorre!=null){ //mientras que haya algo en recorre, y found no sea true
			if(recorre.getPalabra2().getOrigen().equalsIgnoreCase(s)){
				return i;
			}
			recorre = recorre.getNext();
			i++;
		}


		return -i;
	}

	@Override
	public String traduce(String s, char l) {
		NodoL recorre = first;
		while (recorre!=null){ //mientras que haya algo en recorre
			if(recorre.getPalabra2().getOrigen().equalsIgnoreCase(s)){
				return recorre.getPalabra2().getTraduccion(l); //si encuentro la palabra la traduzco
			}
			recorre = recorre.getNext();
		}


		return null;
	}

	@Override
	public void visualiza() {
		NodoL recorre = first;
		while (recorre!=null){ //mientras que haya algo en recorre, y found no sea true
			recorre.getPalabra2().escribeInfo();	
			recorre = recorre.getNext();
		}
	}

	@Override
	public void visualiza(int j) {
		int i = 0;
		NodoL recorre = first;
		while (recorre!=null&&i<j){ //mientras que haya algo en recorre, y found no sea true
			recorre.getPalabra2().escribeInfo();	
			recorre = recorre.getNext();
			i++;
		}

	}

	@Override
	public void visualiza(int j, char l) {
		int i = 0;
		NodoL recorre = first;
		while (recorre!=null&&i<j){ //mientras que haya algo en recorre, y found no sea true
			recorre.getPalabra2().escribeInfoTrad(l);;	
			recorre = recorre.getNext();
			i++;
		}		
	}
}	
