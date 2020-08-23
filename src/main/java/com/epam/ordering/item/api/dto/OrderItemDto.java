package com.epam.ordering.item.api.dto;

public class OrderItemDto {

	private String productCode;
	private String productName;
	private Integer Quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemDto [productCode=" + productCode + ", productName=" + productName + ", Quantity=" + Quantity
				+ "]";
	}
	
}
