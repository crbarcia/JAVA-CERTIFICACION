package com.activa.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

//import java.util.logging.*;

import com.activa.lessons.PrimitiveData;

public class AppMain {
	
	// habria que pasar esta explicacion a Mod1_JavaBasic
	static int number = 10; // declaramos una variable
	// declaramos otra variable pero al añadirle la palabra final,
	// convertimos la variable en una constante, y no le permite asignarle un nuevo
	// valor
	// ponemos las constantes en mayusculas
	final static int NUMBERFINAL = 10;

	public static void main(String[] args) {
		
		// le asignamos a la variable number el valor 20
		number = 20;
		// pasaria a ser constante y daria error de compilacion , el valor con el que ha
		// sido
		// inicializado va a ser siempre su valor al ser una constante
		// NUMBERFINAL=20;
		System.out.println("Mi variable number tiene el valor: " + number);
		System.out.println("Mi constante denominada NUMBERFINAL tiene el valor definitivo: " + NUMBERFINAL);
		// pruebas varias
		// byte numByte=12;
		// numByte=5;

		// GENERAL: tipos de datos primitivos:
		// byte -->8 bits --> ver valores en ejecucion codigo
		// short --> 16 bits -->ver valores en ejecucion codigo
		// Int --> 32 bits --> ver valores en ejecucion codigo
		// Long -->64 bits --> ver valores en ejecucion codigo
		// float --> 32 bits --> ver valores en ejecucion codigo
		// double --> 64 bits --> ver valores en ejecucion codigo
		// char--> 16 bits -->ver valores en ejecucion codigo
		// string (invitado xdxd)

		// Datos numericos enteros;
		// [tipo][nombre] [=][valor];

		byte numByteMin = 127;// esto es el dato numero mas pequeño
		byte numByteMax = -128;
		// numByte++;
		// System.out.println(numByte);

		// typo de dato Byte
		// System.out.println("Byte:\n\tNumero maximo" + numByteMax + "\n\tNumero
		// minimo" + numByteMin);
		long num = 23_542_342_623_523L;
		long num2 = 23542342623523L;
		p("Byte", numByteMax, numByteMin);

		// tipo de dato short
		short numShortMax = 32767;
		short numShortMin = -32768;
		p("Short", numShortMax, numShortMin);

		// tipo de dato Int
		int numIntMax = Integer.MAX_VALUE;// class wrapped - Unboxed/boxed
		int numIntMin = Integer.MIN_VALUE;
		p("Integer", numIntMax, numIntMin);

		// tipo de dato Long
		long numLongMax = Long.MAX_VALUE;
		long numLongMin = Long.MIN_VALUE;
		long numLong = 2147483647213415443L;// L importante que interprete que es un long y no un integer
		p("Long", numLongMax, numLongMin);

		// Datos numericos decimales

		float numFloatMax = Float.MAX_VALUE;
		float numFloatMin = Float.MIN_VALUE;
		// error de compilacion, necesario ponerle la f a la variable numFloat para que
		// no
		// ese error de compilacion float numFloat=4.5;
		float numFloat = 4.5f;
		System.out.println("el float decimal" + numFloat);
		p("Float", numFloatMax, numFloatMin);

		double numDoubleMax = Double.MAX_VALUE;
		double numDoubleMin = Double.MIN_VALUE;
		p("Double", numDoubleMax, numDoubleMin);

		// Boolean -tipo de dato pensado para expresiones condicionales.
		// Basado en un bit(true or false)

		int age = 24;
		boolean isAdult = false;
		isAdult = age >= 18;
		System.out.println("¿Es mayor de edad ? " + isAdult);

		// Char - unicode de 16 bits, un solo caracter
		// comilla simples es un char, el string va con comillas dobles
		// char letrachar='I';
		char letraMaxima = Character.MAX_HIGH_SURROGATE;
		char letra = 65;
		letra += 32;
		System.out.println("valor letra " + letra + " \n\t¿Es el dato una letra?" + Character.isLetter(letra));
		char letra2 = 'D';
		System.out.println("valor letra2 " + letra2 + "\n\t¿Es el dato una letra? " + Character.isLetter(letra2));

		// String
		String texto = "Que la fuerza te acompañe!!!";
		// String texto1= new String(); instanciacion
		// String es una clase inumtable , no afecta al original stringbuilder si
		texto.toUpperCase();// copia del original en mayusculas
		texto = texto.toUpperCase();// el original se cambia a mayusculas
		System.out.println(texto.toUpperCase());
		// java acepta declarar variables como var
		// mala practica, es valido y no provoca error de compilacion si declaras una
		// variable de tipo var
		// denominandola var
		// var var=10;

		// Conversion de tipos de datos
		String volume = "15";
		// error de compilacion al estarle pasando un string a un metodo que pide como
		// parametro de entrada un int
		// getVolume(volume);
		int volumeInt = Integer.parseInt(volume);
		int volumeByte = Byte.parseByte(volume);

		getVolume(volumeInt);
		System.out.println("(string) El volumen es: " + volume + 10);
		System.out.println("(Integer) El volumen es: " + volumeInt + 10);
		System.out.println("(Byte) El volumen es: " + volumeByte + 10);

		String numberText = String.valueOf(25);
		System.out.println("El valor del numberText es:" + numberText + 10);

		// uso de Cast -> conversion de tipo de datos
		int n1 = 1;
		// error de compilacion: cannot convert from int to byte
		// byte n2=n1;
		// hacemos el cast
		byte n2 = (byte) n1;
		// otro ejemplo
		double decimal = 33.98;
		System.out.println("El valor del decimal es:" + decimal);
		double decimal2 = 33.98;
		System.out.println("El valor del decimal2 convertido de double a  long es:" + (long) decimal2);

		PrimitiveData pd = new PrimitiveData();

		int[] numbers = new int[5];
		// posicion 0 array valor 1, posicion 1 valor 8 posicion 2 valor 50 posicion 3
		// valor 33
		// 0=1,2=8,2=50,3=33
		int[] numbers2 = new int[] { 1, 8, 50, 33 };
		int[] numbers3 = { 10, 9, 80, 45 };

		System.out.println(numbers[4]);

		prueba(new String[] { "Alvaro", "Rodrigo", "Eva" });

		prueba2(new String[] { "Cris", "Rodrigo", "Eva" });
		// esto da error compilacion
		// String[][] names1= new String[][];
		// esto da error compilacion
		// String[][] names2= new String[][0];
		// esto correcto
		String[][] names3 = new String[1][];

		// dada la siguiente matriz
		String[][] names4 = new String[][] { { "Paco", "Ramon" }, { "Laura", "Silvia" }

		};
		// para imprimir nombre Silvia:
		// {0.0,0.1}
		// {0.1,1.1}
		System.out.println("Mi nombre es: " + names4[1][1]);

		// para imprimir nombre Laura:
		// {0.0,0.1}
		// {0.1,1.1}
		System.out.println("Mi nombre es: " + names4[1][0]);

		// queremos saber el numero de caracteres del nombre Silvia
		System.out.println("La longitud del nombre Silvia es:" + names4[1][1].toLowerCase().trim().length());

		// queremos saber la letra en la que esta una determinada posicion de una cadena
		System.out.println("La letra de la posicion 1 del nombre Silvia es:" + names4[1][1].charAt(1));

		// vamos a obtener la letra de la ultima posicion de una cadena
		String name6 = "Leticia";
		System.out.println("El ultimo caracter de mi cadena es:" + name6.charAt(name6.length() - 1));

		// vamos a obtener una parte de la cadena desde la posicion 8 hasta el final
		// la subcadena que nos queda es "nos quedara Paris"
		String name7 = "Siempre nos quedara Paris";
		System.out.println("Mi nueva subcadena de mi cadena name7 es: " + name7.substring(8, name7.length()));

		// dada la siguiente matriz:

		String[][] names7 = new String[][] { { "Paco", "Ramon" }, { "Laura", "Silvia" } };

		// vamos a ver cual tiene mayor numero de letras con el uso de ala logitud
		if (names7[1][1].length() >= names7[0][0].length()) {
			System.out.println(
					"El nombre: " + names7[1][1] + " tiene mayor numero de letras que el nombre" + names7[0][0]);
		} else {
			System.out.println(
					"El nombre: " + names7[1][1] + " tiene menor numero de letras que el nombre" + names7[0][0]);
		}

		// vamos a comparar si el nombre Silvia es igual al nombre Paco
		if (names7[1][1] == names7[0][0]) {
			System.out.println("El nombre: " + names7[1][1] + " es igual que el nombre " + names7[0][0]);
		} else {
			System.out.println("El nombre: " + names7[1][1] + " es diferente que el nombre " + names7[0][0]);
		}

		// comparacion de strings con equals (ALWAYS)
		String n3 = "Paco";
		String n4 = "Paco";

		if (n3.equals(n4)) {
			System.out.println("la cadena " + n3 + "es igual a la cadena " + n4);
		} else {
			System.out.println("la cadena " + n3 + "es diferente a la cadena " + n4);
		}

		// comparacion de numeros
		int n5 = 5;
		int n6 = 5;

		if (n5 == n6) {
			System.out.println("El numero" + n5 + " es igual al numero" + n6);
		} else if (n5 > n6) {
			System.out.println("El numero" + n5 + "es mayor que el numero" + n6);
		} else {
			System.out.println("El numero" + n5 + "es menor que el numero" + n6);
		}

		// dados dos numeros vamos a averiguar si son pares/impares (TODO)

		// BUCLES--------------------------------------

		// BUCLE WHILE
		// dado el siguiente array de numeros
		// vamos a imprimir todos los numeros que sean menores del valor 50
		int[] numbers4 = new int[] { 1, 8, 50, 33 };
		int index = 0;
		while (numbers4[index] < 50) {
			System.out.println("Mi numero es: " + numbers4[index] + " y es menor que 50");
			index++;
		}

		// BUCLE DO WHILE
		// dado el siguiente array de numeros
		// vamos a imprimir todos los numeros que sean menores del valor 50
		int[] numbers5 = new int[] { 111, 8, 50, 33 };
		int index2 = 0;
		do {
			System.out.println("Mi numero es:" + numbers5[index2]);
			index2++;
		} while (numbers5[index2] < 50);

		int[][][] numbers3D = new int[][][] {

				// {0.0.0} <-->{0.1.0}
				// {1.0.0}{1.0.1}{1.0.2} <-->{1.1.0}{1.1.1}
				// {2.0.1}{2.0,2}<-->{2.1,0}{2,1,1}{2,1,2},{2,1,2 <-->
				// {2.2,0}{2,2,1}{2,2,2},{2,2,2}{2,2,3}{2,2,4}

				{ { 8 }, { 10 } }, { { 3, 4, 5 }, { 11, 20 } }, { { 23, 100 }, { 99, 5, 4, 200 }, { 1, 2, 3, 4, 5 } } };

		// vamos a imprimir el numero 8
		System.out.println("Mi numero es: " + numbers3D[0][0][0]);

		// vamos a imprimir el numero 10
		System.out.println("Mi numero es: " + numbers3D[0][1][0]);

		// vamos a imprimir el numero 200
		System.out.println("Mi numero es: " + numbers3D[2][1][3]);

		// vamos a imprimir el numero 4
		System.out.println("Mi numero es: " + numbers3D[2][1][2]);

		// vamos a imprimir el numero 99
		System.out.println("Mi numero es: " + numbers3D[2][1][0]);

		// BUCLE FOR para mostrar todos los numeros de un array en el orden del array

		System.out.println("\nEmpezamos con los bucles");
		int[] numbers6 = new int[] { 111, 8, 7, 18, 50, 33 };
		for (int i = 0; i < numbers6.length; i++) {
			System.out.println("Numeros de mi array por orden: " + numbers6[i]);

		}

		// BUCLE FOR para mostrar todos los numeros de un array pero al reves
		int[] numbers7 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = numbers7.length - 1; i >= 0; i--) {
			System.out.println("Numeros de mi array al reves: " + numbers7[i]);

		}

