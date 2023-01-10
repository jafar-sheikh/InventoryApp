package com.exam.spring.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.spring.category.Category;
import com.exam.spring.category.CategoryRepository;

@Controller
public class BrandController {
 @Autowired
 private BrandRepository brandRepo;
 @Autowired
 private CategoryRepository categoryRepo;
 
 @GetMapping("/brands/new")
 public String showCreateNewBrandForm(Model model) {
	 List<Category> listcategories = categoryRepo.findAll();
	 model.addAttribute("brand" , new Brand());
	 model.addAttribute("listcategories" ,listcategories);
	 return "brand_form";
 }
 @PostMapping("/brands/save")
 public String saveBrand(Brand brand) {
	 brandRepo.save(brand);
	 return "redirect:/";
 }
 
 @GetMapping("/brands")
 public String listBrands(Model model) {
	 List<Brand> listBrands = brandRepo.findAll();
	 model.addAttribute("listBrands" , listBrands);
	 return "brands";
 }
 
}
