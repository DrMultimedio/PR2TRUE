//DNI 48727303 PALAU ALEGRIA, JOSE MANUEL
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class NodoL {
	private String origen;
	private String bilingue;
	private NodoL next;
	private NodoL prev;

	public NodoL()
	{
		origen = null;
		bilingue = null;
		next = null;
		prev = null;

	}

	public void cambiaNext(NodoL n){ 

		next= n;

	}
	public void cambiaPrev(NodoL n){ 

		prev = n;

	}
	void setOrigen(String o){ //cambia la palabra origen
		origen = o;
	}
	void setBilingue(String b){ //cambia la palabra bilingue
		bilingue = b;
	}
	public Palabra2 getBilingue(){ //devuelve la palabra bilingue
		return bilingue;
	}
	public Palabra2 getOrigen(){ //devuelve la palabra origen
		return origen;
	}
	public NodoL getNext(){
		return next;
	}
}

public class ListaBilingue {

}
