import java.util.ArrayList;

/**
 * Modela un Post de tipo Video
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class PostMultimediaVideo extends PostMultimedia{
	
	/**
	* Cuadros por segundo del video
	*/
	private int FrameRate;
	
	/**
	 * Instancia un Post de tipo Video
	 * @version 01/11/2021
	 * @param DatosNuevoPostVideo Arreglo que contiene todos los datos necesarios para instancia el post
	 */
	public PostMultimediaVideo(ArrayList<String> DatosNuevoPostVideo){
		
		numPost = Integer.parseInt(DatosNuevoPostVideo.get(0));
		Contenido = DatosNuevoPostVideo.get(1);
		Autor = DatosNuevoPostVideo.get(2);
		
		//*************************************************************
		//Fecha
		Fecha = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(DatosNuevoPostVideo.get(3));
		int mes = Integer.parseInt(DatosNuevoPostVideo.get(4));
		int ano = Integer.parseInt(DatosNuevoPostVideo.get(5));
		
		Fecha.add(dia);
		Fecha.add(mes);
		Fecha.add(ano);
		
		//Hora
		Hora = new ArrayList<Integer>();
		
		int horaEntera = Integer.parseInt(DatosNuevoPostVideo.get(6));
		int minuto = Integer.parseInt(DatosNuevoPostVideo.get(7));
		
		Hora.add(horaEntera);
		Hora.add(minuto);
		
		//*************************************************************
		
		TamKilobytes = Float.parseFloat(DatosNuevoPostVideo.get(8));
		FrameRate = Integer.parseInt(DatosNuevoPostVideo.get(9));
		
		Likes = 0;
		Comentarios = new ArrayList<String>();
		Hashtags = new ArrayList<String>();
		
		for(int i=10; i<DatosNuevoPostVideo.size(); i++){
			Hashtags.add(DatosNuevoPostVideo.get(i));
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
			Cadena = Cadena + "\n\t(video) " + Contenido;
		}else{
			Cadena = Cadena + "\t(video) " + Contenido;
		}
		
		Cadena = Cadena + "\n\t" + TamKilobytes + " KB, FrameRate: " + FrameRate + " fps";
		
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
		
		String mensaje = "Voy a mostrar este video: " + Contenido + ", con " + FrameRate + " fps";
		return mensaje;
		
	}
	
}