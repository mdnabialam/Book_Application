package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.model.BookModel;

public interface BookRepo extends JpaRepository<BookModel,Integer> {
	public BookModel findById(int id);

}
