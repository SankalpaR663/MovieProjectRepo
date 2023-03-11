package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")

public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "mobile", nullable = false)
	@Size(max = 10,message = "Mobile number cannot be more than 10 digits")
	private String mobile;

	@Column(name = "Email", nullable = false)
	@javax.validation.constraints.Email(message = "please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String Email;
	
	@Column(name = "Password", nullable = false)
	@Size(min = 4, max = 8, message = "Password cannot be more than 8 characters and cannot be less than 4 characters")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<TicketEntity> ticketEntities;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(long id, String name,
			@Size(max = 10, message = "Mobile number cannot be more than 10 digits") String mobile,
			@javax.validation.constraints.Email(message = "please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}") String email,
			@Size(min = 4, max = 8, message = "Password cannot be more than 8 characters and cannot be less than 4 characters") String password,
			List<TicketEntity> ticketEntities) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		Email = email;
		this.password = password;
		this.ticketEntities = ticketEntities;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TicketEntity> getTicketEntities() {
		return ticketEntities;
	}

	public void setTicketEntities(List<TicketEntity> ticketEntities) {
		this.ticketEntities = ticketEntities;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", mobile=" + mobile + ", Email=" + Email + ", password="
				+ password + ", ticketEntities=" + ticketEntities + "]";
	}
	
	

}