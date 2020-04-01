/**
 * 
 */
package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Book;

/**
 * @author BNeagu
 * Created on	2020-Mar-31
 *
 */

//We provide the interface, Spring Data JPA provides the implementation

public interface BookRepository extends CrudRepository<Book, Long>  {

}
