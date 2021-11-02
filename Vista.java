import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Muestra mensajes en pantalla y recibe mensajes del usuario a través del teclado
 * 
 * @author Isaac Solórzano Q.
 * @version 01/11/2021
 */

public class Vista{
	
	/**
	 * Muestra el mensaje de Bienvenida.
	 * @version 01/11/2021
	 */
	public static void MensajeBienvenida(){
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nBIENVENIDO A LA RED SOCIAL 'QueOndaMano'");
	}
	
	/**
	 * Muestra el mensaje de Despedida.
	 * @version 01/11/2021
	 */
	public static void MensajeDespedida(){
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nQue tenga un feliz dia.\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * Muestra el String que recibe como parámetro.
	 * @version 01/11/2021
	 * @param mensaje Conjunto de caracteres que se deseea mostrar en pantalla.
	 */
	public static void MostrarMensaje (String mensaje){
		System.out.println(mensaje);
	}
	
	/**
	 * Muestra el menu de opciones principales y pide la opcion a ejecutar
	 * @version 01/11/2021
	 * @return Devuelve un entero que indica la opción ingresada por el usuario
	 */
	public static int MostrarMenuPrincipal(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nQue desea hacer?");
		System.out.println("1.\tPublicar post");
		System.out.println("2.\tVer los posts publicados en una fecha particular");
		System.out.println("3.\tVer los posts que tienen un hashtag en comun");
		System.out.println("4.\tSalir");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
	}
	
	/**
	 * Muestra lo tipos de post que se pueden crear y se pide que ingrese el tipo de post que desea publicar
	 * @version 01/11/2021
	 * @return Devuelve un entero que indica la opción ingresada por el usuario
	 */
	public static int PedirTipoPost(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nQue tipo de post desea publicar?");
		System.out.println("1.\tTexto");
		System.out.println("2.\tMultimedia");
		System.out.println("3.\tEmoticon");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Pide al usuario que ingrese el tipo de archivo multimedia que desea publicar
	 * @version 01/11/2021
	 * @return Devuelve un entero que indica la opción ingresada por el usuario
	 */
	public static int PedirTipoPostMultimedia(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nQue tipo de archivo multimedia desea publicar?");
		System.out.println("1.\tImagen");
		System.out.println("2.\tAudio");
		System.out.println("3.\tVideo");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Pide todos los datos necesarios para publicar un post de tipo texto
	 * @version 01/11/2021
	 * @return Devuelve un arreglo con todos los datos ingresados
	 */
	public static ArrayList<String> PedirDatosPostTexto(){
		
		//Pedir el autor------------------------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el nombre del autor: ");
		String autor = scan.nextLine();
		
		//Pedir fecha---------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nFECHA DE PUBLICACION\n");
		System.out.println("Ingrese el dia: ");
		String dia = scan.nextLine();
		System.out.println("Ingrese el mes: ");
		String mes = scan.nextLine();
		System.out.println("Ingrese el ano: ");
		String ano = scan.nextLine();
		
		boolean validacion;
		
		ArrayList<String> FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
		
		validacion = comprobarFecha(FechaSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una fecha correcta.");
			System.out.println("\nIngrese el dia: ");
			dia = scan.next();
			System.out.println("Ingrese el mes: ");
			mes = scan.next();
			System.out.println("Ingrese el ano: ");
			ano = scan.next();
			FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
			validacion = comprobarFecha(FechaSinValidar);
		}
		
		// Pedir hora-----------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHORA DE PUBLICACION (FORMATO DE 24 HORAS)\n");
		System.out.println("Ingrese la hora: ");
		String horaEntera = scan.next();
		System.out.println("Ingrese el minuto: ");
		String Minuto = scan.next();
		
		validacion = false;
		
		ArrayList<String> HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
		
		validacion = comprobarHora(HoraSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una hora correcta.");
			System.out.println("Ingrese la hora: ");
			horaEntera = scan.next();
			System.out.println("Ingrese el minuto: ");
			Minuto = scan.next();
			HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
			validacion = comprobarHora(HoraSinValidar);
		}
		
		//Ingresar el contenido del post------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		scan = new Scanner(System.in);
		System.out.println("\nIngrese el texto de la publicacion: ");
		String Contenido = scan.nextLine();
		
		
		//INGRESAR HASHTAGS-------------------------------------------------------------------------
		
		ArrayList<String> Hashtags = new ArrayList<String>();
		
		int numero = 0;
		String opcion = "";
		validacion = false;
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHASHTAGS");
		System.out.println("\nDesea ingresar algun hashtag para el post?\n1.\tSi\n2.\tNo");
		
		opcion = scan.nextLine();
		
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		while (numero!=2){
			//Pedir y guardar hashtag
			System.out.println("\nIngrese el hashtag (sin el simbolo '#')");
			String hashtag = scan.nextLine();
			Hashtags.add(hashtag);
			
			//Preguntar si desea ingresar otro hashtag
			
			numero = 0;
			opcion = "";
			validacion = false;
		
			System.out.println("\nDesea ingresar algun otro hashtag?\n1.\tSi\n2.\tNo");
		
			opcion = scan.nextLine();
		
			validacion = comprobarNumero(opcion);
		
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
			
			while (validacion = false || numero<1 || numero>4){
				System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
				opcion = scan.nextLine();
				validacion = comprobarNumero(opcion);
				if (validacion){
					numero = Integer.parseInt(opcion);
				}
			}
		}
		
		ArrayList<String> DatosNuevoPostTexto = new ArrayList<>(Arrays.asList(Contenido,autor,dia,mes,ano,horaEntera,Minuto));
		
		for (int i=0; i<Hashtags.size(); i++){
			DatosNuevoPostTexto.add(Hashtags.get(i));
		}
		
		return DatosNuevoPostTexto;
	}
	
	/**
	 * Pide todos los datos necesarios para publicar un post de tipo imagen
	 * @version 01/11/2021
	 * @return Devuelve un arreglo con todos los datos ingresados
	 */
	public static ArrayList<String> PedirDatosPostImagen(){
		
		//Pedir el autor------------------------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el nombre del autor: ");
		String autor = scan.nextLine();
		
		//Pedir fecha---------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nFECHA DE PUBLICACION\n");
		System.out.println("Ingrese el dia: ");
		String dia = scan.nextLine();
		System.out.println("Ingrese el mes: ");
		String mes = scan.nextLine();
		System.out.println("Ingrese el ano: ");
		String ano = scan.nextLine();
		
		boolean validacion;
		
		ArrayList<String> FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
		
		validacion = comprobarFecha(FechaSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una fecha correcta.");
			System.out.println("\nIngrese el dia: ");
			dia = scan.next();
			System.out.println("Ingrese el mes: ");
			mes = scan.next();
			System.out.println("Ingrese el ano: ");
			ano = scan.next();
			FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
			validacion = comprobarFecha(FechaSinValidar);
		}
		
		// Pedir hora-----------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHORA DE PUBLICACION (FORMATO DE 24 HORAS)\n");
		System.out.println("Ingrese la hora: ");
		String horaEntera = scan.next();
		System.out.println("Ingrese el minuto: ");
		String Minuto = scan.next();
		
		validacion = false;
		
		ArrayList<String> HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
		
		validacion = comprobarHora(HoraSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una hora correcta.");
			System.out.println("Ingrese la hora: ");
			horaEntera = scan.next();
			System.out.println("Ingrese el minuto: ");
			Minuto = scan.next();
			HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
			validacion = comprobarHora(HoraSinValidar);
		}
		
		//Ingresar el contenido del post------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		scan = new Scanner(System.in);
		System.out.println("\nIngrese el la URL de la imagen: ");
		String Contenido = scan.nextLine();
		
		
		//INGRESAR TAMAÑO EN KILOBYTES------------------------------------------------------------
		
		float tamKilobytes = 0;
		String opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el tamano de la imagen (en kilobytes):");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarFloat(opcion);
		
		if (validacion){
			tamKilobytes = Float.parseFloat(opcion);
		}
		
		while (validacion = false || tamKilobytes<=0){
			System.out.println("ERROR!! Ingrese un numero valido.");
			opcion = scan.nextLine();
			validacion = comprobarFloat(opcion);
			if (validacion){
				tamKilobytes = Float.parseFloat(opcion);
			}
		}
		
		//INGRESAR FORMATO DE IMAGEN------------------------------------------------------------
		
		int numero = 0;
		opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el formato de la imagen:\n1.\tjpg\n2.\tpng\n3.\tgit");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero valido.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		String formato = "";
		
		if(numero==1){
			formato="JPG";
		}else if(numero==2){
			formato="PNG";
		}else if(numero==3){
			formato="GIF";
		}
		
		//INGRESAR RESOLUCION EN MEGAPIXELES
		
		float resPixeles = 0;
		opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese la resolucion de la imagen (en megapixeles):");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarFloat(opcion);
		
		if (validacion){
			resPixeles = Float.parseFloat(opcion);
		}
		
		while (validacion = false || resPixeles<=0){
			System.out.println("ERROR!! Ingrese un numero valido.");
			opcion = scan.nextLine();
			validacion = comprobarFloat(opcion);
			if (validacion){
				resPixeles = Float.parseFloat(opcion);
			}
		}
		
		//INGRESAR HASHTAGS-------------------------------------------------------------------------
		
		ArrayList<String> Hashtags = new ArrayList<String>();
		
		numero = 0;
		opcion = "";
		validacion = false;
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHASHTAGS");
		System.out.println("\nDesea ingresar algun hashtag para el post?\n1.\tSi\n2.\tNo");
		
		opcion = scan.nextLine();
		
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		while (numero!=2){
			//Pedir y guardar hashtag
			System.out.println("\nIngrese el hashtag (sin el simbolo '#')");
			String hashtag = scan.nextLine();
			Hashtags.add(hashtag);
			
			//Preguntar si desea ingresar otro hashtag
			
			numero = 0;
			opcion = "";
			validacion = false;
		
			System.out.println("\nDesea ingresar algun otro hashtag?\n1.\tSi\n2.\tNo");
		
			opcion = scan.nextLine();
		
			validacion = comprobarNumero(opcion);
		
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
			
			while (validacion = false || numero<1 || numero>4){
				System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
				opcion = scan.nextLine();
				validacion = comprobarNumero(opcion);
				if (validacion){
					numero = Integer.parseInt(opcion);
				}
			}
		}
		
		String tamKilobytesString = String.valueOf(tamKilobytes);
		String resPixelesString = String.valueOf(resPixeles);
		
		ArrayList<String> DatosNuevoPostImagen = new ArrayList<>(Arrays.asList(Contenido,autor,dia,mes,ano,horaEntera,Minuto,tamKilobytesString,formato,resPixelesString));
		
		for (int i=0; i<Hashtags.size(); i++){
			DatosNuevoPostImagen.add(Hashtags.get(i));
		}
		
		return DatosNuevoPostImagen;
	}
	
	/**
	 * Pide todos los datos necesarios para publicar un post de tipo audio
	 * @version 01/11/2021
	 * @return Devuelve un arreglo con todos los datos ingresados
	 */
	public static ArrayList<String> PedirDatosPostAudio(){
		
		//Pedir el autor------------------------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el nombre del autor: ");
		String autor = scan.nextLine();
		
		//Pedir fecha---------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nFECHA DE PUBLICACION\n");
		System.out.println("Ingrese el dia: ");
		String dia = scan.nextLine();
		System.out.println("Ingrese el mes: ");
		String mes = scan.nextLine();
		System.out.println("Ingrese el ano: ");
		String ano = scan.nextLine();
		
		boolean validacion;
		
		ArrayList<String> FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
		
		validacion = comprobarFecha(FechaSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una fecha correcta.");
			System.out.println("\nIngrese el dia: ");
			dia = scan.next();
			System.out.println("Ingrese el mes: ");
			mes = scan.next();
			System.out.println("Ingrese el ano: ");
			ano = scan.next();
			FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
			validacion = comprobarFecha(FechaSinValidar);
		}
		
		// Pedir hora-----------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHORA DE PUBLICACION (FORMATO DE 24 HORAS)\n");
		System.out.println("Ingrese la hora: ");
		String horaEntera = scan.next();
		System.out.println("Ingrese el minuto: ");
		String Minuto = scan.next();
		
		validacion = false;
		
		ArrayList<String> HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
		
		validacion = comprobarHora(HoraSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una hora correcta.");
			System.out.println("Ingrese la hora: ");
			horaEntera = scan.next();
			System.out.println("Ingrese el minuto: ");
			Minuto = scan.next();
			HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
			validacion = comprobarHora(HoraSinValidar);
		}
		
		//Ingresar el contenido del post------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		scan = new Scanner(System.in);
		System.out.println("\nIngrese el la URL del audio: ");
		String Contenido = scan.nextLine();
		
		
		//INGRESAR TAMAÑO EN KILOBYTES------------------------------------------------------------
		
		float tamKilobytes = 0;
		String opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el tamano del audio (en kilobytes):");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarFloat(opcion);
		
		if (validacion){
			tamKilobytes = Float.parseFloat(opcion);
		}
		
		while (validacion = false || tamKilobytes<=0){
			System.out.println("ERROR!! Ingrese un numero valido.");
			opcion = scan.nextLine();
			validacion = comprobarFloat(opcion);
			if (validacion){
				tamKilobytes = Float.parseFloat(opcion);
			}
		}
		
		//INGRESAR SAMPLE RATE EN HTZ---------------------------------------------------------------
		
		int numero = 0;
		opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el sample rate del audio:\n1.\t44.1 kHz\n2.\t48.0 kHz\n3.\t88.2 kHz\n4.\t96 kHz\n5.\t176.4 kHz\n6.\t192 kHz");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>6){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 6.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		String sampleRate = "";
		
		if(numero==1){
			sampleRate="44.1";
		}else if(numero==2){
			sampleRate="48.0";
		}else if(numero==3){
			sampleRate="88.2";
		}else if(numero==4){
			sampleRate="96";
		}else if(numero==5){
			sampleRate="176.4";
		}else if(numero==6){
			sampleRate="192";
		}
		
		//INGRESAR BIT DEPTH------------------------------------------------------------------------
		
		numero = 0;
		opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el bit depth del audio:\n1.\t16 bits\n2.\t24 bits\n3.\t32 bits");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		String bitDepth = "";
		
		if(numero==1){
			bitDepth="16";
		}else if(numero==2){
			bitDepth="24";
		}else if(numero==3){
			bitDepth="32";
		}
		
		//INGRESAR HASHTAGS-------------------------------------------------------------------------
		
		ArrayList<String> Hashtags = new ArrayList<String>();
		
		numero = 0;
		opcion = "";
		validacion = false;
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHASHTAGS");
		System.out.println("\nDesea ingresar algun hashtag para el post?\n1.\tSi\n2.\tNo");
		
		opcion = scan.nextLine();
		
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		while (numero!=2){
			//Pedir y guardar hashtag
			System.out.println("\nIngrese el hashtag (sin el simbolo '#')");
			String hashtag = scan.nextLine();
			Hashtags.add(hashtag);
			
			//Preguntar si desea ingresar otro hashtag
			
			numero = 0;
			opcion = "";
			validacion = false;
		
			System.out.println("\nDesea ingresar algun otro hashtag?\n1.\tSi\n2.\tNo");
		
			opcion = scan.nextLine();
		
			validacion = comprobarNumero(opcion);
		
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
			
			while (validacion = false || numero<1 || numero>4){
				System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
				opcion = scan.nextLine();
				validacion = comprobarNumero(opcion);
				if (validacion){
					numero = Integer.parseInt(opcion);
				}
			}
		}
		
		String tamKilobytesString = String.valueOf(tamKilobytes);
		
		ArrayList<String> DatosNuevoPostAudio = new ArrayList<>(Arrays.asList(Contenido,autor,dia,mes,ano,horaEntera,Minuto,tamKilobytesString,sampleRate,bitDepth));
		
		for (int i=0; i<Hashtags.size(); i++){
			DatosNuevoPostAudio.add(Hashtags.get(i));
		}
		
		return DatosNuevoPostAudio;
	}
	
	/**
	 * Pide todos los datos necesarios para publicar un post de tipo video
	 * @version 01/11/2021
	 * @return Devuelve un arreglo con todos los datos ingresados
	 */
	public static ArrayList<String> PedirDatosPostVideo(){
		
		//Pedir el autor------------------------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el nombre del autor: ");
		String autor = scan.nextLine();
		
		//Pedir fecha---------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nFECHA DE PUBLICACION\n");
		System.out.println("Ingrese el dia: ");
		String dia = scan.nextLine();
		System.out.println("Ingrese el mes: ");
		String mes = scan.nextLine();
		System.out.println("Ingrese el ano: ");
		String ano = scan.nextLine();
		
		boolean validacion;
		
		ArrayList<String> FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
		
		validacion = comprobarFecha(FechaSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una fecha correcta.");
			System.out.println("\nIngrese el dia: ");
			dia = scan.next();
			System.out.println("Ingrese el mes: ");
			mes = scan.next();
			System.out.println("Ingrese el ano: ");
			ano = scan.next();
			FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
			validacion = comprobarFecha(FechaSinValidar);
		}
		
		// Pedir hora-----------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHORA DE PUBLICACION (FORMATO DE 24 HORAS)\n");
		System.out.println("Ingrese la hora: ");
		String horaEntera = scan.next();
		System.out.println("Ingrese el minuto: ");
		String Minuto = scan.next();
		
		validacion = false;
		
		ArrayList<String> HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
		
		validacion = comprobarHora(HoraSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una hora correcta.");
			System.out.println("Ingrese la hora: ");
			horaEntera = scan.next();
			System.out.println("Ingrese el minuto: ");
			Minuto = scan.next();
			HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
			validacion = comprobarHora(HoraSinValidar);
		}
		
		//Ingresar el contenido del post------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		scan = new Scanner(System.in);
		System.out.println("\nIngrese el la URL del video: ");
		String Contenido = scan.nextLine();
		
		
		//INGRESAR TAMAÑO EN KILOBYTES------------------------------------------------------------
		
		float tamKilobytes = 0;
		String opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el tamano del video (en kilobytes):");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarFloat(opcion);
		
		if (validacion){
			tamKilobytes = Float.parseFloat(opcion);
		}
		
		while (validacion = false || tamKilobytes<=0){
			System.out.println("ERROR!! Ingrese un numero valido.");
			opcion = scan.nextLine();
			validacion = comprobarFloat(opcion);
			if (validacion){
				tamKilobytes = Float.parseFloat(opcion);
			}
		}
		
		//INGRESAR FRAME RATE-----------------------------------------------------------------------
		
		int frameRate = 0;
		opcion = "";
		validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el frame rate del video (cuadros por segundo):");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			frameRate = Integer.parseInt(opcion);
		}
		
		while (validacion = false || frameRate<=0){
			System.out.println("ERROR!! Ingrese un numero valido.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				frameRate = Integer.parseInt(opcion);
			}
		}
		
		String frameRateString = String.valueOf(frameRate);
		
		//INGRESAR HASHTAGS-------------------------------------------------------------------------
		
		ArrayList<String> Hashtags = new ArrayList<String>();
		
		int numero = 0;
		opcion = "";
		validacion = false;
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHASHTAGS");
		System.out.println("\nDesea ingresar algun hashtag para el post?\n1.\tSi\n2.\tNo");
		
		opcion = scan.nextLine();
		
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		while (numero!=2){
			//Pedir y guardar hashtag
			System.out.println("\nIngrese el hashtag (sin el simbolo '#')");
			String hashtag = scan.nextLine();
			Hashtags.add(hashtag);
			
			//Preguntar si desea ingresar otro hashtag
			
			numero = 0;
			opcion = "";
			validacion = false;
		
			System.out.println("\nDesea ingresar algun otro hashtag?\n1.\tSi\n2.\tNo");
		
			opcion = scan.nextLine();
		
			validacion = comprobarNumero(opcion);
		
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
			
			while (validacion = false || numero<1 || numero>4){
				System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
				opcion = scan.nextLine();
				validacion = comprobarNumero(opcion);
				if (validacion){
					numero = Integer.parseInt(opcion);
				}
			}
		}
		
		String tamKilobytesString = String.valueOf(tamKilobytes);
		
		ArrayList<String> DatosNuevoPostVideo = new ArrayList<>(Arrays.asList(Contenido,autor,dia,mes,ano,horaEntera,Minuto,tamKilobytesString,frameRateString));
		
		for (int i=0; i<Hashtags.size(); i++){
			DatosNuevoPostVideo.add(Hashtags.get(i));
		}
		
		return DatosNuevoPostVideo;
	}
	
	/**
	 * Pide todos los datos necesarios para publicar un post de tipo emoticon
	 * @version 01/11/2021
	 * @return Devuelve un arreglo con todos los datos ingresados
	 */
	public static ArrayList<String> PedirDatosPostEmoticon(){
		
		//Pedir el autor------------------------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n**************************************************************************");
		System.out.println("\nIngrese el nombre del autor: ");
		String autor = scan.nextLine();
		
		//Pedir fecha---------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nFECHA DE PUBLICACION\n");
		System.out.println("Ingrese el dia: ");
		String dia = scan.nextLine();
		System.out.println("Ingrese el mes: ");
		String mes = scan.nextLine();
		System.out.println("Ingrese el ano: ");
		String ano = scan.nextLine();
		
		boolean validacion;
		
		ArrayList<String> FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
		
		validacion = comprobarFecha(FechaSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una fecha correcta.");
			System.out.println("\nIngrese el dia: ");
			dia = scan.next();
			System.out.println("Ingrese el mes: ");
			mes = scan.next();
			System.out.println("Ingrese el ano: ");
			ano = scan.next();
			FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
			validacion = comprobarFecha(FechaSinValidar);
		}
		
		// Pedir hora-----------------------------------------------------------------------------
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHORA DE PUBLICACION (FORMATO DE 24 HORAS)\n");
		System.out.println("Ingrese la hora: ");
		String horaEntera = scan.next();
		System.out.println("Ingrese el minuto: ");
		String Minuto = scan.next();
		
		validacion = false;
		
		ArrayList<String> HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
		
		validacion = comprobarHora(HoraSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una hora correcta.");
			System.out.println("Ingrese la hora: ");
			horaEntera = scan.next();
			System.out.println("Ingrese el minuto: ");
			Minuto = scan.next();
			HoraSinValidar = new ArrayList<>(Arrays.asList(horaEntera,Minuto));
			validacion = comprobarHora(HoraSinValidar);
		}
		
		//Ingresar el contenido del post------------------------------------------------------------
		
		ArrayList<String> Emoticones = new ArrayList<>(Arrays.asList(":)",":(",":D",";)",":*","O:)","8)","^_^",":'(",":/",":P","3:)","8|","-_-",":3","<3",":o"));
		
		int numero = 0;
		String opcion = "";
		validacion = false;
		
		System.out.println("\n**************************************************************************");
		scan = new Scanner(System.in);
		System.out.println("\nIngrese el emoticon de la publicacion:\n1.\t:)\n2.\t:(\n3.\t:D\n4.\t;)\n5.\t:*\n6.\tO:)\n7.\t8)\n8.\t^_^\n9.\t:'(\n10.\t:/\n11.\t:P\n12.\t3:)\n13.\t8|\n14.\t-_-\n15.\t:3\n16.\t<3\n17.\t:o");
		
		opcion = scan.nextLine();
		
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>17){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 17.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		String emoticon = Emoticones.get(numero-1);
		
		//INGRESAR HASHTAGS-------------------------------------------------------------------------
		
		ArrayList<String> Hashtags = new ArrayList<String>();
		
		numero = 0;
		opcion = "";
		validacion = false;
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nHASHTAGS");
		System.out.println("\nDesea ingresar algun hashtag para el post?\n1.\tSi\n2.\tNo");
		
		opcion = scan.nextLine();
		
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		while (numero!=2){
			//Pedir y guardar hashtag
			System.out.println("\nIngrese el hashtag (sin el simbolo '#')");
			String hashtag = scan.nextLine();
			Hashtags.add(hashtag);
			
			//Preguntar si desea ingresar otro hashtag
			
			numero = 0;
			opcion = "";
			validacion = false;
		
			System.out.println("\nDesea ingresar algun otro hashtag?\n1.\tSi\n2.\tNo");
		
			opcion = scan.nextLine();
		
			validacion = comprobarNumero(opcion);
		
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
			
			while (validacion = false || numero<1 || numero>4){
				System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
				opcion = scan.nextLine();
				validacion = comprobarNumero(opcion);
				if (validacion){
					numero = Integer.parseInt(opcion);
				}
			}
		}
		
		ArrayList<String> DatosNuevoPostEmoticon = new ArrayList<>(Arrays.asList(emoticon,autor,dia,mes,ano,horaEntera,Minuto));
		
		for (int i=0; i<Hashtags.size(); i++){
			DatosNuevoPostEmoticon.add(Hashtags.get(i));
		}
		
		return DatosNuevoPostEmoticon;
	}
	
	/**
	 * Pide la fecha con la que se desean filtrar los posts
	 * @version 01/11/2021
	 * @return Devuelve un arreglo de enteros, donde el primer elemento es el dia, el segundo el mes, y el tercero el año de la fecha ingresada
	 */
	public static ArrayList<Integer> PedirFechaAFiltrar(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nINGRESE LA FECHA QUE DESEA FILTRAR\n");
		System.out.println("Ingrese el dia: ");
		String dia = scan.nextLine();
		System.out.println("Ingrese el mes: ");
		String mes = scan.nextLine();
		System.out.println("Ingrese el ano: ");
		String ano = scan.nextLine();
		
		boolean validacion;
		
		ArrayList<String> FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
		
		validacion = comprobarFecha(FechaSinValidar);
		
		while (!validacion){
			System.out.println("\nERROR!! Ingrese una fecha correcta.");
			System.out.println("\nIngrese el dia: ");
			dia = scan.next();
			System.out.println("Ingrese el mes: ");
			mes = scan.next();
			System.out.println("Ingrese el ano: ");
			ano = scan.next();
			FechaSinValidar = new ArrayList<>(Arrays.asList(dia,mes,ano));
			validacion = comprobarFecha(FechaSinValidar);
		}
		
		int diaEntero = Integer.parseInt(dia);
		int mesEntero = Integer.parseInt(mes);
		int anoEntero = Integer.parseInt(ano);
		
		ArrayList<Integer> FechaAFiltrar = new ArrayList<Integer>();
		FechaAFiltrar.add(diaEntero);
		FechaAFiltrar.add(mesEntero);
		FechaAFiltrar.add(anoEntero);
		
		return FechaAFiltrar;
	}
	
	/**
	 * Muestra todos los posts que pasaron el filtro de la fecha
	 * @version 01/11/2021
	 * @param FechaAFiltrar Es un arreglo que contiene el dia, el mes y el año de la fecha con la que se están filtrando los posts
	 * @param PostsFiltradosPorFecha Es un arreglo que contiene todos los posts que pasaron el filtro
	 */
	public static void MostrarPostsFiltradosPorFecha(ArrayList<Integer> FechaAFiltrar, ArrayList<Post> PostsFiltradosPorFecha){
		
		int dia = FechaAFiltrar.get(0);
		int mes = FechaAFiltrar.get(1);
		int ano = FechaAFiltrar.get(2);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nLos posts filtrados para la fecha " + dia + "/" + mes + "/" + ano + " son:");
		
		for(int i=0; i<PostsFiltradosPorFecha.size(); i++){
			Post PostFiltrado = PostsFiltradosPorFecha.get(i);
			System.out.println("\n" + PostFiltrado.toString());
		}
		
	}
	
	/**
	 * Muestra todos los posts que pasaron el filtro del hashtag
	 * @version 01/11/2021
	 * @param HashtagAFiltrar Es el hashtag con el que se están filtrando los posts
	 * @param PostsFiltradosPorHashtag Es un arreglo que contiene todos los posts que pasaron el filtro
	 */
	public static void MostrarPostsFiltradosPorHashtag(String HashtagAFiltrar, ArrayList<Post> PostsFiltradosPorHashtag){
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nLos posts filtrados para el hashtag #" + HashtagAFiltrar + " son:");
		
		for(int i=0; i<PostsFiltradosPorHashtag.size(); i++){
			Post PostFiltrado = PostsFiltradosPorHashtag.get(i);
			System.out.println("\n" + PostFiltrado.toString());
		}
		
	}
	
	/**
	 * Muestra las opciones que se pueden hacer con los posts que pasaron el filtro y se pide al usuario que indique cual desea ejecutar
	 * @version 01/11/2021
	 * @return Devulve un entero que indica la opción ingresada
	 */
	public static int MostrarMenuLuegoDeFiltrar(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nQue accion desea hacer para uno de estos posts?");
		System.out.println("1.\tReproducir post");
		System.out.println("2.\tDar like a post");
		System.out.println("3.\tPoner comentario a post");
		System.out.println("4.\tNinguna");
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide el posto a reproducir
	 * @version 01/11/2021
	 * @param PostsFiltrados Es un arreglo que contiene todos los posts que pasaron el filtro
	 * @return Devulve un entero que indica el post seleccionado
	 */
	public static int PedirPostAReproducir(ArrayList<Post> PostsFiltrados){
		
		int PosicionPost = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nQue post desea reproducir?");
		
		for(int i=0; i<PostsFiltrados.size(); i++){
			
			Post PostEnCuestion = PostsFiltrados.get(i);
			
			System.out.println((i+1) + "\tPost No. " + PostEnCuestion.getnumPost());
			
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			PosicionPost = Integer.parseInt(opcion);
		}
		
		while (validacion = false || PosicionPost<1 || PosicionPost>PostsFiltrados.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + PostsFiltrados.size() +"");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				PosicionPost = Integer.parseInt(opcion);
			}
		}
		
		PosicionPost--;
		
		return PosicionPost;
		
	}
	
	/**
	 * Se pide el posto a dar like
	 * @version 01/11/2021
	 * @param PostsFiltrados Es un arreglo que contiene todos los posts que pasaron el filtro
	 * @return Devulve un entero que indica el post seleccionado
	 */
	public static int PedirPostADarLike (ArrayList<Post> PostsFiltrados){
		
		int PosicionPost = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nA que post le desea dar like?");
		
		for(int i=0; i<PostsFiltrados.size(); i++){
			
			Post PostEnCuestion = PostsFiltrados.get(i);
			
			System.out.println((i+1) + "\tPost No. " + PostEnCuestion.getnumPost());
			
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			PosicionPost = Integer.parseInt(opcion);
		}
		
		while (validacion = false || PosicionPost<1 || PosicionPost>PostsFiltrados.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + PostsFiltrados.size() +"");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				PosicionPost = Integer.parseInt(opcion);
			}
		}
		
