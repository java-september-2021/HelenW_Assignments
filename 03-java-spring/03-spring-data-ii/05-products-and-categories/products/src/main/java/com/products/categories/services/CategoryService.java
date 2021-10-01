package com.products.categories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.categories.models.Category;
import com.products.categories.models.Product;
import com.products.categories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	//find all products;
//	public List<Category> allCategories() {
//		return this.cRepo.findAll();
//	}
	
	 // Retrieves a list of any categories a particular product
    // does not belong to.
	public List<Category> catesWithoutProduct(Product product) {
		return this.cRepo.findByProductsNotContains(product);
	}
	
//	public List<Category> categoriesWithProduct(Product product) {
//		return this.cRepo.findAllByProducts(product);
//	}
	
	//create a new category
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	//retrieve a product
	public Category getOne(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	

	
}


