package com.turnrut.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.turnrut.domain.Book;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���ﳵ���鼮�ܼ�
	private int totalQuantity;
	//���ﳵ�������鼮�ܼ�
	private float amount;
	//���ﳵ�������鼮��Ϣ
	Map<String, CartItems> cart = new HashMap<String, CartItems>();
	
	//���ﳵ������鼮����
	public void addItem(Book book){
		String id = book.getId();
		if(cart.containsKey(id)){
			CartItems item = cart.get(id);
			item.setItemQuantity(item.getItemQuantity()+1);
		}else{
			CartItems item = new CartItems(book);
			cart.put(book.getId(), item);
		}
	}
	
	public int getTotalQuantity() {
		totalQuantity = 0;
		for(Map.Entry<String, CartItems> entry:cart.entrySet()){
			totalQuantity+=entry.getValue().getItemQuantity();
		}
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	public float getAmount() {
		amount = 0f;
		for(Map.Entry<String, CartItems> entry:cart.entrySet()){
			amount+=entry.getValue().getItemTotalPrice();
		}
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Map<String, CartItems> getCart() {
		return cart;
	}
	public void setCart(Map<String, CartItems> cart) {
		this.cart = cart;
	}
	
}
