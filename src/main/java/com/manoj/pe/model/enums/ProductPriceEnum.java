package com.manoj.pe.model.enums;

public enum ProductPriceEnum {

	A_Product("a", "A", 50),
	B_Product("b", "B", 30),
	C_Product("c", "C", 20),
	D_Product("d", "D", 15);

	private String code;
	private String name;
	private Integer price;

	ProductPriceEnum(String code, String name, Integer price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return this.price;
	}

}
