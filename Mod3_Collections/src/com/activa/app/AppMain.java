package com.activa.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class AppMain {

	int m = 0;
	static int m2 = 0;

	public static void main(String[] args) {
		// da error de compilacion , se podrian crear listas no tipadas denominadas
		// RawList
		// List < > nombres= new ArrayList<>();

		// se redimensiona dinamicamente
		// tipo de datos no primitivos
		// se pueden poner numericos pero desde sus clases envoltorio
		// es decir, en lugar de Int, integer

		List<String> nombres = new ArrayList<>();
		nombres.add("Cristina");// Pos 0
		nombres.add("Maria");// Pos 1
		nombres.add("Megui");// Pos 2

		// voy a imprimir el nombre Megui
		System.out.println("Mi nombre es : " + nombres.get(2));
		// esto daria nullpointer exception?? no, porque la lista admite nulos
		nombres.add(null);
		// esto daria nullpointer exception?? no porque la impresion admite nulos
		System.out.println("Mi nombre es : " + nombres.get(3));
		// vamos a asignarle al valor de la lista null el valor ruben
		nombres.set(3, "Ruben");// Pos 4
		// imprimimos ruben
		System.out.println("Mi nombre es : " + nombres.get(3));

		String text = nombres.set(1, "Esther");
		// ahora en la posicion 1 imprimirá esther
		System.out.println("Mi nombre es : " + nombres.get(1));
		// para eliminar un nombre de la lista
		nombres.remove("Oscar");
		// para eliminar un nombre de la lista con condicional ternario
		text = (nombres.remove("Oscar")) ? "Se ha eliminado de la lista" : "No se ha eliminado de la lista";
		// nos va a decir que no se ha eliminado de la lista dado que oscar no está
		// incluido en la lista
		System.out.println("Se ha eliminado oscar de la lista? " + text);
		text = (nombres.remove("Esther")) ? "Se ha eliminado de la lista" : "No se ha eliminado de la lista";
		// nos va a decir que Esther se ha eliminado de la lista , dado que existia y lo
		// ha eliminado
		System.out.println("Se ha eliminado Esther de la lista? " + text);
		// vamos a eliminar el nombre de la posicion 0 del array (en este caso cristina)
		text = nombres.remove(0);
		// el resultado es que ha eliminado Cristina de la lista
		System.out.println("¿Que nombre se ha eliminado de la lista? " + text);
		// bucle

		System.out.println("Impresion mediante For:Nombre");
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println("For: Posicion+Nombre " + i + ":" + nombres.get(i));

		}
		System.out.println("Impresion desde ForEach ");
		for (String nombre : nombres) {
			System.out.println("For Each: " + nombre);
		}

		// al metodo forEach, le pasamos las instrucciones que tiene que hacer dado que
		// la lista nombres
		// ya tiene todo el contenido, le decimos que imprima el contenido de toda la
		// lista
		// en este momento te imprime Megui/Ruben dado que son los unicos nombres de la
		// lista
		System.out.println("Impresion ForEach directa");
		nombres.forEach(System.out::println);

		// declaro un array de numeros
		int[] numbers = { 1, 5, 17, 89, 107 };
		// creo una lista con un array de numeros
		List<Integer> numbersList = Arrays.asList(1, 5, 17, 89, 107);

		Integer[] numbersArr = { 1, 5, 17, 89, 107 };

		List<Integer> numbersList2 = new ArrayList<>();
		for (int i : numbersArr) {
			numbersList2.add(i);
		}

		// inmutabilidad listas list.of
		List<Integer> list2 = List.of(1, 2, 3, 4);
		System.out.println("Imprimimos el valor " + list2.get(0));

		// ejemplo con el set
		// falta añadir
		// el ejemplo con el set va a dar error dado que la lista es inmutable
		// TODO

		// declaracion lista inmutable
		List<Integer> list3 = new ArrayList<>(List.of(1, 2, 3, 4));
		list3.add(1);

		// otro ejemplo de lista inmutable
		List<Integer> list4 = List.copyOf(list3);

		// EJEMPLO BOXED/UNBOXED
		Integer n = 5;// boxed (dato empaquetado)
		int n2 = n; // unboxed

		// EJEMPLO LISTA con un concurrent modification exception
		// mediante iterate (EJEMPLO PARA MAS ADELANTE
		/*
		 * List<String> nombres2 = new ArrayList<>(); nombres2.add("Cristina");// Pos 0
		 * nombres2.add("Maria");// Pos 1 nombres2.add("Megui");// Pos 2
		 * System.out.println("Impresion desde ForEach "); for (String nombre :
		 * nombres2) {
		 * 
		 * }
		 */

		AppMain ap1 = new AppMain();
		AppMain ap2 = new AppMain();
		ap1.m++;
		ap1.m2++;
		ap2.m++;
		ap2.m2++;
		System.out.println(ap1.m + " " + ap2.m + " " + ap2.m + " " + ap2.m2);
		System.out.println(ap1.m + " " + ap2.m + " " + AppMain.m2);

		// uso de isletter que es un método estático que se utiliza desde la clase
		// y no desde la instancia
		char letra = '1';
		System.out.println("Es una letra nuestro caracter?" + Character.isLetter(letra));

		Ticket t1 = new Ticket(10);
		Ticket t2 = new Ticket(12);
		Ticket t3 = new Ticket(13);
		Ticket t4 = new Ticket(18);
		System.out.println("Ticketssss :" + Ticket.count);

		// ejemplo SET (CONJUNTOS)
		// cada ejecucion de codigo, va a imprimir los nombres en un orden aleatorio al
		// no
		// tener asignada una posicion
		Set<String> namesSet = Set.of("Alejandro", "Ruben", "Angie");
		// impresion mediante una expresion lambda
		System.out.println("\nImpresion nombres Setof: ");
		namesSet.forEach(name -> System.out.print(name + " "));

		// ejemplo SET con TreeSet
		// en este caso, imprimiria en el orden natural alfabetico
		// en el caso de crear la lista de nombres con cacteres especiales
		// como numeros, arroba..etc , seguiria el orden natural que el corresponderia
		// con dichos caracteres

		// 1Miguel @Ruben Alejandro Angie Antonio
		Set<String> namesSet2 = new TreeSet<>(Set.of("Alejandro", "Ruben", "Angie", "Miguel"));
		System.out.println("\nImpresion nombres TreeSet en orden alfabetico: ");
		namesSet2.forEach(name -> System.out.print(name + " "));

		// añadimos dos nuevos nombres
		namesSet2.add("Antonio");
		// los add son boolean, si existe ya el dato es necesario poder saber si hemos
		// añadido o no el dato
		namesSet2.add("Angie");
		System.out.println("\nImpresion nombres TreeSet en orden alfabetico añadiendo nuevos elementos: ");
		namesSet2.forEach(name -> System.out.print(name + " "));

		// ejemplo contains
		System.out.println(namesSet2.contains("Alejandro"));// nos devuelve true/false si existe el nombre alejandro
		namesSet2.forEach(name -> System.out.print("\nEjemplo contains " + name + " "));

		// ejemplo removeALL , dada una lista de nombres
		List<String> nombres2 = new ArrayList<>();
		nombres2.add("Cristina");// Pos 0
		nombres2.add("Maria");// Pos 1
		nombres2.add("Megui");// Pos 2
		nombres2.add("Angie");// Pos 3
		nombres2.add("Miguel");// Pos 3

		// tenemos en nuestro conjunto:
		// "Alejandro", "Ruben", "Angie", "Miguel","Antonio"
		// Impresion de la lista que le hemos pasado al conjunto con los nombres
		System.out.print("\nvalor actual de la lista de nombres que vamos a usar para borrar " + nombres2);
		System.out.println(namesSet2.removeAll(nombres2));
		// borramos de nuestro conjunto todos los nombres que coincidan
		// con la lista de nombres que le estamos pasando , es decir, nos va a borrar
		// los nombres de Miguel y Angie
		// dado que son los 2 que coinciden en ambas listas , he imprimimos como nos
		// queda el conjunto despues
		// del borrado
		namesSet2.forEach(name -> System.out.print("\nEjemplo removeAll " + name + " "));

		// MAP -> tabla en castellano
		Map<String, Integer> students = new HashMap<>();
		// añadimos a la tabla la estudiante angie
		students.put("Angie", 42);
		// le asignamos la edad a la variable edad
		Integer edad = students.put("Angie", 42);
		// nos imprimiria 42 para angie
		System.out.println("\nLa edad de angie es:" + edad);
		students.put("Angie", 41);
		students.put("Yunior", 44);
		students.put("Jose", 55);
		students.put("Megui", 30);
		students.put("Antonio", 49);
		// nos escribiria 41 para angie(la sobreescritura)
		System.out.println("\nLa edad de angie AHORA SOBREESCRITA ES " + students.get("Angie"));
		// me dice si existe una edad en concreto
		System.out.println("Existe la edad susodicha:" + students.containsValue(55));
		// Si no existe el nombre que estamos pidiendo, nos devuelve por defecto el
		// valor que le pasamos
		System.out.println("Existe Bernardo y me devuelve su edad o la que selecciono por defecto? "
				+ students.getOrDefault("Bernardo", 1));
		// Si existe el nombre que estamos pidiendo, nos devuelve la edad de dicha
		// persona,en este caso antonio
		// tiene 49 y nos devolverá eso, aunque le estemos pasando 43 por defecto
		System.out.println("Existe Antonio y me devuelve su edad o la de que selecciono por defecto que seria 43? "
				+ students.getOrDefault("Antonio", 43));

		// en names1 , devolvemos un keyset con las claves de la tabla
		Set<String> names1 = students.keySet();
		// recorremos el keyset y devolvermos todos los nombres de la tabla
		for (String name : names1) {
			System.out.println("Mi nombre es: " + name);
		}

		// en names2 , devolvemos un keyset con las claves de la tabla
		Set<String> names2 = students.keySet();
		// recorremos el keyset y devolvemos el nombre y la edad de todos los nombres de
		// la tabla
		for (String name : names2) {
			System.out.println("Mi estudiante: " + name + " tiene de edad " + students.get(name) + " años");
		}

		// creamos una coleccion de edades de tipo integer y le asignamos todas las
		// edades de la tabla
		Collection<Integer> ages = students.values();
		// recorremos la coleccion e imprimimos todas las edades
		for (Integer age : ages) {
			System.out.println("La edad es: " + age);
		}
		
		//EJEMPLOS DE EXPRESIONES LAMBDA
		//tenemos una tabla con una lista de autores y de libros
		//Map<Author,List<Book>> books= new HashMap <>();
		System.out.println("--------------------");	
		Set<String> namesSet3 = new TreeSet<>(Set.of("Alejandro", "Ruben", "Angie", "Miguel"));
		System.out.println("Estos son los nombres de mi TreeSet");	
		namesSet3.forEach(a->System.out.println(a));
		//vamos a borrar aquellos cuyos nombres su longitud sea mayor a 5
		namesSet3.removeIf((String nam)-> nam.length()>5);
		System.out.println("He borrado a aquellos cuyos nombres tiene mas de 5 letras  me queda solo en mi tree");	
		namesSet3.forEach(a->System.out.println(a));
		//ahora podriamos borrar a aquellos cuyo nombre empieze por la letra A
		// me borraria a Angie
		System.out.println("He borrado a aquellos cuyos nombres empiezan por a me queda solo en mi tree");	
		namesSet3.removeIf((String nam)-> nam.startsWith("A"));
		namesSet3.forEach(a->System.out.println(a));
		
		//OTRO EJEMPLO DE BORRADO (CON REMOVE)
		Set<String> namesSet4 = new TreeSet<>(Set.of( "Ruben", "Angie", "Miguel","Alejandro"));
		System.out.println("Estos son los nombres de mi TreeSet de borrado con remove");	
		namesSet4.forEach(a->System.out.println(a));
		for(String name: namesSet4)
		{
			if(name.length()>12)
			{
				namesSet4.remove(name);
				System.out.println("Acabo de borrar a: "+ name);
			}
		}
		
		
		//EJEMPLO  DE BORRADO CON PREDICATE 
		Set<String> namesSet5 = new TreeSet<>(Set.of("Alejandro", "Ruben", "Angie", "Miguel"));
		System.out.println("Estos son los nombres de mi TreeSet de borrado con PREDICATE");	
		namesSet5.forEach(a->System.out.println(a));
		Predicate<String> ped= (String nam)-> nam.length()>5;
		namesSet5.removeIf(ped);
		System.out.println("Estos son los nombres de mi TreeSet de borrado con PREDICATE");
		namesSet5.forEach(a->System.out.println(a));
		
		//EJEMPLO DE CONSUMER 
		Set<String> namesSet6 = new TreeSet<>(Set.of("Alejandro", "Ruben", "Angie", "Miguel"));
		System.out.println("Estos son los nombres de mi TREE");	
		namesSet6.forEach(a->System.out.println(a));
		namesSet6.forEach(c->c.concat("cadenaconcatenada"));
		System.out.println("Estos son los nombres de mi TreeSet con una cadena concatenada");
		// ESTE EJEMPLO NO ESTA CORRECTOfalta TODO REVISAR 
		namesSet6.forEach(c->System.out.println(c));
	
		
		
		//STUDENTS ES UN MAP, ESTO ES UN EJEMPLO DE BICONSUMER CON EXPRESIONES LAMBDA
		//recorremos el map de estudiantes e imprimimos sus nombres y sus edades
		students.forEach((String name,Integer age)-> System.out.println(name +" tiene "+age + " años "));
		
		//EJEMLO DE REPLACEALL ( con unaryoperator)
		//vamos a reemplzar los nombres en nuestro arraylist pero concatenandolos 
		List<String> nombres3 = new ArrayList<>();
		nombres3.add("Cristina");// Pos 0
		nombres3.add("Maria");// Pos 1
		nombres3.add("Megui");// Posicion 2
		System.out.println("los nombres de mi array list son: ");
		nombres3.forEach(System.out::println);
		nombres3.replaceAll(s-> s.concat(s));
		System.out.println("Los nombres de mi array list sustiuidos con replaceall y concatenados son :");
		nombres3.forEach(System.out::println);
		

	}

}

// EJEMPLO USO STATIC
class Ticket {
	double price;
	static int count;

	// el constructor está obviando la variable estatica denominada count
	// dado que el constructor se utiliza para la creación del objeto
	// CADA VEZ QUE SE VENTA UN TICKET , SE AUMENTARÁ EL CONTADOR
	public Ticket(double price) {
		super();
		this.price = price;
		count++;
	}


}

class Author
{ 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
}
class Book

{ 
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}

