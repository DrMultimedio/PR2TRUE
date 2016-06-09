/**
* @author Alicia Garrido Alenda
*
* Se crea un objeto de tipo DiccVector, se invoca su metodo leeDiccionario
* con un diccionario ordenado sin palabras repetidas pero alguna palabra
* no tiene traducciones para cada idioma. Se invoca su metodo visualiza
* sin parametros.
*/
public class p03 {
  public static void main(String[] args){
    Diccionario diccio=new DiccVector();
      diccio.leeDiccionario("p03.dic");
      diccio.visualiza();
    
    
  }
}
