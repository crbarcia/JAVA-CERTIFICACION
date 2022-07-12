package com.activa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public  class Teacher extends Person implements Adult{
	private double salary;
	private Course[] courses;//asignaturas del profesor 

	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*public Teacher(String name, String secondName, LocalDate birthDate, double height, double weight) {
		super(name, secondName, birthDate, height, weight);
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(double salary, Course[] courses) {
		super();
		this.salary = salary;
		this.courses = courses;
	} */
	
	public Teacher(String name, String secondName, LocalDate birthDate, double height, double weight,double salary, Course[] courses) {
		super(name, secondName, birthDate, height, weight);
		// TODO Auto-generated constructor stub
		this.salary = salary;
		this.courses = courses;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher [salary=" + salary + ", courses=" + Arrays.toString(courses) + "]";
	}

	@Override
	public double calculateRent(double salary, double irpf) {
		this.salary=salary;
		return irpf*100/ this.salary;
	}

	@Override
	public double calculateRentTax(BigDecimal irpf, BigDecimal taxes) {
		
		return calculateRentTax(irpf, irpf.multiply(BigDecimal.valueOf(TAX)));
	}

}
