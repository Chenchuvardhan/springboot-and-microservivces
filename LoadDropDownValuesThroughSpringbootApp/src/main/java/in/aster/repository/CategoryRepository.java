package in.aster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aster.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
