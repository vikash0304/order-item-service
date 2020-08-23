package com.epam.ordering.item.api;

public enum Constants {

	INVALID_INPUT("Invalid Input"),
	INVALID_QUANTITY("Invalid quantity");
	
	private String code;

	private Constants(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
