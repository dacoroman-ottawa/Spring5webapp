/**
 * 
 */
package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;


/**
 * @author BNeagu
 * Created on	2020-Mar-31
 *
 */

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book ("Domain Driven Design", "ABC123456");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);	
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book ("J2EE Development without EJB", "ABC123123");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);	
		
		Publisher pinguin = new Publisher("Pinguin Books", "123 Main", "New York", "NY", "USA", "678901-1234");
		publisherRepository.save(pinguin);
		
		ddd.setPublisher(pinguin);
		noEJB.setPublisher(pinguin);
			
		pinguin.getBooks().add(ddd);
		pinguin.getBooks().add(noEJB);
		
		bookRepository.save(ddd);		
		bookRepository.save(noEJB);		
		publisherRepository.save(pinguin);
		
		
		System.out.println("Started in BootStrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
		
		System.out.println("Publisher " + pinguin.getName() + " has " + pinguin.getBooks().size() + " books.");
		
	}
	
	

}
