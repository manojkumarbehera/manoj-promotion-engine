package com.manoj.pe.model;

import java.util.List;

public class Cart {

	private List<Product> products;

	public Cart(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
