/**
* @author Alicia Garrido Alenda
*
* Se crea un objeto de tipo DiccMiLista, se invoca su metodo leeDiccionario
* con un diccionario desordenado sin palabras repetidas, con una traduccion 
* para cada idioma. Se invoca su metodo visualiza sin parametros.
*/
public class p05 {
  public static void main(String[] args){
    Diccionario diccio=new DiccMiLista();
    if(args.length>=1){
      diccio.leeDiccionario(args[0]);
      diccio.visualiza();
    }
    else
     System.out.println("Forma uso: java p05 p05.dic");
    
  }
}
