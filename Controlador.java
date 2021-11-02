import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Comunica a la Vista con el Modelo y viceversa.
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class Controlador{
	
	/**
	* Arreglo que contiene a todos los posts que se han publicado
	*/
	private ArrayList<Post> Posts;
	
	/**
	* Arreglo que contiene todos los hashtags que se han utilizado en la red social
	*/
	private ArrayList<String> ListaHashtags;
	
	/**
	 * Instancia un objeto de tipo Controlador.
	 * @version 01/11/2021
	 */
	public Controlador(){
		Posts = new ArrayList<Post>();
		ListaHashtags = new ArrayList<String>();
	}
	
	/**
	 * Es el método principal. Manda a mostrar el mensaje de bienvenida y ejecuta el método "Ciclo" de esta misma clase
	 * @version 01/11/2021
	 */
	public void MetodoPrincipal(){
		
		Vista.MensajeBienvenida();
		
		Ciclo();
	}
	
	/**
	 * Contiene el ciclo en el que se mantendrá el flujo del programa mientras el usuario no quiera salir
	 * @version 01/11/2021
	 */
	public void Ciclo(){
		
		int opcion = -1;
		
		while(opcion != 4){
			
			opcion = Vista.MostrarMenuPrincipal();
			
			if(opcion==1){
				
				String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE PUBLICAR UN POST\n";
				Vista.MostrarMensaje(mensaje);
				
				int tipoPost = Vista.PedirTipoPost();
				
				if(tipoPost==1){
					//PUBLICAR UN POST DE TEXTO
					
					//Pedir datos del nuevo post de texto al usuario
					ArrayList<String> DatosNuevoPostTextoSinNumero = Vista.PedirDatosPostTexto();
					
					//Agregarle el número de post
					int NumPost = 1+Posts.size();
					ArrayList<String> DatosNuevoPostTexto = new ArrayList<String>();
					DatosNuevoPostTexto.add(String.valueOf(NumPost));
					for (int i=0; i<DatosNuevoPostTextoSinNumero.size(); i++){
						DatosNuevoPostTexto.add(DatosNuevoPostTextoSinNumero.get(i));
					}
					
					//Mandar a crear el post
					PostTexto NuevoPost = new PostTexto(DatosNuevoPostTexto);
					
					Posts.add(NuevoPost);
					
					//AgregarNuevosHashtags
					ArrayList<String> NuevosHashtags = NuevoPost.getHashtags();
					AgregarHashtags(NuevosHashtags);
					
				}else if(tipoPost==2){
					
					int tipoPostMultimedia = Vista.PedirTipoPostMultimedia();
					
					if(tipoPostMultimedia==1){
						
						//PUBLICAR UN POST DE IMAGEN
						
						//Pedir datos del nuevo post de tipo imagen al usuario
						ArrayList<String> DatosNuevoPostImagenSinNumero = Vista.PedirDatosPostImagen();
						
						//Agregarle el número de post
						int NumPost = 1+Posts.size();
						ArrayList<String> DatosNuevoPostImagen = new ArrayList<String>();
						DatosNuevoPostImagen.add(String.valueOf(NumPost));
						for (int i=0; i<DatosNuevoPostImagenSinNumero.size(); i++){
							DatosNuevoPostImagen.add(DatosNuevoPostImagenSinNumero.get(i));
						}
					
						//Mandar a crear el post
						PostMultimediaImagen NuevoPost = new PostMultimediaImagen(DatosNuevoPostImagen);
						
						Posts.add(NuevoPost);
						
						//AgregarNuevosHashtags
						ArrayList<String> NuevosHashtags = NuevoPost.getHashtags();
						AgregarHashtags(NuevosHashtags);
						
					}else if(tipoPostMultimedia==2){
						
						//PUBLICAR UN POST DE AUDIO
						
						//Pedir datos del nuevo post de tipo audio al usuario
						ArrayList<String> DatosNuevoPostAudioSinNumero = Vista.PedirDatosPostAudio();
						
						//Agregarle el número de post
						int NumPost = 1+Posts.size();
						ArrayList<String> DatosNuevoPostAudio = new ArrayList<String>();
						DatosNuevoPostAudio.add(String.valueOf(NumPost));
						for (int i=0; i<DatosNuevoPostAudioSinNumero.size(); i++){
							DatosNuevoPostAudio.add(DatosNuevoPostAudioSinNumero.get(i));
						}
					
						//Mandar a crear el post
						PostMultimediaAudio NuevoPost = new PostMultimediaAudio(DatosNuevoPostAudio);
						
						Posts.add(NuevoPost);
						
						//AgregarNuevosHashtags
						ArrayList<String> NuevosHashtags = NuevoPost.getHashtags();
						AgregarHashtags(NuevosHashtags);
						
					}else if(tipoPostMultimedia==3){
						
						//PUBLICAR UN POST DE VIDEO
						
						//Pedir datos del nuevo post de tipo video al usuario
						ArrayList<String> DatosNuevoPostVideoSinNumero = Vista.PedirDatosPostVideo();
						
						//Agregarle el número de post
						int NumPost = 1+Posts.size();
						ArrayList<String> DatosNuevoPostVideo = new ArrayList<String>();
						DatosNuevoPostVideo.add(String.valueOf(NumPost));
						for (int i=0; i<DatosNuevoPostVideoSinNumero.size(); i++){
							DatosNuevoPostVideo.add(DatosNuevoPostVideoSinNumero.get(i));
						}
					
						//Mandar a crear el post
						PostMultimediaVideo NuevoPost = new PostMultimediaVideo(DatosNuevoPostVideo);
						
						Posts.add(NuevoPost);
						
						//AgregarNuevosHashtags
						ArrayList<String> NuevosHashtags = NuevoPost.getHashtags();
						AgregarHashtags(NuevosHashtags);
						
					}
				}else if(tipoPost==3){
					
					//PUBLICAR UN POST DE EMOTICON
						
					//Pedir datos del nuevo post de tipo emoticon al usuario
					ArrayList<String> DatosNuevoPostEmoticonSinNumero = Vista.PedirDatosPostEmoticon();
						
					//Agregarle el número de post
					int NumPost = 1+Posts.size();
					ArrayList<String> DatosNuevoPostEmoticon = new ArrayList<String>();
					DatosNuevoPostEmoticon.add(String.valueOf(NumPost));
					for (int i=0; i<DatosNuevoPostEmoticonSinNumero.size(); i++){
						DatosNuevoPostEmoticon.add(DatosNuevoPostEmoticonSinNumero.get(i));
					}
				
					//Mandar a crear el post
					PostEmoticon NuevoPost = new PostEmoticon(DatosNuevoPostEmoticon);
					
					Posts.add(NuevoPost);
					
					//AgregarNuevosHashtags
					ArrayList<String> NuevosHashtags = NuevoPost.getHashtags();
					AgregarHashtags(NuevosHashtags);
				}
				
				mensaje = "\n**************************************************************************\n\nEl post ha sido publicado exitosamente";
				Vista.MostrarMensaje(mensaje);
				
			}else if(opcion==2){
				//Si desea filtrar por fecha
				
				String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE FILTRAR POSTS POR FECHA\n";
				Vista.MostrarMensaje(mensaje);
				
				if(Posts.size()==0){
					//Si no se ha publicado ningun post
					mensaje = "\nNo se puede realizar esta accion ya que aun no se ha publicado ningun post.\n";
					Vista.MostrarMensaje(mensaje);
				}else if(Posts.size()>0){
					//Si se ha publicado, por lo menos, un post
					InstruccionesFiltrarPorFecha();
				}
				
			}else if(opcion==3){
				//Si desea filtrar por hashtag
				
				String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE FILTRAR POSTS POR HASHTAG\n";
				Vista.MostrarMensaje(mensaje);
				
				if(Posts.size()==0){
					//Si no se ha publicado ningun post
					mensaje = "\nNo se puede realizar esta accion ya que aun no se ha publicado ningun post.\n";
					Vista.MostrarMensaje(mensaje);
				}else if(Posts.size()>0){
					//Si se ha publicado, por lo menos, un post
					InstruccionesFiltrarPorHashtag();
				}
				
			}else if(opcion==4){
				Vista.MensajeDespedida();
			}
			
		}
		
	}
	
	/**
	 * Se ejecuta luego de publicar un nuevo post, y agrega al registro del sistema los nuevos hashtags utilizados
	 * @version 01/11/2021
	 * @param HashtagsNuevoPost Arreglo que contiene los hashtags del post que se acaba de crear
	 */
	private void AgregarHashtags(ArrayList<String> HashtagsNuevoPost){
		
		for(int i=0; i<HashtagsNuevoPost.size(); i++){
			String Hashtag = HashtagsNuevoPost.get(i);
			Hashtag = Hashtag.toLowerCase();
			
			boolean ElHashtagYaExistia=false;
			
			for(int m=0; m<ListaHashtags.size(); m++){
				if(Hashtag.equals(ListaHashtags.get(m))){
					ElHashtagYaExistia=true;
				}
			}
			
			if(!ElHashtagYaExistia){
				ListaHashtags.add(Hashtag);
			}
			
		}
		
	}
	
	/**
	 * Contiene las instrucciones necesarias para filtrar posts en funcion de una fecha específica
	 * @version 01/11/2021
	 */
	private void InstruccionesFiltrarPorFecha(){
		
		//Mandar a preguntar cuál es la fecha a filtrar
		ArrayList<Integer> FechaAFiltrar = Vista.PedirFechaAFiltrar();
		
		//Mandar a filtrar en función de la fecha ingresada
		ArrayList<Post> PostsFiltradosPorFecha = FiltrarPorFecha(FechaAFiltrar);
		
		if(PostsFiltradosPorFecha.size()==0){
			//Si no se encontró ninguna coincidencia
			String mensaje = "\nNo se ha encontrado ningun post con la fecha ingresada.\n";
			Vista.MostrarMensaje(mensaje);
		}else if(PostsFiltradosPorFecha.size()>0){
			
			//Mandar a mostrar los posts filtrados por fecha
			Vista.MostrarPostsFiltradosPorFecha(FechaAFiltrar, PostsFiltradosPorFecha);
			
			//Preguntar qué desea hacer para alguno de los posts filtrados
			int opcion = Vista.MostrarMenuLuegoDeFiltrar();
			
			if(opcion==1){
				//Si desea reporducir post
				
				//Se pide el post a reproducir
				int PosicionPost = Vista.PedirPostAReproducir(PostsFiltradosPorFecha);
				Post PostAReproducir = PostsFiltradosPorFecha.get(PosicionPost);
				
				String mensaje = "\n**************************************************************************\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = PostAReproducir.ReproducirPost();
				Vista.MostrarMensaje(mensaje);
				
			}else if(opcion==2){
				//Si desea dar like a post
				
				//Se pide el post a dar like
				int PosicionPost = Vista.PedirPostADarLike(PostsFiltradosPorFecha);
				Post PostADarLike = PostsFiltradosPorFecha.get(PosicionPost);
				
				//Dar like a post
				PostADarLike.setLikes();
				
				String mensaje = "\n**************************************************************************\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = "Se le dio like al Post No. " + PostADarLike.getnumPost() + ", y ahora tiene " + PostADarLike.getLikes() + " likes";
				Vista.MostrarMensaje(mensaje);
				
			}else if(opcion==3){
				//Si desea comentar post
				
				//Se pide el post a comentar
				int PosicionPost = Vista.PedirPostAComentar(PostsFiltradosPorFecha);
				Post PostAComentar = PostsFiltradosPorFecha.get(PosicionPost);
				
				//Se pide que ingrese el comentario
				String NuevoComentario = Vista.PedirCometario();
				
				//Se agrega el comentario
				PostAComentar.AgregarComentario(NuevoComentario);
				
				String mensaje = "\n**************************************************************************\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = "Se ha agregado el comentario al Post No. " + PostAComentar.getnumPost() + " satisfactoriamente";
				Vista.MostrarMensaje(mensaje);
				
			}
			
		}
		
	}
	
	/**
	 * Filtra los posts de acuerdo con la fecha que recibe como parámetro
	 * @version 01/11/2021
	 * @param FechaAFiltrar Arreglo que contiene la fecha que se desea filtrar, donde el primer elemento es el día, el segundo el mes, y el tercero el año.
	 * @return Devuelve el arreglo de posts que cumplen con la fecha que se desea filtrar
	 */
	private ArrayList<Post> FiltrarPorFecha(ArrayList<Integer> FechaAFiltrar){
		
		ArrayList<Post> PostsFiltradosPorFecha = new ArrayList<Post>();
		
		for(int i=0; i<Posts.size(); i++){
			
			boolean cumple = true;
			
			Post PostEnCuestion = Posts.get(i);
			ArrayList<Integer> FechaDelPostEnCuestion = PostEnCuestion.getFecha();
			
			//Dia mes y año que se buscan
			
			int diaBuscado = FechaAFiltrar.get(0);
			int mesBuscado = FechaAFiltrar.get(1);
			int anoBuscado = FechaAFiltrar.get(2);
			
			//Dia mes y año del post en cuestion
			int diaEnCuestion = FechaDelPostEnCuestion.get(0);
			int mesEnCuestion = FechaDelPostEnCuestion.get(1);
			int anoEnCuestion = FechaDelPostEnCuestion.get(2);
			
			//Se revisa que la fecha de publicacion del post en cuestion sea igual a aquella que se esta buscando
			if (diaBuscado!=diaEnCuestion){
				cumple = false;
			}
			if (mesBuscado!=mesEnCuestion){
				cumple = false;
			}
			if (anoBuscado!=anoEnCuestion){
				cumple = false;
			}
			if(cumple){
				PostsFiltradosPorFecha.add(PostEnCuestion);
			}
			
		}
		
		return PostsFiltradosPorFecha;
	}
	
	/**
	 * Contiene las instrucciones necesarias para filtrar posts en funcion del hashtag ingresado
	 * @version 01/11/2021
	 */
	private void InstruccionesFiltrarPorHashtag(){
		
		//Mandar a preguntar cuál es el hashtag a filtrar
		String HashtagAFiltrar = Vista.PedirHashtagAFiltrar(ListaHashtags);
		
		//Mandar a filtrar en función del hashtag ingresado
		ArrayList<Post> PostsFiltradosPorHashtag = FiltrarPorHashtag(HashtagAFiltrar);
		
		if(PostsFiltradosPorHashtag.size()==0){
			//Si no se encontró ninguna coincidencia
			String mensaje = "\nNo se ha encontrado ningun post con el hashtag ingresado.\n";
			Vista.MostrarMensaje(mensaje);
		}else if(PostsFiltradosPorHashtag.size()>0){
			
			//Mandar a mostrar los posts filtrados por hashtag
			Vista.MostrarPostsFiltradosPorHashtag(HashtagAFiltrar, PostsFiltradosPorHashtag);
			
			//Preguntar qué desea hacer para alguno de los posts filtrados
			int opcion = Vista.MostrarMenuLuegoDeFiltrar();
			
			if(opcion==1){
				//Si desea reproducir post
				
				//Se pide el post a reproducir
				int PosicionPost = Vista.PedirPostAReproducir(PostsFiltradosPorHashtag);
				Post PostAReproducir = PostsFiltradosPorHashtag.get(PosicionPost);
				
				String mensaje = "\n**************************************************************************\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = PostAReproducir.ReproducirPost();
				Vista.MostrarMensaje(mensaje);
				
			}else if(opcion==2){
				//Si desea dar like a post
				
				//Se pide el post a dar like
				int PosicionPost = Vista.PedirPostADarLike(PostsFiltradosPorHashtag);
				Post PostADarLike = PostsFiltradosPorHashtag.get(PosicionPost);
				
				//Dar like a post
				PostADarLike.setLikes();
				
				String mensaje = "\n**************************************************************************\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = "Se le dio like al Post No. " + PostADarLike.getnumPost() + ", y ahora tiene " + PostADarLike.getLikes() + " likes";
				Vista.MostrarMensaje(mensaje);
				
			}else if(opcion==3){
				//Si desea comentar post
				
				//Se pide el post a comentar
				int PosicionPost = Vista.PedirPostAComentar(PostsFiltradosPorHashtag);
				Post PostAComentar = PostsFiltradosPorHashtag.get(PosicionPost);
				
				//Se pide que ingrese el comentario
				String NuevoComentario = Vista.PedirCometario();
				
				//Se agrega el comentario
				PostAComentar.AgregarComentario(NuevoComentario);
				
				String mensaje = "\n**************************************************************************\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = "Se ha agregado el comentario al Post No. " + PostAComentar.getnumPost() + " satisfactoriamente";
				Vista.MostrarMensaje(mensaje);
				
			}
			
		}
		
	}
	
	/**
	 * Filtra los posts de acuerdo con el hashtag que recibe como parámetro
	 * @version 01/11/2021
	 * @param HashtagAFiltrar Hashtag que se desea filtrar
	 * @return Devuelve el arreglo de posts que cumplen con el hashtag que se desea filtrar
	 */
	private ArrayList<Post> FiltrarPorHashtag(String HashtagAFiltrar){
		
		ArrayList<Post> PostsFiltradosPorHashtag = new ArrayList<Post>();
		
		for(int i=0; i<Posts.size(); i++){
			
			boolean cumple = false;
			
			Post PostEnCuestion = Posts.get(i);
			ArrayList<String> HashtagsDelPostEnCuestion = PostEnCuestion.getHashtags();
			
			//Se revisa que el post en cuestión tenga el hashtag que se esta filtrando
			
			for(int m=0; m<HashtagsDelPostEnCuestion.size(); m++){
				String hashtagAComparar = HashtagsDelPostEnCuestion.get(m);
				hashtagAComparar = hashtagAComparar.toLowerCase();
				if(HashtagAFiltrar.equals(hashtagAComparar)){
					cumple = true;
				}
			}
			
			if(cumple){
				PostsFiltradosPorHashtag.add(PostEnCuestion);
			}
			
		}
		
		return PostsFiltradosPorHashtag;
		
	}
}