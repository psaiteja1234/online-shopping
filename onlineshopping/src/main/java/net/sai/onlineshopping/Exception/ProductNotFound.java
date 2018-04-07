package net.sai.onlineshopping.Exception;

import java.io.Serializable;

public class ProductNotFound extends Exception implements Serializable {

	private String message;
	public ProductNotFound()
	{
		this("product is not available");
	}
	public ProductNotFound(String message) {
		// TODO Auto-generated constructor stub
		this.message=System.currentTimeMillis()+":"+message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