		// BUCLE FOR EACH REVISAR APUNTES
		/*
		 * char [ ]name8 = "Siempre nos quedara Paris"; for (int
		 * i=0;i<name8.length();i++) { System.out.println(name8[i]); }
		 */

		// BUCLES ANIDADOS

		int resultI = 0, resultJ = 0, resultK = 0;
		BucleA: for (int i = 0; i < 3; i++) {
			resultI++;
			System.out.println("Indice I=" + i);
			BucleB: for (int j = 0; j < 3; j++) {
				System.out.println("Indice J=" + j);
				resultJ++;
				BucleC: for (int k = 0; k < 3; k++) {
					System.out.println("Indice K=" + j);
					resultK++;
				}

			}
			System.out.println(
					"RESULTADO FINAL: " + "BUCLE A " + resultI + " BUCLE B " + resultJ + " BUCLE C " + resultK);

		}

		// INSTRUCCION SWITCH
		// Pedimos por consola un numero del 1 al 2, y nos muestra el mensaje
		// dependiendo del numero
		// que escoja el usuario

		// consola
		/*
		 * Scanner sc2 = new Scanner(System.in);
		 * System.out.println("Introduzca un numero del 1 al 2:"); switch
		 * (sc2.nextInt()) { case 1: System.out.println("Soy el número 1"); break; case
		 * 2: System.out.println("Soy el número 2 "); break; case 3,6 :
		 * System.out.println("Soy el número 3 "); break; //case 4 | 7 :
		 * //System.out.println("Soy el número 4 "); //break; //default no es
		 * imprescidible ni tiene que estar al final //SOLO SE PUEDE TENER UN DEFAULT
		 * default: throw new IllegalArgumentException("Unexpected value: " +
		 * sc2.toString()); }
		 * 
		 * sc2.close();
		 */

