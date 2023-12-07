package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.BookModel;
import com.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	// get All Book
	@GetMapping("/books")
	public ResponseEntity<List<BookModel>> ShowBook() {
		System.out.println("Show All Book List ");
		List<BookModel> list= bookService.getAllBooks();
		if (list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	// get find by ID
	@GetMapping("/books/{id}")
	public ResponseEntity<BookModel> getbookId(@PathVariable("id") int id) {
		BookModel bookModel=bookService.getBookId(id);
		if (bookModel==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookModel));
	}
	// Add new Book
	
	@PostMapping("/addBook")
	public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
		BookModel b= null;
		try {
			b=this.bookService.addBook(bookModel);
			System.out.println(bookModel);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	// Delete Book by ID
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			 this.bookService.deleteBook(bookId);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	// update book by id
	@PutMapping("books/{bookId}")
	public ResponseEntity<BookModel> updatebook(@RequestBody BookModel bookModel,@PathVariable("bookId") int bookId) {
		try {
			this.bookService.updateBook(bookModel,bookId);
			return ResponseEntity.ok().body(bookModel);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}
