package springLibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import springLibrary.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
