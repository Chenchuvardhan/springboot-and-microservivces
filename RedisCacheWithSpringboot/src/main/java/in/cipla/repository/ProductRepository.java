package in.cipla.repository;

import org.springframework.data.repository.CrudRepository;

import in.cipla.entity.Product;
	
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
