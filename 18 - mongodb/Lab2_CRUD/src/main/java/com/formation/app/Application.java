package com.formation.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.formation.entity.Book;
import com.formation.repository.BookRepository;

@SpringBootApplication
@EnableMongoRepositories("com.formation.repository")
public class Application implements CommandLineRunner {

	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	public void run(String... args) throws Exception {

		repository.deleteAll();
		System.out.println("Collection deleted");
		repository.save(new Book("un novueau livre sur les lapins", "moi", "novel", 10));
		repository.save(new Book("un novueau livre sur les brebis", "moi", "thriller", 12));
		repository.save(new Book("un novueau livre sur les chèvres", "moi","Motivational", 6));
		repository.save(new Book("un novueau livre sur les moutons", "moi","sexual", 8));
		
		System.out.println("Book found with findAll() : ");
		System.out.println("----------------------------");

		for ( Book bstore : repository.findAll())
		{
			System.out.println(bstore);
		}
		
		Book book1 = repository.findByTitle("un novueau livre sur les lapins");
		book1.setPrice(10000);
		// Update book
		repository.save(book1);
		
		book1 = repository.findByTitle("un novueau livre sur les lapins");
		
		System.out.println(book1);

		repository.delete(book1);
		
		System.out.println("Book found for findByType('sexual') :");
		System.out.println("----------------------------");
		
		for (Book book : repository.findByType("sexual"))
		{
			System.out.println(book);
		}
		
	}

}
