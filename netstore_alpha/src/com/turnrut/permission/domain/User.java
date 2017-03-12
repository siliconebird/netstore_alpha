package com.turnrut.permission.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nickName;
	private String userName;
	private String passWord;
	private List<Roler> rolers = new ArrayList<Roler>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<Roler> getRolers() {
		return rolers;
	}
	public void setRolers(List<Roler> rolers) {
		this.rolers = rolers;
	}
	
}
