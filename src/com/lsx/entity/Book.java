package com.lsx.entity;

public class Book {
   private String id;
   private String name;
   private String year;
   private String author;
   private String language;
   private String price;
   public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
   
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

   
}
