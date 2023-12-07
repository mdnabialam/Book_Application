package com.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookModel {
	
	private Integer id;
	private String bookName;
	private String title;
	private String author;
	private double price;
	

}