		// OTRO EJEMPLO INSTRUCCION SWITCH

		// consola
		/*
		 * Scanner sc3 = new Scanner(System.in);
		 * System.out.println("Dia de la semana según tu estado de ánimo:"); //quitamos
		 * los espacios en blanco que pueda tener el texto y convertimos //a mayuscula
		 * lo que haya introducido el usuario switch (sc3.next().trim().toUpperCase()) {
		 * case "LUNES": System.out.println("Lunes todo mal"); break; case "MARTES":
		 * System.out.println("Martes ni te cases ni te embarques "); break; case
		 * "MIERCOLES": System.out.println("Miercoles mitad de semana"); break; case
		 * "JUEVES": System.out.println("Es juernes"); break; case "VIERNES":
		 * System.out.println("Viernes"); break; default: throw new
		 * IllegalArgumentException("Unexpected value: " + sc3.toString()); }
		 * sc3.close();
		 */

		// CONDICIONAL TERNARIO EJEMPLO 1
		/*
		 * Scanner sc4 = new Scanner(System.in); System.out.println("Dime un numero:");
		 * String texto1=""; texto1= (sc4.nextInt() % 2 == 0) ? "Si eres par molas" :
		 * "Si no eres par no molas "; System.out.println(texto1); sc4.close();
		 */

