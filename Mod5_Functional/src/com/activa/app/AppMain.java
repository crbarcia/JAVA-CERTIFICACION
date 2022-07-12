package com.activa.app;

import com.activa.utils.Cat;
import com.activa.utils.Dog;
import com.activa.utils.Inter1;
import com.activa.utils.Inter2;

public class AppMain {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Cat cat = new Cat();
		// cat.print();
		// voy a llamar al metodo de impresion de la interfaz funcional pasandole
		// un gatito miau (polimorfia, como gato implementa inter1 , le puedo pasar al
		// gato)
		printCat(cat);

		// metodo de impresion mediante expresiones lambda (ejemplo 1)
		// printCat((->{));

		// otro metodo de impresion mediante expresiones lambda (ejemplo 2)
		printCat(() -> System.out.println("Guauuu"));

		// ejemplo 1
		Dog dog = () -> "Guau";
		// ejemplo 2
		Dog dog2 = () -> {
			return "Guau";
		};
		//IMPRMIMOS GUAU
		System.out.println(dog.printS());
			
		//TODO LE PASAMOS 2 PARAMETROS E IMPRMIMOS LA PALABRA GUAU TANTAS VECES
		//COMO EL NUMERO QUE LE DIGAMOS
		/*Dog dog3 = (boolean b, int num) -> {
			String guau = "Guau";
			if (b) {
				guau = guau.repeat(num);
			}
			return guau;

		};
		
		System.out.println(dog3.printS(true,5));
		*/
		
		//creamos una segunda interfaz a la que le pasamos el tipo de animal y el sonido 
		Inter2 in= (tipo,sound) -> System.out.println(tipo+ "Meow"+ sound);
		//procedemos a la impresion 
		printCatparametros(in);
		
	}

	// le voy a pedir como parametro la interfaz funcional
	public static void printCat(Inter1 in) {
		in.print();
	}

	// TODO VA EN LA SEGUNDA INTERFAZ denominada Inter2
	  public static void printCatparametros(Inter2 in) {
	  in.print("Gato:","marramiau"); }
	 

	// en lugar de pasarle los datos , le pasamos la implementacion, por eso la
	// interfaz funcional solo
	// puede tener un metodo abstracto, dado que el compilador no sabria donde
	// deberia aplicar esa logica que
	// estamos creando
	// lo haremos mediante expresiones lambda, clases anonimas y

}
