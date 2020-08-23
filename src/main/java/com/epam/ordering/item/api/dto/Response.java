package com.epam.ordering.item.api.dto;

import org.springframework.http.HttpStatus;

public class Response<T> {

	T result; 

	HttpStatus status ;

	public Response() {
		super();
	}

	public Response(T result, HttpStatus status) {
		super();
		this.result = result;
		this.status = status;
	}
	public Response(HttpStatus status) {		
		this.status = status;
	}
	
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}