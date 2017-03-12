package com.turnrut.domain;

import java.io.Serializable;

public class OderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	//订单项id
	private String orderItemId;
	//项目数量
	private int quantity;
	//项目价格小计
	private float price;
	//项目中的书
	private Book book;

	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float f) {
		this.price = f;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
