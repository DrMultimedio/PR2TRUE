//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class NodoB {
	private String origen;
	private String bilingue;
	private NodoB next;
	private NodoB prev;

	public NodoB()
	{
		origen = null;
		bilingue = null;
		next = null;
		prev = null;

	}
	public NodoB(String O, String B)
	{
		origen = O;
		bilingue = B;
		next = null;
		prev = null;

	}
	public void cambiaNext(NodoB n){ 

		next= n;

	}
	public void cambiaPrev(NodoB n){ 

		prev = n;

	}
	void setOrigen(String o){ //cambia la palabra origen
		origen = o;
	}
	void setBilingue(String b){ //cambia la palabra bilingue
		bilingue = b;
	}
	public String getBilingue(){ //devuelve la palabra bilingue
		return bilingue;
	}
	public String getOrigen(){ //devuelve la palabra origen
		return origen;
	}
	public NodoB getNext(){
		return next;
	}

	public NodoB getPrev(){
		return prev;
	}
}

public class ListaBilingue {
	private NodoB first;
	private NodoB last;

	public ListaBilingue(){
		first = null;
		last = null;
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

	private void leerLineaDicc(String linea, int i) {
		System.out.println("vamos a dejar este método aparcado por ahora");
	}

	public boolean inserta(String o, String d){
		//Aqui vamos a insertar las palabras
		boolean ret = false, repetida = false, primeroO = true, primeroB = true;
		NodoB nuevo, recorre, aux, sitioOrigen = null, sitioBilingue = null;

		//compruebo que ninguna de las dos palabras sea nula
		if (o != null && d != null){
			nuevo = new NodoB(o, d);
			//si es el primero, lo insertamos
			if(first==null && last == null){
				first = nuevo; 
				last = nuevo;
			}

			else{
				//primero la colocamos en orden de palabra bilingue, es decir desde first hasta last
				//RECORREMOS LA LISTA ORIGEN

				recorre = first;
				aux = first;
				boolean found = false;
				while(recorre != null && found == false){
					int pos = recorre.getOrigen().compareToIgnoreCase(o);
					if(pos>0){
						//el sitio donde debo colocarlo es en el next de aux, asi que lo guardo para evitar
						//repetidos
						sitioOrigen = aux;
						found = true;
						if(recorre == first)
							primeroO = true;
					}
					else if(pos<0){
						//si la palabra de recorre es menor que la que vamos a insertar, pasamos al siguiente
						aux = recorre;
						recorre = recorre.getNext();
					}
					else if(pos == 0){
						//si la palabra de recorre es igual, salimos del bucle. Ademas, ponemos ret a false
						found = true;
						repetida = true;
					}
				}
				if (found == false){
					//si no lo he encontrado, lo tendre que poner en el next de aux
					sitioOrigen = aux;
				}
				//RECORREMOS LA LISTA BILINGUE

				recorre = last;
				aux = last;
				found = false;
				while(recorre != null && found == false){
					int pos = recorre.getBilingue().compareToIgnoreCase(d);
					if(pos>0){
						//el sitio donde debo colocarlo es en el prev de aux, asi que lo guardo 
						//para evitar repetidos
						sitioBilingue = aux;
						found = true;
						if(recorre == last)
							primeroB = true;
					
					}
					else if(pos<0){
						//si la palabra de recorre es menor que la que vamos a insertar, pasamos al siguiente
						aux = recorre;
						recorre = recorre.getPrev();
					}
					else if(pos == 0){
						//si la palabra de recorre es igual, salimos del bucle. Ademas, ponemos ret a false
						found = true;
						repetida = true;

				}
				}
				if (found == false){
					//si no lo he encontrado, lo tendre que poner en el next de aux
					sitioBilingue = aux;
				}

				//Y AHORA INSERTAMOS LA PALABRA EN SI
				if(repetida == false && sitioOrigen!= null && sitioBilingue != null){
					//si no esta repetida 
					//PRIMERO EN ORIGEN
					//compruebo si es la primera
					
					if(primeroO == true){
						//si es el primero pongo first a nuevo, y le pongo a nuevo siguiente el anterior first
						nuevo.cambiaNext(first);
						first = nuevo;

					}
					//si no es el primero
					else{
						//el anterior a nuevo apuntara a nuevo, y nuevo apuntara al siguiente de sitioOrigen
						nuevo.cambiaNext(sitioOrigen.getNext());
						sitioOrigen.cambiaNext(nuevo);

					}
					//AHORA EN BILINGUE
					//si es el primero
					if(sitioBilingue.getBilingue().equalsIgnoreCase(last.getBilingue())){
						//si es el primero pongo first a nuevo, y le pongo a nuevo siguiente el anterior first
						nuevo.cambiaPrev(sitioBilingue);
						last = nuevo;

					}
					else{
						//el anterior a nuevo apuntara a nuevo, y nuevo apuntara al siguiente de sitioOrigen
						nuevo.cambiaPrev(sitioBilingue.getPrev());
						sitioBilingue.cambiaPrev(nuevo);
					}
					ret = true;
				}

			}
		}

		return ret;
	}
	public void visualizaO(){
		NodoB recorre = first;
		while (recorre!=null){ //mientras que haya algo en recorre
			System.out.println(recorre.getOrigen() + ":" + recorre.getBilingue());
			recorre = recorre.getNext();
		}	
	}
	public void visualizaD(){
		NodoB recorre = last;
		while (recorre!=null){ //mientras que haya algo en recorre
			System.out.println(recorre.getBilingue() + ":" + recorre.getOrigen());
			recorre = recorre.getPrev();
		}	
	}
}
