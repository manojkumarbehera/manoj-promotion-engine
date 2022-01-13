package com.manoj.pe.model.enums;

public enum PromotionRuleEnum {

	THREE_A("3 0f A's", 3, 130),
	TWO_B("2 of B's", 2, 45),
	C_AND_D("C & D", 0, 30);

	private String promotionName;
	private int count;
	private Integer price;

	private PromotionRuleEnum(String promotionName, int count, Integer price) {
		this.promotionName = promotionName;
		this.count = count;
		this.price = price;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public int getCount() {
		return count;
	}

	public Integer getPrice() {
		return price;
	}

}
