package app.activa.app;

import java.util.ArrayList;
import java.util.List;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("James Joyce"," Drama", "Ulises", "BMP", 12_312_523, true);
		Book b2 = new Book("Julio Cortazar", "Romantico","Rayuela" , "Planeta", 32_438_523, true);
		Book b3 = new Book("El lobo estepario", "Suspense",  "Herman Hech","McAllan", 88_123_456, false);
		Book b4 = new Book("El lobo estepario", "Suspense", "Herman Hech", "McAllan", 88_123_456, false);

		// añadimos nuestros libros a la lista
		List<Book> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);

		//TODO COMENTAR CADA CASO ESTOY CANSADA Y TENGO HAMBRE
		long countAwards = list.stream().distinct().filter(b -> b.isAwarded()).peek(b -> System.out.println(b)).count();
		
		System.out.println("---------");
		long countAwards2 = list.stream().peek(c -> System.out.println("Peek 1: " + c)).distinct()
				.peek(c -> System.out.println("Peek 2: " + c)).filter(c -> c.isAwarded())
				.peek(c -> System.out.println("Peek 3: " + c)).count();
		System.out.println("---------");
		long countAwards3 = list.stream().peek(c -> System.out.println("Peek 1: " + c)).distinct()
				.peek(c -> System.out.println("Peek 2: " + c)).filter(c -> c.isAwarded()).map(c -> {
					c.setTitle(c.getTitle().toUpperCase());
					return c;
				}).peek(c -> System.out.println("Peek 3: " + c)).count();

		System.out.println(countAwards);
		System.out.println(countAwards2);
		System.out.println(countAwards3);

	}

}

class Book {
	String author;
	String genre;
	String title;
	String editorial;
	long isbn;
	boolean isAwarded;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public boolean isAwarded() {
		return isAwarded;
	}

	public void setAwarded(boolean isAwarded) {
		this.isAwarded = isAwarded;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", genre=" + genre + ", title=" + title + ", editorial=" + editorial
				+ ", isbn=" + isbn + ", isAwarded=" + isAwarded + "]";
	}

	public Book(String author, String genre, String title, String editorial, long isbn, boolean isAwarded) {
		super();
		this.author = author;
		this.genre = genre;
		this.title = title;
		this.editorial = editorial;
		this.isbn = isbn;
		this.isAwarded = isAwarded;
	}

}