		// CONDICIONAL TERNARIO EJEMPLO 2 (PENDIENTE DE HACER REVISAR CURSO)
		/*
		 * Scanner sc5 = new Scanner(System.in); System.out.println("Dime un numero:");
		 * String texto2=""; texto2= (sc5.nextInt() % 2 == 0) ? "Si eres par molas" :
		 * "Si no eres par no molas "; System.out.println(texto2); sc5.close();
		 */

		// USO DE EXCEPCIONES
		// pedimos un numero
		// si es par hola, si es impar adios
		// si le pones una letra sale mensaje has escrito letra no numero
		/*
		 * Scanner sc6 = new Scanner(System.in); int n7=10; do {
		 * System.out.println("Dime un numero:"); try { n7=sc6.nextInt(); String
		 * texto3=(n7 %2 == 0) ? "Hola" : "Adios"; System.out.println(texto3); }
		 * //catch(InputMismatchException e) //MULTICATCH , el mismo tratamiento para
		 * dos excepciones distintas siempre y cuando no haya una //relacion de herencia
		 * entre ellas catch(InputMismatchException | NumberFormatException e) {
		 * System.out.println("He dicho que escribas un numero,intentalo de nuevo");
		 * System.out.println(e); //nos indica en consola donde nos ha dado el error ,
		 * pero no interrumpe la //ejecucion del codigo //e.printStackTrace();
		 * 
		 * 
		 * }
		 * 
		 * } while (n7% 2 !=0 );
		 * 
		 * sc6.close();
		 *
		 * 
		 * 
		 * 
		 * 
		 * // OTRO BUCLE DO WHILE // siempre se ejecuta al menos una vez // vamos a
		 * mostrar un menu Scanner sc = new Scanner(System.in); int in = 0; /* do {
		 * System.out.println("MENU"); System.out.println("\n1. Mostrar nombre" +
		 * "\n2. Mostrar numero" + "\n3. Mostrar apellido" + "\n4 .Salir"); in =
		 * sc.nextInt(); } while (in != 0); sc.close();
		 */

