package in.hetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hetero.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
