import java.util.ArrayList;

/**
 * Modela un Post de tipo Texto
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class PostTexto extends Post{
	
	/**
	 * Instancia un Post de tipo Texto
	 * @version 01/11/2021
	 * @param DatosNuevoPostTexto Arreglo que contiene todos los datos necesarios para instancia el post
	 */
	public PostTexto(ArrayList<String> DatosNuevoPostTexto){
		
		numPost = Integer.parseInt(DatosNuevoPostTexto.get(0));
		Contenido = DatosNuevoPostTexto.get(1);
		Autor = DatosNuevoPostTexto.get(2);
		
		//*************************************************************
		//Fecha
		Fecha = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(DatosNuevoPostTexto.get(3));
		int mes = Integer.parseInt(DatosNuevoPostTexto.get(4));
		int ano = Integer.parseInt(DatosNuevoPostTexto.get(5));
		
		Fecha.add(dia);
		Fecha.add(mes);
		Fecha.add(ano);
		
		//Hora
		Hora = new ArrayList<Integer>();
		
		int horaEntera = Integer.parseInt(DatosNuevoPostTexto.get(6));
		int minuto = Integer.parseInt(DatosNuevoPostTexto.get(7));
		
		Hora.add(horaEntera);
		Hora.add(minuto);
		
		//*************************************************************
		
		Likes = 0;
		Comentarios = new ArrayList<String>();
		Hashtags = new ArrayList<String>();
		
		for(int i=8; i<DatosNuevoPostTexto.size(); i++){
			Hashtags.add(DatosNuevoPostTexto.get(i));
		}
		
	}
	
	/**
	 * Define la estructura del post
	 * @version 01/11/2021
	 * @return Devuelve un String que es el post en sí
	 */
	public String toString(){
		
		int dia = Fecha.get(0);
		int mes = Fecha.get(1);
		int ano = Fecha.get(2);
		
		int horaEntera = Hora.get(0);
		int minuto = Hora.get(1);
		
		String Cadena = "Post No. " + numPost + "\n\tAutor: " + Autor + " - Fecha:" + dia + "/" + mes + "/" + ano + " - Hora:" + horaEntera + "hrs:" + minuto + "min - Likes: " + Likes + "\n";
		
		if (Hashtags.size()>0){
			Cadena = Cadena + "\t";
		}
		
		for(int i=0; i<Hashtags.size();i++){
			Cadena = Cadena + "#" + Hashtags.get(i) + " ";
		}
		
		if (Hashtags.size()>0){
			Cadena = Cadena + "\n\t(texto) " + Contenido;
		}else{
			Cadena = Cadena + "\t(texto) " + Contenido;
		}
		
		if(Comentarios.size()>0){
			Cadena = Cadena + "\n\n\t--->comentarios:";
			for (int i = 0; i<Comentarios.size(); i++){
				Cadena = Cadena + "\n\t(" + (i+1) + ")  " + Comentarios.get(i);
			}
		}
		
		return Cadena;
	}
	
	/**
	 * Define cómo se reproduce el post
	 * @version 01/11/2021
	 * @return Devuelve un String que indica cómo se está reproduciendo el post
	 */
	public String ReproducirPost(){
		
		String mensaje = Contenido;
		return mensaje;
		
	}
	
} 