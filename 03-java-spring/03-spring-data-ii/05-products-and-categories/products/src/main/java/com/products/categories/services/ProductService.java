package com.products.categories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.categories.models.Category;
import com.products.categories.models.Product;
import com.products.categories.repositories.CategoryRepository;
import com.products.categories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;
	
	
	
	 // Retrieves a list of any categories a particular product
    // does not belong to.
	public List<Product> ProductNotCategory(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	public List<Product>  ProductsInCategory(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}
	//create a new product
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//retrieve a product
	public Product getOne(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//make category  to a product
	public void productAddtoCategory(Product product, Category cate) {		
		List<Category> cates = product.getCategories();		
		cates.add(cate);
		this.pRepo.save(product);

	}
	//add product to category
	public void  cateGoesToProduct(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.add(product);
		this.cRepo.save(category);
	}
	
	
}
