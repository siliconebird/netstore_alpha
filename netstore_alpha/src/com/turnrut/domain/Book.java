package com.turnrut.domain;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = -1665107030075971326L;
	private String id;
	private String name;
	private String author;
	private float price;
	private String description;
	private String categoryID;
	private String photoPath;
	private String photoName;

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", description="
				+ description + ", categoryID=" + categoryID + ", photoPath=" + photoPath + ", photoName=" + photoName
				+ "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}


	public String getPhotoPath() {
		return photoPath;
	}


	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	public String getPhotoName() {
		return photoName;
	}


	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Book() {
		
	}


	public Book(String id, String name, String author, float price, String description, String categoryID,
			String photoPath, String photoName) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.description = description;
		this.categoryID = categoryID;
		this.photoPath = photoPath;
		this.photoName = photoName;
	}
	
	
}
