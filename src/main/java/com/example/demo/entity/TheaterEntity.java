package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.enums.TheaterType;

@Entity
@Table(name = "theaters")

public class TheaterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TheaterType type;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "address", nullable = false)
	private String address;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	//@JsonIgnore
	//@Builder.Default
	private List<ShowEntity> shows = new ArrayList<>();

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	//@JsonIgnore
	//@Builder.Default
	private List<TheaterSeatsEntity> seats = new ArrayList<>();

	public TheaterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TheaterEntity(long id, String name, TheaterType type, String city, String address, List<ShowEntity> shows,
			List<TheaterSeatsEntity> seats) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.city = city;
		this.address = address;
		this.shows = shows;
		this.seats = seats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TheaterType getType() {
		return type;
	}

	public void setType(TheaterType type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ShowEntity> getShows() {
		return shows;
	}

	public void setShows(List<ShowEntity> shows) {
		this.shows = shows;
	}

	public List<TheaterSeatsEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<TheaterSeatsEntity> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "TheaterEntity [id=" + id + ", name=" + name + ", type=" + type + ", city=" + city + ", address="
				+ address + ", shows=" + shows + ", seats=" + seats + "]";
	}
	
	
}
