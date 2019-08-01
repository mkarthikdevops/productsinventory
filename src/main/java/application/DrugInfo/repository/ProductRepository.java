package application.DrugInfo.repository;

import org.springframework.data.repository.CrudRepository;

import application.DrugInfo.entity.Product;



public interface ProductRepository extends CrudRepository<Product, Integer> {

	Iterable<Product> findAll();

	Product findById(Integer id);

	void deleteById(Integer id);
}
