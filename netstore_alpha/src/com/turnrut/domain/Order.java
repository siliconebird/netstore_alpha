package com.turnrut.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	//数据库id
	private String orderId;
	//订单id
	private String orderNum;
	//订单数量
	private int quantity;
	//订单总价
	private float amount;
	//订单状态 0未付款,1已付款,2已发货
	private int status;
	//订单所属客户 订单对与客户属于多对一 因此每个订单中都应标记一个客户属性
	private Customer customer;
	//所包含的所有订单项
	List<OderItem> oItems = new ArrayList<OderItem>();
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OderItem> getoItems() {
		return oItems;
	}
	public void setoItems(List<OderItem> oItems) {
		this.oItems = oItems;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
		
}
