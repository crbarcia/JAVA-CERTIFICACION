package com.activa.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {

	// atributos de tipo private - package-private
	// String name;
	// String secondName;

	// atributos de tipo public (no recomendado)
	// public String name;
	// public String secondName;

	// por defecto
	// String name;
	// String secondName;
	// LocalDate birthDate;
	// double height;
	// double weight;

	private String name;
	private String secondName;
	private LocalDate birthDate;
	private double height;
	private double weight;

	public Person() {
		// super();
	}

	public Person(String name, String secondName, LocalDate birthDate, double height, double weight) {
		// super();
		this.name = name;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.height = height;
		this.weight = weight;
	}

	// [Modificador de acceso] [Tipo de devolucion] [nombre del
	// metodo][(Parametros/Argumentos)][{return}]
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		// por defecto
		/*
		 * return "Person [name=" + name + ", secondName=" + secondName + ", birthDate="
		 * + birthDate + ", height=" + height + ", weight=" + weight + "]";
		 */
	
		return "\nname=" + name + ", \nsecondName=" + secondName + ", \nbirthDate=" + birthDate + ", \nheight=" + height
				+ ", \nweight=" + weight ;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, secondName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;

		// Ejemplo 1 y 2 de uso equals : 2 personas son iguales si tienen el mismo
		// nombre y el mismo apellido
		// return Objects.equals(name, other.name) && Objects.equals(secondName,
		// other.secondName);

		// Ejemplo 3 de uso equals : sobreescribimos el equals para que solo compare el
		// nombre de las personas y asi aunque sean personas
		// distintas pero con el mismo nombre, nos devolverá true
		return Objects.equals(this.name, other.name);
	}
	
	public void SendMessage() {
		System.out.println("Las personas no tienen porque examinarse");
	}

}
