import java.util.ArrayList;

/**
 * Modela un Post de cualquier tipo
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public abstract class Post{
	
	/**
	* Correlativo del post
	*/
	protected int numPost;
	
	/**
	* Mensaje principal del post (URL, texto o emoticon)
	*/
	protected String Contenido;
	
	/**
	* Autor del post
	*/
	protected String Autor;
	
	/**
	* Fecha de publicación del post
	*/
	protected ArrayList<Integer> Fecha;
	
	/**
	* Hora de publicación del post
	*/
	protected ArrayList<Integer> Hora;
	
	/**
	* Likes del post
	*/
	protected int Likes;
	
	/**
	* Comentarios del post
	*/
	protected ArrayList<String> Comentarios;
	
	/**
	* Hashtags del post
	*/
	protected ArrayList<String> Hashtags;
	
	/**
	 * Aumena en uno el atributo "Likes"
	 * @version 01/11/2021
	 */
	public void setLikes(){
		Likes++;
	}
	
	/**
	 * Agrega un nuevo comentario al post
	 * @version 01/11/2021
	 * @param NuevoComentario Nuevo comentario del post
	 */
	public void AgregarComentario(String NuevoComentario){
		Comentarios.add(NuevoComentario);
	}
	
	/**
	 * Devuelve el contenido del atributo "Hashtags"
	 * @version 01/11/2021
	 * @return Devuelve el contenido del atributo "Hashtags"
	 */
	public ArrayList<String> getHashtags(){
		return Hashtags;
	}
	
	/**
	 * Devuelve el contenido del atributo "Fecha"
	 * @version 01/11/2021
	 * @return Devuelve el contenido del atributo "Fecha"
	 */
	public ArrayList<Integer> getFecha(){
		return Fecha;
	}
	
	/**
	 * Devuelve el contenido del atributo "numPost"
	 * @version 01/11/2021
	 * @return Devuelve el contenido del atributo "numPost"
	 */
	public int getnumPost(){
		return numPost;
	}
	
	/**
	 * Devuelve el contenido del atributo "Likes"
	 * @version 01/11/2021
	 * @return Devuelve el contenido del atributo "Likes"
	 */
	public int getLikes(){
		return Likes;
	}
	
	/**
	 * Define la estructura del post
	 * @version 01/11/2021
	 * @return Devuelve un String que es el post en sí
	 */
	public abstract String toString();
	
	/**
	 * Define cómo se reproduce el post
	 * @version 01/11/2021
	 * @return Devuelve un String que indica cómo se está reproduciendo el post
	 */
	public abstract String ReproducirPost();
	
	
}