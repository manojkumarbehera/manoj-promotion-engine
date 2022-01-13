package com.manoj.pe;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.manoj.pe.model.Cart;
import com.manoj.pe.model.Product;
import com.manoj.pe.model.enums.ProductPriceEnum;
import com.manoj.pe.service.ProductCostCalculator;
import com.manoj.pe.service.impl.ProductCostCalculatorImpl;

public class AppTest {

	@Test
	public void test() {
		assertTrue(true);
	}
	
	/**
	 * Scenario A
	 * 
	 * 1 A = 50
	 * 1 B = 30
	 * 1 C = 20
	 */
	@Test
	public void calculateWithoutPromotionCase1() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		assertTrue(totalPrice == 100);
		
	}
	
	/**
	 * Scenario A
	 * 
	 * 1 A = 50
	 * 1 B = 30
	 * 1 D = 15
	 */
	@Test
	public void calculateWithoutPromotionCase2() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		assertTrue(totalPrice == 95);
		
	}
	
	/**
	 * Scenario A
	 * 
	 * 1 A = 50
	 * 1 B = 30
	 * 
	 */
	@Test
	public void calculateWithoutPromotionCase3() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()));
				
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		assertTrue(totalPrice == 80);
		
	}
	
	/**
	 * Scenario B.1
	 * 
	 * 5 A
	 * 5 B
	 * 1 C
	 */
	@Test
	public void calculateWithPromotionCase1() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		assertTrue(totalPrice == 370);
		
	}
	
	/**
	 * Scenario B.2
	 * 
	 * 6 A = 260
	 * 5 B = 90 + 30 = 120
	 * 1 C = 20
	 */
	@Test
	public void calculateWithPromotionCase2() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 400);
		
	}
	
	/**
	 * Scenario B.3
	 * 
	 * 6 A = 260
	 * 5 B = 90 + 30 = 120
	 * 1 D = 15
	 */
	@Test
	public void calculateWithPromotionCase3() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 395);
		
	}
	
	/**
	 * Scenario B.4
	 * 
	 * 6 A = 260
	 * 5 B = 90 + 30 = 120
	 * 2 C = 40
	 */
	@Test
	public void calculateWithPromotionCase4() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 420);
		
	}
	
	/**
	 * Scenario c.1
	 * 
	 * 3 A = 130
	 * 5 B = 90+ 30 = 120
	 * 1 C 
	 * 1 D 30
	 */
	@Test
	public void calculateWithPromotionCase5() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 280);
		
	}
	
	/**
	 * Scenario c.2
	 * 
	 * 3 A = 130
	 * 5 B = 90+ 30 = 120
	 * 2 C 
	 * 1 D 30 + 20
	 */
	@Test
	public void calculateWithPromotionCase6() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 300);
		
	}
	
	/**
	 * Scenario c.2
	 * 
	 * 3 A = 130
	 * 5 B = 90+ 30 = 120
	 * 3 C 
	 * 1 D 30 + 40
	 */
	@Test
	public void calculateWithPromotionCase7() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 320);
		
	}
	
	/**
	 * Scenario c.2
	 * 
	 * 3 A = 130
	 * 5 B = 90+ 30 = 120
	 * 5 C 
	 * 3 D 3*30 = 90,  40(2c) = 130
	 */
	@Test
	public void calculateWithPromotionCase8() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 380);
		
	}
	
	/**
	 * Scenario c.2
	 * 
	 * 3 A = 130
	 * 5 B = 90+ 30 = 120
	 * 1 C 
	 * 3 D 30 + 30
	 */
	@Test
	public void calculateWithPromotionCase9() {
		
		List<Product> products = Arrays.asList(
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.A_Product.getCode() ,ProductPriceEnum.A_Product.getName(), ProductPriceEnum.A_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.B_Product.getCode(),ProductPriceEnum.B_Product.getName(), ProductPriceEnum.B_Product.getPrice()),
				new Product(ProductPriceEnum.C_Product.getCode(),ProductPriceEnum.C_Product.getName(), ProductPriceEnum.C_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()),
				new Product(ProductPriceEnum.D_Product.getCode(),ProductPriceEnum.D_Product.getName(), ProductPriceEnum.D_Product.getPrice()));
		
		Cart cart = new Cart(products);
		
		ProductCostCalculator productCostCalculator = new ProductCostCalculatorImpl();
		Integer totalPrice = productCostCalculator.calculatePrice(cart);
		
		assertTrue(totalPrice == 310);
		
	}

};