		PosicionPost--;
		
		return PosicionPost;
		
	}
	
	/**
	 * Se pide el posto a comentar
	 * @version 01/11/2021
	 * @param PostsFiltrados Es un arreglo que contiene todos los posts que pasaron el filtro
	 * @return Devulve un entero que indica el post seleccionado
	 */
	public static int PedirPostAComentar (ArrayList<Post> PostsFiltrados){
		
		int PosicionPost = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nA que post le desea poner un comentario?");
		
		for(int i=0; i<PostsFiltrados.size(); i++){
			
			Post PostEnCuestion = PostsFiltrados.get(i);
			
			System.out.println((i+1) + "\tPost No. " + PostEnCuestion.getnumPost());
			
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			PosicionPost = Integer.parseInt(opcion);
		}
		
		while (validacion = false || PosicionPost<1 || PosicionPost>PostsFiltrados.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + PostsFiltrados.size() +"");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				PosicionPost = Integer.parseInt(opcion);
			}
		}
		
		PosicionPost--;
		
		return PosicionPost;
		
	}
	
	/**
	 * Se pide el comentario que se desea escribir
	 * @version 01/11/2021
	 * @return Devulve el comentario
	 */
	public static String PedirCometario(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nIngrese el comentario que desea dejar: ");
		String Comentario = scan.nextLine();
		
		return Comentario;
		
	}
	
	/**
	 * Pide el hashtag con el que se desea filtrar los posts
	 * @version 01/11/2021
	 * @param ListaHashtags Arreglo de todos los hashtags que se han utilizado dentro del sistema
	 * @return Devuelve el hashtag ingresado por le usuario
	 */
	public static String PedirHashtagAFiltrar(ArrayList<String> ListaHashtags){
		
		int PosicionHashtag = 0;
		String opcion = "";
		boolean validacion = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n**************************************************************************");
		System.out.println("\nINGRESE EL HASHTAG QUE DESEA FILTRAR\n");
		
		for(int i=0; i<ListaHashtags.size(); i++){
			System.out.println((i+1) + "\t" + ListaHashtags.get(i));
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			PosicionHashtag = Integer.parseInt(opcion);
		}
		
		while (validacion = false || PosicionHashtag<1 || PosicionHashtag>ListaHashtags.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + ListaHashtags.size() +"");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				PosicionHashtag = Integer.parseInt(opcion);
			}
		}
		
		PosicionHashtag--;
		
		String HashtagAFiltrar = ListaHashtags.get(PosicionHashtag);
		
		return HashtagAFiltrar;
	}
	
	/**
	 * Verifica si el valor que recibe como parámetro es un entero.
	 * @version 01/11/2021
	 * @param conjuntoCaracteres Valor del cual se verificará si es un entero o no.
	 * @return Devuelve true si el valor recibido como parámetro es un entero, de lo contrario, devuelve false
	 */
	private static boolean comprobarNumero(String conjuntoCaracteres){
		try{
			//Se trata de convertir el objeto de tipo String a tipo int
			Integer.parseInt(conjuntoCaracteres);
			return true;
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/**
	 * Verifica si el valor que recibe como parámetro puede ser convertido a tipo float.
	 * @version 01/11/2021
	 * @param conjuntoCaracteres Valor del cual se verificará si es un float o no.
	 * @return Devuelve true si el valor recibido como parámetro es de tipo float, de lo contrario, devuelve false
	 */
	private static boolean comprobarFloat(String conjuntoCaracteres){
		try{
			//Se trata de convertir el objeto de tipo String a tipo int
			Float.parseFloat(conjuntoCaracteres);
			return true;
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/**
	 * Verifica si la fecha ingresada es correcta
	 * @version 01/11/2021
	 * @param Fecha Arreglo en el que el primer elemento es el dia, el segundo es el mes, y el tercero es el año de la fecha ingresada
	 * @return Devuelve true si la fecha es correcta, de lo contrario, devuelve false
	 */
	private static boolean comprobarFecha(ArrayList<String> Fecha){
		
		boolean valor = true;
		boolean SonEnteros = true;
		
		SonEnteros = comprobarNumero(Fecha.get(0));
		SonEnteros = comprobarNumero(Fecha.get(1));
		SonEnteros = comprobarNumero(Fecha.get(2));
		
		
		if (SonEnteros){
			
			int dia = Integer.parseInt(Fecha.get(0));
			int mes = Integer.parseInt(Fecha.get(1));
			int ano = Integer.parseInt(Fecha.get(2));
			
			if(ano>2021){
				valor=false;
			}
			if(ano<=1900){
				valor=false;
			}
			if(mes>12){
				valor=false;
			}
			if(dia>31){
				valor=false;
			}
			
			//Comprobar por mes
			
			if(mes==2){
				if (ano%4 == 0){
					if(dia>29){
						valor=false;
					}
				}
				else if (ano%4 != 0){
					if(dia>28){
						valor=false;
					}
				}
			}
			
			if(mes==4){
				if(dia>30){
					valor=false;
				}
			}
			
			if(mes==6){
				if(dia>30){
					valor=false;
				}
			}
			
			if(mes==9){
				if(dia>30){
					valor=false;
				}
			}
			
			if(mes==11){
				if(dia>30){
					valor=false;
				}
			}
			
			//Comprobar que la fecha no se mas adelante que el presente
			if(ano==2021){
				if(mes>11){
					valor=false;
				}
			}
			
		}else if(!SonEnteros){
			valor = false;
		}
		
		return valor;
	}
	
	/**
	 * Verifica si la hora ingresada es correcta
	 * @version 01/11/2021
	 * @param Hora Arreglo en el que el primer elemento es la hora, y el segundo el minuto de la hora ingresada
	 * @return Devuelve true si la hora es correcta, de lo contrario, devuelve false
	 */
	public static boolean comprobarHora (ArrayList<String> Hora){
		
		boolean valor = true;
		boolean SonEnteros = true;
		
		SonEnteros = comprobarNumero(Hora.get(0));
		SonEnteros = comprobarNumero(Hora.get(1));
		
		if (SonEnteros){
			int horaEntera = Integer.parseInt(Hora.get(0));
			int Minuto = Integer.parseInt(Hora.get(1));
			
			if(horaEntera>24 || horaEntera<0){
				valor = false;
			}
			if(Minuto>60 || Minuto<0){
				valor = false;
			}
			
		}else if(!SonEnteros){
			valor = false;
		}
		
		return valor;
	}
	
}