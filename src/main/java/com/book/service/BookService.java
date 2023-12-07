package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.book.model.BookModel;

@Service
public class BookService {

	private static List<BookModel> list = new ArrayList<>();
	
	static {
		
		list.add(new BookModel(122,"Java","Core Java","NABIALAM",2452.2));
		list.add(new BookModel(13,"ADV JAVA","Adv Java","MD NAZIR HAIDER",2513.2));
		list.add(new BookModel(14,"SPRING"," Spring","TAHIR",1500.2));
		list.add(new BookModel(15,"ORACLE","Oracle","FATIMA",15002.2));
		list.add(new BookModel(16,"SPRING BOOT","Springboot","ZOHAN",4525.2));
	
	}
	
	// get All Book
	public List<BookModel> getAllBooks(){
		System.out.println(list);
		return list;
	}
	// Book find By id
	
	public BookModel getBookId(int id) {
		BookModel book=null;
		try {
			book=list.stream().filter(e->e.getId()==id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	//Add new Book
	
	public BookModel addBook(BookModel b) {
		list.add(b);
		return b; 
	}
	// delete book id
	public void deleteBook(int bid) {
		list=list.stream().filter(book ->book.getId()!=bid)
				.collect(Collectors.toList());
	}
	
	
	// update book by id
	public void updateBook(BookModel bookModel,int bookId) {
		
		list.stream().map(b->{
			if (b.getId()==bookId) {
				b.setBookName(bookModel.getBookName());
				b.setTitle(bookModel.getTitle());
				b.setAuthor(bookModel.getAuthor());
				b.setPrice(bookModel.getPrice());
			}
			return b;
		}).collect(Collectors.toList());
		
	}
	
	
	
	
}
