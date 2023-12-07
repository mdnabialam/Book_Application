package com.book.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Book_Info_Application")
public class BookModel {
	@GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "Book_Application"
		    
		)
		@SequenceGenerator(
		    name = "Book_Application",
		    allocationSize=1
		)
	
	
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BID")
	private Integer id;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_TITLE")
	private String title;
	@Column(name = "BOOK_AUTHOR")
	private String author;
	@Column (name = "BOOK_PRICE")
	private double price;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREARE_DATE",updatable = false)
	private Date createdate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Update_Date",insertable = false)
	private Date updatedate;
	

}
