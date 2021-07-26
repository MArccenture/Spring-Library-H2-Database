package springLibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import springLibrary.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
