package com.exam.spring.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.spring.category.Category;
import com.exam.spring.category.CategoryRepository;

@Controller
public class ProdectController {
	
	@Autowired
	private ProductRepository productrepo;
	@Autowired
	private CategoryRepository categoryrepo;
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listcategories = categoryrepo.findAll();
		model.addAttribute("product" , new Product());
		model.addAttribute("listcategories" , listcategories);
		
		return "product_form";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(Product product) {
		productrepo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Product> listProducts = productrepo.findAll();
		model.addAttribute("listProducts" ,listProducts );
		return "products";
	}
	
	@GetMapping("products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
		Product product = productrepo.findById(id).get();
		model.addAttribute("product" , product);
		List<Category> listcategories = categoryrepo.findAll();
		model.addAttribute("listcategories" , listcategories);
		
		return "product_form";
	}
	
	@GetMapping("products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		productrepo.deleteById(id);
		return "redirect:/products";
	}
	

}
