package com.activa.model;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {

	private double assesment;
	private boolean isPass;
	// private Subjects [] subjects;
	//creamos una lista de asignaturas en lugar de un array
	private List<String> subjects;

	/*
	 * public Student(double assesment, boolean isPass) { this.assesment =
	 * assesment; this.isPass = isPass; }
	 * 
	 * public Student(String name, String secondName, LocalDate birthDate, double
	 * height, double weight) { //super hace referencia a la clase padre , this hace
	 * referencia a la propia clase super(name, secondName, birthDate, height,
	 * weight); }
	 */

	// este constructor llama al constructor de la clase padre persona
	/*
	 * public Student() { this
	 * ("cris","rodriguez",LocalDate.parse("1985-07-01"),1.65,68); }
	 */

	public Student(String name, String secondName, LocalDate birthDate, double height, double weight, double assesment,
			boolean isPass) {
		// super hace referencia a la clase padre , this hace referencia a la propia
		// clase
		// si hacer ctrl + click encima de super, te lleva a la clase padre
		super(name, secondName, birthDate, height, weight);
		this.assesment = assesment;
		this.isPass = isPass;
	}

	/*
	 * public Subjects[] getSubjects() { return subjects; }
	 * 
	 * public void setSubjects(Subjects[] subjects) { this.subjects = subjects; }
	 */

	/*
	 * public Student(String name, String secondName, LocalDate birthDate, double
	 * height, double weight, double assesment, boolean isPass, Subjects[] subjects)
	 * { // super hace referencia a la clase padre , this hace referencia a la
	 * propia // clase // si hacer ctrl + click encima de super, te lleva a la clase
	 * padre super(name, secondName, birthDate, height, weight); this.assesment =
	 * assesment; this.isPass = isPass; this.subjects = subjects; }
	 */

	public Student(String name, String secondName, LocalDate birthDate, double height, double weight, double assesment,
			boolean isPass, List<String> subjects) {
// super hace referencia a la clase padre , this hace referencia a la propia
// clase
// si hacer ctrl + click encima de super, te lleva a la clase padre
		super(name, secondName, birthDate, height, weight);
		this.assesment = assesment;
		this.isPass = isPass;
		this.subjects = subjects;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Student() {
		// esto llama al constructor de la superclase , está de forma implicita
		super();

	}

	public double getAssesment() {
		return assesment;
	}

	public void setAssesment(double assesment) {
		this.assesment = assesment;
	}

	public boolean isPass() {
		return isPass;
	}

	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

	@Override
	public String toString() {
		// return "Student [assesment=" + assesment + ", isPass=" + isPass + "]";
		// return "\nassesment=" + assesment + ", \nisPass=" + isPass ;
		// nos devolveria todos los datos de la clase padre persona, y se los
		// añadiriamos a la
		// clase estudiante
		return super.toString() + "\nassesment=" + assesment + ", \nisPass=" + isPass;
	}

	public void SendMessage() {
		if (isPass) {
			System.out.println("El alumno: " + super.getName() + " ha aprobado");
		} else {
			System.out.println("El alumno: " + super.getName() + " ha suspendido");
		}
	}

}
