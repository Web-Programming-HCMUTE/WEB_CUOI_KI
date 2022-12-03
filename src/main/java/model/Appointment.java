package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date createDate;
	
//	chua hieu muc dich la gì
	private String purpose;
	
	private String status;
	
	@OneToOne
	private BookDetail bookDetail;
	
}
