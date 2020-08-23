package com.epam.ordering.item.api.error;

public class OrderNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6421804441416294982L;

	public OrderNotFound(String message) {
		super(message);

	}

}
