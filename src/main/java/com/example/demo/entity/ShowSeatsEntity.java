package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.enums.SeatType;

@Entity
@Table(name = "show_seats")
public class ShowSeatsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "seat_number", nullable = false)
	private String seatNumber;

	@Column(name = "rate", nullable = false)
	private int rate;

	@Enumerated(EnumType.STRING)
	@Column(name = "seat_type", nullable = false)
	private SeatType seatType;

	@Column(name = "is_booked", columnDefinition = "bit(1) default 0", nullable = false)
	private boolean booked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "booked_at")
	private Date bookedAt;

	@ManyToOne
	//@JsonIgnore
	private ShowEntity show;

	@ManyToOne
	//@JsonIgnore
	private TicketEntity ticket;

	public ShowSeatsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowSeatsEntity(long id, String seatNumber, int rate, SeatType seatType, boolean booked, Date bookedAt,
			ShowEntity show, TicketEntity ticket) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.rate = rate;
		this.seatType = seatType;
		this.booked = booked;
		this.bookedAt = bookedAt;
		this.show = show;
		this.ticket = ticket;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public Date getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(Date bookedAt) {
		this.bookedAt = bookedAt;
	}

	public ShowEntity getShow() {
		return show;
	}

	public void setShow(ShowEntity show) {
		this.show = show;
	}

	public TicketEntity getTicket() {
		return ticket;
	}

	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "ShowSeatsEntity [id=" + id + ", seatNumber=" + seatNumber + ", rate=" + rate + ", seatType=" + seatType
				+ ", booked=" + booked + ", bookedAt=" + bookedAt + ", show=" + show + ", ticket=" + ticket + "]";
	}
	
	
}
