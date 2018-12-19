package com.formation.repository;

import com.formation.entity.Book;

public interface BookDAO {
	
	public void insert(Book p);
	
	public void insertAll(Book[] p);
	
	public Book findByTitle(String id);
	
	public void update(Book p);
	
	public int deleteById(String id);
	
	public void dropCollectionIfExist();

}
