package com.activa.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.activa.model.Course;
import com.activa.model.Person;
import com.activa.model.Student;
import com.activa.model.Subjects;
import com.activa.model.Teacher;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//TODO ESTO SON EJEMPLOS ANTES DE QUE LA CLASE PERSONA FUERA ABSTRACTA, AHORA AL SER ABSTRACTA 
		//YA NO PODEMOS REALIZAR INSTANCIAS DE PERSONA 
		//SE COMENTA ESTE CODIGO ,SI SE QUIERE VOLVER A PROBAR, QUITARLE LA ABSTRACCION A LA 
		//CLASE PERSONA
		
	 /*	Person p1 = new Person("Cristina", "Rodriguez", LocalDate.parse("1985-07-01"), 1.65, 68);
		System.out.println("Nombre:" + p1.getName() + "\nApellido:" + p1.getSecondName() + "\nFecha de Nacimiento:"
				+ p1.getBirthDate() + "\nAltura:" + p1.getHeight() + "\nPeso:" + p1.getWeight());

	
		Person p2 = new Person("Lola", "Vazquez", LocalDate.now(), 1.70, 75);
		System.out.println("\nNombre:" + p2.getName() + "\nApellido:" + p2.getSecondName() + "\nFecha de Nacimiento:"
				+ p2.getBirthDate() + "\nAltura:" + p2.getHeight() + "\nPeso:" + p2.getWeight());

		
		Person p3 = new Person();
		p3.setName("Marta");
		p3.setSecondName("Vazquez");
		p3.setBirthDate(LocalDate.parse("1985-07-01"));
		p3.setHeight(1.65);
		p3.setWeight(70);

	
		Person p4 = new Person("Lola", "Vazquez", LocalDate.now(), 1.70, 75);
		System.out.println("\nNombre:" + p4.getName() + "\nApellido:" + p4.getSecondName() + "\nFecha de Nacimiento:"
				+ p4.getBirthDate() + "\nAltura:" + p4.getHeight() + "\nPeso:" + p4.getWeight());

		System.out.println("\nNombre:" + p3.getName() + "\nApellido:" + p3.getSecondName() + "\nFecha de Nacimiento:"
				+ p3.getBirthDate() + "\nAltura:" + p3.getHeight() + "\nPeso:" + p3.getWeight());

		
		Person p5 = new Person("Lola", "Boiro", LocalDate.now(), 1.70, 75);
		System.out.println("\nNombre:" + p5.getName() + "\nApellido:" + p5.getSecondName() + "\nFecha de Nacimiento:"
				+ p5.getBirthDate() + "\nAltura:" + p5.getHeight() + "\nPeso:" + p5.getWeight());

		// imprimimos los datos de la persona5 con la sobreescritura del metodo toString
		System.out.println(p5);
		

		// Ejemplo 1 uso de equals (personas iguales)
		boolean sonIguales = p2.equals(p4);
		System.out.print("\nEs la persona 2 igual que la persona 4 (mismos datos): " + sonIguales);

		// Ejemplo 2 uso de equals (personas diferentes)
		boolean sonDistintos = p1.equals(p4);
		System.out.print("\nEs la persona 1 igual que la persona 4 (mismos datos): " + sonDistintos);

		// Ejemplo3 uso de equals (personas diferentes pero con mismo nombre cambiando
		// la sobreescritura del metodo)
		boolean sonDistintosPeroMismoNombre = p2.equals(p5);
		System.out.print("\nEs la persona 2 con el mismo nombre que la persona 5 (pero otros datos): "
				+ sonDistintosPeroMismoNombre);
		// --------------------------------------------------------------------------------------------

        */
		// Nuevo estudiante
		Student stud1 = new Student("Cris", "Rodriguez", LocalDate.parse("1985-07-01"), 1.65, 68, 5, true);

		System.out.println(stud1);

		// todas las asignaturas
		Course[] courseArr = new Course[] { new Course("Mates", 0), new Course("Fisica", 0),
				new Course("Historia", 0) };

		// Nuevo profesor
		Teacher teach1 = new Teacher(null, null, null, 0, 0, 0, courseArr);
		System.out.println(teach1);

		// POLIMORFIA
		// vamos a crear 2 personas, un estudiante y un profesor
		// tenemos el metodo sendMessage en la clase estudiantes y en la clase persona

		Person pestudiante = new Student("Paca", "Rodriguez", LocalDate.parse("1985-07-01"), 1.65, 68, 5, true);
		Person pprofesor = new Teacher();
		// que mensaje sacaria este metodo??
		// ¿el mensaje del metodo de la clase persona o el metodo de la clase
		// estudiante?
		// cogeria el mensaje del metodo de la clase estudiante y no de la clase persona
		pestudiante.SendMessage();
		// que mensaje sacaria este metodo??
		// cogeria el mensaje del metodo de la clase persona dado que no existe dicho
		// metodo en la clase profesor
		pprofesor.SendMessage();

		// gracias a la polimorfia, un estudiante pasa a ser un profesor y no va a dar
		// un error
		pestudiante = pprofesor;

		// pprofesor es un profesor?
		if (pprofesor instanceof Teacher) {
			System.out.println("Yes, es un profesor");
		} else {
			System.out.println("No, es un alumno");
		}

		// estudiante es un profesor?
		if (pestudiante instanceof Teacher) {
			System.out.println("Yes, es un profesor");
		} else {
			System.out.println("No, es un alumno");
		}

		// EJEMPLO DE ENUM
		
		
	
		//creamos un arraylist con todas las asignaturas
		List<Subjects> subjects= new ArrayList <>();	
		
		// CREAMOS UN NUEVO ESTUDIANTE AÑADIENDOLE EL ENUMERADO CON LAS ASIGNATURAS QUE
		// TIENE EL ALUMNO (con un array de asignaturas)
		//Student studEnum = new Student("Marta", "Rodriguez", LocalDate.parse("1985-07-01"), 1.65, 68, 5, true,
		//		new Subjects[] { Subjects.MATEMATICAS, Subjects.QUIMICA });
		
		/*Student studEnum2 = new Student("Mala", "Rodriguez", LocalDate.parse("1985-07-01"), 1.65, 68, 5, true,
				  );*/
		
		
		//con una lista de asignaturas
		for(Subjects value : Subjects.values())// el metodo estatico values() de enum devuelve un 
			//array con las constantes 
		{
			if(value.isOptionals())
			{
				subjects.add(value);
			}
		}
		

		/*for (Subjects sub : studEnum.getSubjects()) {

			
			 // MATEMATICAS, HISTORIA, FISICA, QUIMICA, LENGUA, GEOGRAFIA;
		
			switch (sub) {

			case MATEMATICAS:
				System.out.println("El alumno está matriculado en:" + sub.name()+ " Posicion dentro del array: "+sub.ordinal());
				break;

			case HISTORIA:
				System.out.println("El alumno está matriculado en:" + sub.name());
				break;

			case FISICA:
				System.out.println("El alumno está matriculado en:" + sub.name());
				break;
			case QUIMICA:
				System.out.println("El alumno está matriculado en:" + sub.name());
				break;
			case LENGUA:
				System.out.println("El alumno está matriculado en:" + sub.name());
				break;

			case GEOGRAFIA:
				System.out.println("El alumno está matriculado en:" + sub.name());
				break;
			default:

			} 

		} */
		
		//vamos a imprimir el salario de un profesor  (EL PROFESOR INSTANCIADO DENOMINADO
		//TEACH1, del profesor que tenemos definido denominado teach1
		//calculamos la renta del profesor,pasadole el salario que tiene y teniendo en cuenta los impuestos
		System.out.println("El salario del profesor aplicandole los impuestos es:"+ teach1.calculateRent(teach1.getSalary(), 20.5));
		//vamos a imprimir 
		System.out.println("El salario del profesor es:"+ teach1.calculateRentTax(new BigDecimal(20),new BigDecimal(16)));

	};

}
