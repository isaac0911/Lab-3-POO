import java.util.ArrayList;

/**
 * Modela un Post de tipo Imagen
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class PostMultimediaImagen extends PostMultimedia{
	
	/**
	* Formato de la imagen
	*/
	private String Formato;
	
	/**
	* Resolución de la imagen en megapixeles
	*/
	private float ResMegaPixeles;
	
	/**
	 * Instancia un Post de tipo Imagen
	 * @version 01/11/2021
	 * @param DatosNuevoPostImagen Arreglo que contiene todos los datos necesarios para instancia el post
	 */
	public PostMultimediaImagen(ArrayList<String> DatosNuevoPostImagen){
		
		numPost = Integer.parseInt(DatosNuevoPostImagen.get(0));
		Contenido = DatosNuevoPostImagen.get(1);
		Autor = DatosNuevoPostImagen.get(2);
		
		//*************************************************************
		//Fecha
		Fecha = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(DatosNuevoPostImagen.get(3));
		int mes = Integer.parseInt(DatosNuevoPostImagen.get(4));
		int ano = Integer.parseInt(DatosNuevoPostImagen.get(5));
		
		Fecha.add(dia);
		Fecha.add(mes);
		Fecha.add(ano);
		
		//Hora
		Hora = new ArrayList<Integer>();
		
		int horaEntera = Integer.parseInt(DatosNuevoPostImagen.get(6));
		int minuto = Integer.parseInt(DatosNuevoPostImagen.get(7));
		
		Hora.add(horaEntera);
		Hora.add(minuto);
		
		//*************************************************************
		
		TamKilobytes = Float.parseFloat(DatosNuevoPostImagen.get(8));
		Formato = DatosNuevoPostImagen.get(9);
		ResMegaPixeles = Float.parseFloat(DatosNuevoPostImagen.get(10));
		
		Likes = 0;
		Comentarios = new ArrayList<String>();
		Hashtags = new ArrayList<String>();
		
		for(int i=11; i<DatosNuevoPostImagen.size(); i++){
			Hashtags.add(DatosNuevoPostImagen.get(i));
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
			Cadena = Cadena + "\n\t(imagen) " + Contenido;
		}else{
			Cadena = Cadena + "\t(imagen) " + Contenido;
		}
		
		Cadena = Cadena + "\n\t" + TamKilobytes + " KB, " + Formato + ", " + ResMegaPixeles + " Megapixeles";
		
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
		
		String mensaje = "Estoy mostrando esta imagen: " + Contenido + ", con " + ResMegaPixeles + " megapixeles de resolucion";
		return mensaje;
		
	}
	
}