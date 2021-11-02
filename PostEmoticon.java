import java.util.ArrayList;

/**
 * Modela un Post de tipo Emoticon
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class PostEmoticon extends Post{
	
	/**
	 * Instancia un Post de tipo Emoticon
	 * @version 01/11/2021
	 * @param DatosNuevoPostEmoticon Arreglo que contiene todos los datos necesarios para instancia el post
	 */
	public PostEmoticon(ArrayList<String> DatosNuevoPostEmoticon){
		
		numPost = Integer.parseInt(DatosNuevoPostEmoticon.get(0));
		Contenido = DatosNuevoPostEmoticon.get(1);
		Autor = DatosNuevoPostEmoticon.get(2);
		
		//*************************************************************
		//Fecha
		Fecha = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(DatosNuevoPostEmoticon.get(3));
		int mes = Integer.parseInt(DatosNuevoPostEmoticon.get(4));
		int ano = Integer.parseInt(DatosNuevoPostEmoticon.get(5));
		
		Fecha.add(dia);
		Fecha.add(mes);
		Fecha.add(ano);
		
		//Hora
		Hora = new ArrayList<Integer>();
		
		int horaEntera = Integer.parseInt(DatosNuevoPostEmoticon.get(6));
		int minuto = Integer.parseInt(DatosNuevoPostEmoticon.get(7));
		
		Hora.add(horaEntera);
		Hora.add(minuto);
		
		//*************************************************************
		
		Likes = 0;
		Comentarios = new ArrayList<String>();
		Hashtags = new ArrayList<String>();
		
		for(int i=8; i<DatosNuevoPostEmoticon.size(); i++){
			Hashtags.add(DatosNuevoPostEmoticon.get(i));
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
			Cadena = Cadena + "\n\t(emoticon) " + Contenido;
		}else{
			Cadena = Cadena + "\t(emoticon) " + Contenido;
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