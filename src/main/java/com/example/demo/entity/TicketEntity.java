package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
//@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "tickets")

public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "alloted_seats", nullable = false)
	private String allottedSeats;

	@Column(name = "amount", nullable = false)
	private double amount;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "booked_at", nullable = false)
	private Date bookedAt;

	@ManyToOne
	//@JsonIgnore
	private UserEntity user;

	@ManyToOne
	//@JsonIgnore
	private ShowEntity show;

	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<ShowSeatsEntity> seats;

	public TicketEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketEntity(long id, String allottedSeats, double amount, Date bookedAt, UserEntity user, ShowEntity show,
			List<ShowSeatsEntity> seats) {
		super();
		this.id = id;
		this.allottedSeats = allottedSeats;
		this.amount = amount;
		this.bookedAt = bookedAt;
		this.user = user;
		this.show = show;
		this.seats = seats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAllottedSeats() {
		return allottedSeats;
	}

	public void setAllottedSeats(String allottedSeats) {
		this.allottedSeats = allottedSeats;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(Date bookedAt) {
		this.bookedAt = bookedAt;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ShowEntity getShow() {
		return show;
	}

	public void setShow(ShowEntity show) {
		this.show = show;
	}

	public List<ShowSeatsEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<ShowSeatsEntity> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "TicketEntity [id=" + id + ", allottedSeats=" + allottedSeats + ", amount=" + amount + ", bookedAt="
				+ bookedAt + ", user=" + user + ", show=" + show + ", seats=" + seats + "]";
	}
	
	
}