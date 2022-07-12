package com.activa.model;

import java.math.BigDecimal;

public interface Adult {

	// de forma implicita es public,static y final (lo añadimos de manera visual, no
	// seria necesario
	public static final double TAX = 4.6;

	// de forma implicita es public abstract por defecto, no es necesario
	// declararlo, va implicito
	double calculateRent(double salary, double irpf);

	double calculateRentTax(BigDecimal irpf, BigDecimal taxes);

	private static double calculateTax(double n) {

		return TAX * 0.10;
	}

	// quiero utilizar este metodo private calculateTax en un metodo denominado show
	// quiero imprimir el 10% del impuesto calculado con calculateTax
	// private static double calculateTax (double n)
	// no lo permite dado que desde un metodo estatico solo puedes llamar a otro
	// estatico
	// a no ser que sea desde una instancia , y el interfaz adulto no tenemos la
	// posibilidad de
	// hacer una instancia
	// por lo que cambiamos el metodo para que sea estatico
	// private static double calculateTax (double n)

	public static void ShowTax() {
		calculateTax(20);
	}

	// uso el mismo metodo
	// quiero añadir al IRPF
	// las reglas para la sobrecarga de metodos es tener distinto tipo y/o numero de
	// argumentos
	// de esa forma pueden convivir dos o mas metodos con el mismo nombre
	default double calculateRentTax(BigDecimal irpf) {
		return calculateRentTax(irpf, irpf.multiply(BigDecimal.valueOf(TAX)));
	}

}
