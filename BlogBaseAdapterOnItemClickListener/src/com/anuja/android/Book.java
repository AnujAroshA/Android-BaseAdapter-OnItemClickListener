package com.anuja.android;

public class Book {
	
	private long bookIsbn;
	private String bookName;
	private String bookAutorName;
	
	public long getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookAutorName() {
		return bookAutorName;
	}
	public void setBookAutorName(String bookAutorName) {
		this.bookAutorName = bookAutorName;
	}
}
