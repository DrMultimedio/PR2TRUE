
public class ConsultaAcepciones {
	public static void main(String[] args) {
		System.out.println("SALIDA");
		if(args.length>=2){
			ListaBilingue lista = new ListaBilingue();
			lista.leeDiccionario2(args[0]);
			if(args[1].equalsIgnoreCase("O")){
				if(!lista.consultaAcepcionesO())
					System.out.println("No existe");
			}
			if(args[1].equalsIgnoreCase("D")){
				if(!lista.consultaAcepcionesD())
					System.out.println("No existe");
			}
		}
	}
}
