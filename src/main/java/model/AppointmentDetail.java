package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "book_detail")
public class BookDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private User userDatLich;
	
	private String content;
	
	// có nhiều book cho 1 nhà trọ
	@ManyToOne
	private HotelDetail hotelDetail;
	
	@OneToOne
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserDatLich() {
		return userDatLich;
	}

	public void setUserDatLich(User userDatLich) {
		this.userDatLich = userDatLich;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public HotelDetail getHotelDetail() {
		return hotelDetail;
	}

	public void setHotelDetail(HotelDetail hotelDetail) {
		this.hotelDetail = hotelDetail;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
