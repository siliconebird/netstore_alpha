package com.turnrut.common;

import java.io.Serializable;

import com.turnrut.domain.Book;

public class CartItems implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String itemId;
	private  String itemName;
	//Ĭ������Ϊ1��
	private int itemQuantity = 1;
	private float itemPrice;
	private float itemTotalPrice;
	private Book book;
	//����ע��
	
	public CartItems(Book book) {
		this.book=book;
	}
	
	public String getItemId() {
		return book.getId();
	}


	public String getItemName() {
		return book.getName();
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public float getItemPrice() {
		return book.getPrice();
	}

	public float getItemTotalPrice() {
		return book.getPrice()*itemQuantity;
	}

	

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}
	
}
