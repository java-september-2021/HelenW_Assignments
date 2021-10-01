package com.products.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.categories.models.Category;
import com.products.categories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category>  findAll();
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);

}
	
