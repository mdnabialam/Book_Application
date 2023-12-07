package com.book.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name = "AUTHOR_INFO_BOOKS")
public class Author {
	
	@GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "Book_Application_AUTHOR"
		    
		)
		@SequenceGenerator(
		    name = "Book_Application_AUTHOR",
		    allocationSize=1
		)
	
	
	@Id
	@Column(name = "AID")
	private Integer aId;
	@Column(name = "AUTHOR_FIRST_NAME")
	private String firstName;
	@Column(name = "AUTHOR_LAST_NAME")
	private String lastName;
	@Column(name = "AUTHOR_EMAIL")
	private String email;
	@Column(name = "AUTHOR_PHONE_NUMBER",length = 12)
	private long phone;
	@Column(name = "AUTHOR_LOCAL_LANGAUGE")
	private String langauge;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private BookModel bookModel;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREARE_DATE",updatable = false)
	private Date createdate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Update_Date",insertable = false)
	private Date updatedate;
	

}
