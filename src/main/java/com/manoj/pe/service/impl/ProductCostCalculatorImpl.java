package com.manoj.pe.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.manoj.pe.model.Cart;
import com.manoj.pe.model.Product;
import com.manoj.pe.model.enums.ProductPriceEnum;
import com.manoj.pe.model.enums.PromotionRuleEnum;
import com.manoj.pe.service.ProductCostCalculator;

public class ProductCostCalculatorImpl implements ProductCostCalculator {

	private static final String PRODUCT_A_CODE = "a";
	private static final String PRODUCT_B_CODE = "b";
	private static final String PRODUCT_C_CODE = "c";
	private static final String PRODUCT_D_CODE = "d";

	@Override
	public Integer calculatePrice(Cart cart) {

		Map<Product, Integer> productsCountMap = convertCartToProductsCountMap(cart);

		int totalPrice = calculatePrice(productsCountMap);
		System.out.println("Final total price is :" + totalPrice);
		return totalPrice;
	}

	private int calculatePrice(Map<Product, Integer> productsCountMap) {

		int totalPrice = 0;

		int asPromotionPrice = 0;
		int bsPromotionPrice = 0;
		int csPrice = 0;
		int dsPrice = 0;
		int cdProductCPrice = 0;

		Iterator<Entry<Product, Integer>> productsCountMapItr = productsCountMap.entrySet().iterator();

		while (productsCountMapItr.hasNext()) {

			Entry<Product, Integer> eachEntry = productsCountMapItr.next();
			Product product = eachEntry.getKey();
			Integer productsCount = eachEntry.getValue();

			switch (product.getCode()) {
			case PRODUCT_A_CODE:
				asPromotionPrice = calculateAsPromotionPrice(productsCount);
				productsCountMapItr.remove();
				break;
			case PRODUCT_B_CODE:
				bsPromotionPrice = calculateBsPromotionPrice(productsCount);
				productsCountMapItr.remove();
				break;
			default:
				break;
			}
		}

		System.out.println(
				"After A and B remaining products: " + productsCountMap + " and size is " + productsCountMap.size());

		if (productsCountMap.size() == 1) {
			Integer cProductsCount = productsCountMap.get(new Product(PRODUCT_C_CODE));
			Integer dProductsCount = productsCountMap.get(new Product(PRODUCT_D_CODE));
			if (cProductsCount != null) {
				csPrice = ProductPriceEnum.C_Product.getPrice() * cProductsCount;
			} else if (dProductsCount != null) {
				dsPrice = ProductPriceEnum.D_Product.getPrice() * dProductsCount;
			}
		} else if (productsCountMap.size() > 1) {
			Integer cProductsCount = productsCountMap.get(new Product(PRODUCT_C_CODE));
			Integer dProductsCount = productsCountMap.get(new Product(PRODUCT_D_CODE));
			if (cProductsCount == dProductsCount) {
				cdProductCPrice = cProductsCount * PromotionRuleEnum.C_AND_D.getPrice();
			} else if (cProductsCount > dProductsCount) {
				cdProductCPrice = dProductsCount * PromotionRuleEnum.C_AND_D.getPrice();
				int extraCPrice = (cProductsCount - dProductsCount) * ProductPriceEnum.C_Product.getPrice();
				cdProductCPrice = cdProductCPrice + extraCPrice;
			} else if (dProductsCount > cProductsCount) {
				cdProductCPrice = cProductsCount * PromotionRuleEnum.C_AND_D.getPrice();
				int extraDPrice = (dProductsCount - cProductsCount) * ProductPriceEnum.D_Product.getPrice();
				cdProductCPrice = cdProductCPrice + extraDPrice;
			}
		}

		totalPrice = asPromotionPrice + bsPromotionPrice + csPrice + dsPrice + cdProductCPrice;

		return totalPrice;

	}

	private int calculateAsPromotionPrice(Integer productsCount) {

		int quotient = productsCount / PromotionRuleEnum.THREE_A.getCount();
		int remainder = productsCount % PromotionRuleEnum.THREE_A.getCount();

		int promotionPrice = PromotionRuleEnum.THREE_A.getPrice() * quotient;
		int normalPrice = ProductPriceEnum.A_Product.getPrice() * remainder;

		return promotionPrice + normalPrice;

	}

	private int calculateBsPromotionPrice(Integer productsCount) {

		int quotient = productsCount / PromotionRuleEnum.TWO_B.getCount();
		int remainder = productsCount % PromotionRuleEnum.TWO_B.getCount();

		int promotionPrice = PromotionRuleEnum.TWO_B.getPrice() * quotient;
		int normalPrice = ProductPriceEnum.B_Product.getPrice() * remainder;

		return promotionPrice + normalPrice;

	}

	private Map<Product, Integer> convertCartToProductsCountMap(Cart cart) {

		Map<Product, Integer> productsCountMap = new HashMap<>();

		List<Product> products = cart.getProducts();

		for (Product eachProduct : products) {

			Integer count = productsCountMap.get(eachProduct);
			if (count == null) {
				productsCountMap.put(eachProduct, 1);
			} else {
				productsCountMap.put(eachProduct, count + 1);
			}
		}

		return productsCountMap;
	}

}
