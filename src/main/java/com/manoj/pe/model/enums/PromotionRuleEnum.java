package com.manoj.pe.model.enums;

public enum PromotionRuleEnum {

	THREE_A("3 0f A's", 130),
	TWO_B("2 of B's", 45),
	C_AND_D("C & D", 30);

	private String promotionName;
	private Integer price;

	private PromotionRuleEnum(String promotionName, Integer price) {
		this.promotionName = promotionName;
		this.price = price;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public Integer getPrice() {
		return price;
	}

}