		// USO DE EXCEPCIONES MEDIANTE UN METODO usoExcepciones
		// EL METODO LO QUE HACE ES:
		// PIDE UN NUMERO, SI ES PAR DICE HOLA, SI ES IMPAR ADIOS
		// PINTA EL FINALLY PONIENDO LA PALABRA ALGO
		// DEVUELVE UN RETURN 0
		// RESULTADO
		// numero 3, adios, algo, 0
		/*
		 * System.out.println("Dime un numero:"); int n9= usoExcepciones();
		 * System.out.println(n9);
		 */

		// USO DE EXCEPCIONES PROPAGADA
		try {
			excepcionPropagada();
		} catch (IOException e) {
			System.out.println("Estamos propagando la excepcion");
		}

		// MAS USO DE EXCEPCIONES
		// buscamos un fichero y lo leemos
		// en caso de no encontrar el archivo, sacamos el mensaje no se ha encontrado
		// archivo
		// en caso de que encontremos el archivo pero no se pueda leer aparecerá mensaje
		// el archivo está dañado
		/*try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			br.read();
		} catch (FileNotFoundException e) {
			//java.util.logging.Logger.getLogger(AppMain.class.getName()).log(Level.ERROR, "NO SE HA ENCONTRADO ARCHIVO");
			

		} catch (IOException e) {
			Logger.getLogger(AppMain.class.getName()).log(Level.ERROR, "El archivo esta dañado");
			
		} */
		
		

	}// fin del metodo main

	public static void prueba(String[] names) {

	}

	public static void prueba2(String... names) {
	}

	public static void p(String type, Number var1, Number var2) {
		System.out.println(type + ":\n\tNúmero máximo " + var1 + "\n\tNúmero mínimo " + var2);
	}

	public static void getVolume(int volume) {
		// Instrucciones para asignar al reproductor el valor que me pasan por argumento
	}

	public static int usoExcepciones()

	{
		Scanner sc7 = new Scanner(System.in);
		int n8 = 10;

		try {
			n8 = sc7.nextInt();
			String texto3 = (n8 % 2 == 0) ? "Hola" : "Adios";
			System.out.println(texto3);
		}

		catch (InputMismatchException | NumberFormatException e) {
			n8 = 5;
			System.out.println(e);
			return n8;
		} finally {
			System.out.println("Algo");
		}

		sc7.close();
		return 0;
	}

	public static void excepcionPropagada() throws IOException {
		throw new IOException("Soy la excepcion del método excepcionPropagada");
	}

}
