package com.turnrut.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	//���ݿ�id
	private String orderId;
	//����id
	private String orderNum;
	//��������
	private int quantity;
	//�����ܼ�
	private float amount;
	//����״̬ 0δ����,1�Ѹ���,2�ѷ���
	private int status;
	//���������ͻ� ��������ͻ����ڶ��һ ���ÿ�������ж�Ӧ���һ���ͻ�����
	private Customer customer;
	//�����������ж�����
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
