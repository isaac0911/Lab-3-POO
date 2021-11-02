import java.util.ArrayList;

/**
 * Modela un Post de tipo Audio
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class PostMultimediaAudio extends PostMultimedia{
	
	/**
	* Sample rate del audio
	*/
	private float SampleRate;
	
	/**
	* Bit depth del audio
	*/
	private int BitDepth;
	
	/**
	 * Instancia un Post de tipo Audio
	 * @version 01/11/2021
	 * @param DatosNuevoPostAudio Arreglo que contiene todos los datos necesarios para instancia el post
	 */
	public PostMultimediaAudio(ArrayList<String> DatosNuevoPostAudio){
		
		numPost = Integer.parseInt(DatosNuevoPostAudio.get(0));
		Contenido = DatosNuevoPostAudio.get(1);
		Autor = DatosNuevoPostAudio.get(2);
		
		//*************************************************************
		//Fecha
		Fecha = new ArrayList<Integer>();
		
		int dia = Integer.parseInt(DatosNuevoPostAudio.get(3));
		int mes = Integer.parseInt(DatosNuevoPostAudio.get(4));
		int ano = Integer.parseInt(DatosNuevoPostAudio.get(5));
		
		Fecha.add(dia);
		Fecha.add(mes);
		Fecha.add(ano);
		
		//Hora
		Hora = new ArrayList<Integer>();
		
		int horaEntera = Integer.parseInt(DatosNuevoPostAudio.get(6));
		int minuto = Integer.parseInt(DatosNuevoPostAudio.get(7));
		
		Hora.add(horaEntera);
		Hora.add(minuto);
		
		//*************************************************************
		
		TamKilobytes = Float.parseFloat(DatosNuevoPostAudio.get(8));
		SampleRate = Float.parseFloat(DatosNuevoPostAudio.get(9));
		BitDepth = Integer.parseInt(DatosNuevoPostAudio.get(10));
		
		Likes = 0;
		Comentarios = new ArrayList<String>();
		Hashtags = new ArrayList<String>();
		
		for(int i=11; i<DatosNuevoPostAudio.size(); i++){
			Hashtags.add(DatosNuevoPostAudio.get(i));
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
			Cadena = Cadena + "\n\t(audio) " + Contenido;
		}else{
			Cadena = Cadena + "\t(audio) " + Contenido;
		}
		
		Cadena = Cadena + "\n\t" + TamKilobytes + " KB, SampleRate: " + SampleRate + " kHz, BitDepth: " + BitDepth;
		
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
		
		String mensaje = "Voy a sonar este audio: " + Contenido + ", con " + SampleRate + " kHz de sample rate y " + BitDepth + " de bit depth";
		return mensaje;
		
	}
	
}