package com.turnrut.domain;

import java.io.Serializable;

public class OderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	//������id
	private String orderItemId;
	//��Ŀ����
	private int quantity;
	//��Ŀ�۸�С��
	private float price;
	//��Ŀ�е���
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
