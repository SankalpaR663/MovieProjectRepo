package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;
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

@Entity
//@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "shows")
public class ShowEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "show_date", columnDefinition = "DATE", nullable = false)
	private LocalDate showDate;

	@Column(name = "show_time", columnDefinition = "TIME", nullable = false)
	private LocalTime showTime;

	@ManyToOne
	//@JsonIgnore
	private MovieEntity movie;

	@ManyToOne
	//@JsonIgnore
	private TheaterEntity theater;

	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<TicketEntity> tickets;

	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<ShowSeatsEntity> seats;
	
	public ShowEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowEntity(long id, LocalDate showDate, LocalTime showTime, MovieEntity movie, TheaterEntity theater, List<TicketEntity> tickets, List<ShowSeatsEntity> seats) {
		super();
		this.id = id;
		this.showDate = showDate;
		this.showTime = showTime;
		this.movie = movie;
		this.theater = theater;
		this.tickets = tickets;
		this.seats = seats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public TheaterEntity getTheater() {
		return theater;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	public List<TicketEntity> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}

	public List<ShowSeatsEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<ShowSeatsEntity> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "ShowEntity [id=" + id + ", showDate=" + showDate + ", showTime=" + showTime +  ", movie=" + movie + ""+ ", theater=" + theater + ", tickets=" + tickets
				+ ", seats=" + seats + "]";
	}

	

}