package com.exam.spring.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.exam.spring.category.Category;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=128, nullable = false ,unique = true)
	private String name;
	private float price;
	@ManyToOne
	@JoinColumn(name ="category_id")
	private Category category;
	
	
	
//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
//	}
//	public Product(Integer id, String name, float price, Category category) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.category = category;
//	}
//	public Product() {
//		super();
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
