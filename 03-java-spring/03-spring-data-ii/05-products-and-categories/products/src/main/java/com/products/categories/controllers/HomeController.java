package com.products.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.products.categories.models.Category;
import com.products.categories.models.Product;
import com.products.categories.services.CategoryService;
import com.products.categories.services.ProductService;

@Controller
public class HomeController {
		@Autowired
		private ProductService pService;
		@Autowired
		private CategoryService cService;
		
		@GetMapping("")
		public String welcome() {
			return "welcome.jsp";
		}
		
		//display create new product page
		@GetMapping("/products/new")
		public String addProduct(@ModelAttribute("product") Product product) {
			return "addProduct.jsp";
		}
		//create new product
		@PostMapping("/products/create")
		public String createProduct(@ModelAttribute("product") Product product, Model viewModel) {

			
			this.pService.createProduct(product);
			return "redirect:/products/"+product.getId();
		}
		
		@PostMapping("/productBelongCate/{id}")
		public String addProudctToCate(@PathVariable("id") Long id,@RequestParam("cateId") Long cateId) {
			Product thisProduct = pService.getOne(id);
			Category thisCate = cService.getOne(cateId);
			this.pService.productAddtoCategory(thisProduct, thisCate);
			return "redirect:/products/"+id;
			
		}
		//display one product
		@GetMapping("/products/{id}")
		public String displayProduct(@PathVariable("id") Long id, Model viewModel) {
			viewModel.addAttribute("oneproduct", this.pService.getOne(id));
			viewModel.addAttribute("categoriesWithoutProduct", cService.catesWithoutProduct(this.pService.getOne(id)));
			viewModel.addAttribute("categoriesWithProduct", pService.getOne(id).getCategories());
			return "showproduct.jsp";
		}
		
		////////////////
		///categories////
		///////////////
		@GetMapping("/categories/new")
		public String addCategory(@ModelAttribute("category") Category category) {
			return "addCategory.jsp";
		}
		//create new product
		@PostMapping("/categories/create")
		public String createCategory(@ModelAttribute("category") Category category) {
			this.cService.createCategory(category);
			return "redirect:/categories/"+category.getId();
		}
		//display one category
		@GetMapping("/categories/{id}")
		public String displayCategory(@PathVariable("id") Long id, Model viewModel) {
			viewModel.addAttribute("onecategory", this.cService.getOne(id));
			viewModel.addAttribute("productsOutCate",pService.ProductNotCategory(cService.getOne(id)));
			viewModel.addAttribute("productsInCate", this.cService.getOne(id).getProducts());
			return "showcategory.jsp";
		}
		
		@PostMapping("/categoryHasProduct/{cateId}")
		public String addProductToCatetory(@PathVariable("cateId") Long cateId, @RequestParam("productId") Long productId) {
			Category theCate = cService.getOne(cateId);
			Product theProduct = pService.getOne(productId);
			this.pService.cateGoesToProduct(theProduct, theCate);
			return "redirect:/categories/"+cateId;
		}
		

}
