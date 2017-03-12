package com.turnrut.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String cusName;
	private String cusPw;
	private String phone;
	private String address;
	private String email;
	
	private boolean activied;
	private String keyCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusPw() {
		return cusPw;
	}
	public void setCusPw(String cusPw) {
		this.cusPw = cusPw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActivied() {
		return activied;
	}
	public void setActivied(boolean activied) {
		this.activied = activied;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public Customer(String id, String cusName, String cusPw, String phone, String address, String email,
			boolean activied, String keyCode) {
		super();
		this.id = id;
		this.cusName = cusName;
		this.cusPw = cusPw;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.activied = activied;
		this.keyCode = keyCode;
	}
	
	public Customer() {}
	
	
	
}
