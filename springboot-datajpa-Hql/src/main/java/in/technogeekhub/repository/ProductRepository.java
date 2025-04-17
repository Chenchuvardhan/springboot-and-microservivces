package in.technogeekhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.technogeekhub.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
