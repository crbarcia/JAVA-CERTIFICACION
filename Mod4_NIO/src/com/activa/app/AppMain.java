package com.activa.app;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.OpenOption;

public class AppMain {



	public static void main(String[] args) {

		// escapamos un string quedando asi: C:\Prueba"algo"
		// Path pprueba= Paths.get("C:\\Prueba\"algo\""); (error revisar)
		// System.out.println(":"+pprueba);
		Path p1 = Paths.get("C:\\Prueba\\");
		Path p2 = Path.of("cosa.txt");
		Path p3 = Path.of("..\\OtraCarpeta\\cosa.txt");
		Path p4 = Path.of("c:\\..\\cosa.txt");
		Path p5 = Path.of("c:\\Prueba\\DirectorioA");
		Path p6 = Path.of("cosa2.txt");
		Path p7 = Path.of("C:\\..\\masCarpetas\\otraCosa\\cosaP3.txt");
		Path p8 = Path.of("C:\\..\\masCarpetas\\otraCosa\\");

		System.out.println("Imprimimos el nombre del fichero o el ultimo elemento del path -> " + p1.getFileName());
		System.out.println("Imprimimos la ruta completa del fichero o directorio ->" + p2.toAbsolutePath());
		System.out.println("Imprimimos el contenido de la ruta-> " + p2);
		System.out.println("Imprimimos el contenido completo de la ruta-> " + p3);
		System.out.println("Imprimimos el contenido completo de la ruta-> " + p4);
		System.out.println("Imprimimos el nombre del fichero o el ultimo elemento del path-> " + p5.getFileName());
		// System.out.println("->"+p5.relativize(p2));//este daria excepcion, si uno es
		// ruta relativa y el
		// otro es una ruta absoluta , da excepcion.
		// para poder usar relativize, o bien ambas rutas son relativas o bien
		// absolutas, nunca se pueden
		// mezclar , si no daria la excepcion
		// este es un ejemplo con ambas rutas absolutas
		System.out.println(
				"Imprimimos la ruta completa y le añadimos el siguiente(ambas rutas absolutas)-> " + p6.relativize(p2));

		System.out.println("Imprimimos la ruta completa y le añadimos el siguiente-> " + p5.resolve(p2));
		System.out.println("Imprimimos la ruta completa y le añadimos el siguiente-> " + p5.resolve(p4));
		// para el resolve, si la raiz entre ambos fuera distinta, nos daria una
		// excepcion
		// TO DO EXCEPTION
		// esto lo que haria seria poner al contenido de p5 le añadiria el nombre del
		// fichero de p4
		System.out.println(
				"Imprimimos el contenido complet de la primera ruta y le añadimos el nombre de la segunda ruta -> "
						+ p5.resolve(p4.getName(p4.getNameCount() - 1)));
		// esto me imprimiria el nombre del primer elemento de la ruta de p5
		System.out.println("Imprimimos el nombre del primero elemento existente en la ruta -> " + p5.getName(0));
		// esto nos imprimiria toda la ruta padre hasta el ultimo elemento que contenga
		// la ruta (todo lo anterior al
		// nombre del fichero)
		System.out.println("Imprimimos la ruta padre hasta el ultimo elemento existente en esta -> " + p7.getParent());
		// esto nos imprimiria toda la ruta padre hasta el ultimo elemento que contenga
		// la ruta (todo lo anterior al
		// ultimo elemento de la ruta
		System.out.println("Imprimimos la ruta padre hasta el ultimo elemento existente en esta -> " + p8.getParent());

		// USO DE FILES
		// añadimos a una carpeta que queramos un fichero denominado Prueba.txt con el
		// contenido del loremipsun chiquitoooooooooorr de la calzada

		Path p9 = Path.of("D:\\PruebaFicheroCurso\\Prueba.txt");
		Path p10 = Path.of("D:\\PruebaFicheroCurso\\PruebaCopia\\PruebaCopia.txt");
		Path p11 = Path.of("D:\\PruebaFicheroCurso\\PruebaMover.txt");
		// leemos todas las lineas del fichero

		// para que no diera error el siguiente ejemplo comentado habria que propagar
		// IOexception en el main (no recomendable) de la
		// siguiente manera:
		// public static void main(String [] args) throws IOException

		// leemos todas las lineas de mi fichero
		// List<String> list= Files.readAllLines(p9);
		// leemos la lineas en formato UTF-8
		// List<String> list2= Files.readAllLines(p9,Charset.forName("UTF-8"));

		// imprimimos todo el contenido del fichero foreach lamba de list1
		// list.forEach(System.out::println);
		// imprimimos todo el contenido del fichero foreach lamba
		// list2.forEach(System.out::println);

		// mismo ejemplo que el anterior que he comentado sin propagar IOException
		try {
			List<String> list = Files.readAllLines(p9);
			List<String> list2 = Files.readAllLines(p9, Charset.forName("UTF-8"));
			System.out.println("Imprimimos contenido del fichero->");
			list.forEach(System.out::println);
			System.out.println("Imprimimos contenido del fichero UTF-8->");
			list2.forEach(System.out::println);
			// le añade al contenido de mi fichero la cadena "Yo me llamo ralph", lo añade
			// al contenido del fichero
			// al estar la opción como append
			// lo comentamos para que no añada siempre la frase cada vez que ejecutamos el
			// codigo
			// Files.writeString(p9, "Yo me llamo ralph",StandardOpenOption.APPEND);
			// list.forEach( System.out::println);
			// Files.write(p9, list, Charset.forName("UTF-8"),);

			// nos crea una copia del contenido del fichero de p9 al fichero p10, si no
			// existe el fichero
			// lo crea
			// Files.copy(p9, p10);
			// moveriamos el archivo a una nueva ruta
			// Files.move(p9, p11);
			// eliminamos el archivo (si el archivo no existe, nos podria dar una excepcion)
			// Files.delete(p10);
			// borramos el archivo solo si dicho archivo existe en la ruta (nos evitamos la
			// excepcion)
			// Files.deleteIfExists(p10);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// USO DE TRY CON RECURSOS

		Scanner sc = new Scanner(System.in);// Effectivily final
		// si le modificaramos el valor a sc , ya no seria Effectivily final y nos
		// daria un error
		// creamos un objeto de tipo recurso y hacemos que sea AutoCloseable,
		// de tal manera que , dicho recurso se va a cerrar de manera automatica
		// y nos imprimirá la frase que hemos añadido al metodo close del recurso
		// denominada "Imprimimos hemos cerrado nuestro recurso"
		try (sc; Recurso n = new Recurso()) {
			System.out.println("Escribe algo:");
			String text = sc.next();
			System.out.println(text);
			// sc.close();
		} catch (Exception ex) {
			Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}

class Recurso implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Imprimimos hemos cerrrado nuestro recurso");

	}

}
