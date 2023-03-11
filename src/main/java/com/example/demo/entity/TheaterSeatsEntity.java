package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.enums.SeatType;

@Entity
@Table(name = "theater_seats")

public class TheaterSeatsEntity {

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

	@ManyToOne
	//@JsonIgnore
	private TheaterEntity theater;

	public TheaterSeatsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TheaterSeatsEntity(long id, String seatNumber, int rate, SeatType seatType, TheaterEntity theater) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.rate = rate;
		this.seatType = seatType;
		this.theater = theater;
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

	public TheaterEntity getTheater() {
		return theater;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	@Override
	public String toString() {
		return "TheaterSeatsEntity [id=" + id + ", seatNumber=" + seatNumber + ", rate=" + rate + ", seatType="
				+ seatType + ", theater=" + theater + "]";
	}
	
	
}
