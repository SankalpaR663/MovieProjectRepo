package com.example.demo.entity;

import java.time.LocalDate;
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

import com.example.demo.enums.CertificateType;
import com.example.demo.enums.MovieLanguage;

@Entity
@Table(name = "movies")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = false)
	private MovieLanguage language;

	@Enumerated(EnumType.STRING)
	@Column(name = "certificate_type", nullable = false)
	private CertificateType certificateType;

	@Column(name = "release_date", columnDefinition = "DATE", nullable = false)
	private LocalDate releaseDate;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	//@JsonIgnore
	//@Builder.Default
	private List<ShowEntity> shows = new ArrayList<>();

	public MovieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieEntity(long id, String name, MovieLanguage language, CertificateType certificateType,
			LocalDate releaseDate, List<ShowEntity> shows) 
			{
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.certificateType = certificateType;
		this.releaseDate = releaseDate;
		this.shows = shows;
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

	public MovieLanguage getLanguage() {
		return language;
	}

	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}

	public CertificateType getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<ShowEntity> getShows() {
		return shows;
	}

	public void setShows(List<ShowEntity> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "MovieEntity [id=" + id + ", name=" + name + ", language=" + language + ", certificateType="
				+ certificateType + ", releaseDate=" + releaseDate + " shows=" + shows + "]";
	}
	
	
}