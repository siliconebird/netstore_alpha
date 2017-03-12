package com.turnrut.permission.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Roler implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String rolerName;
	private String rolerDescripe;
	List<Function> funcs = new ArrayList<Function>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolerName() {
		return rolerName;
	}
	public void setRolerName(String rolerName) {
		this.rolerName = rolerName;
	}
	public String getRolerDescripe() {
		return rolerDescripe;
	}
	public void setRolerDescripe(String rolerDescripe) {
		this.rolerDescripe = rolerDescripe;
	}
	public List<Function> getFuncs() {
		return funcs;
	}
	public void setFuncs(List<Function> funcs) {
		this.funcs = funcs;
	}
	

}
