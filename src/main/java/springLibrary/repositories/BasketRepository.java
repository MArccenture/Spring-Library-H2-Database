package springLibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import springLibrary.domain.Basket;

public interface BasketRepository extends CrudRepository<Basket, Long> {
}
