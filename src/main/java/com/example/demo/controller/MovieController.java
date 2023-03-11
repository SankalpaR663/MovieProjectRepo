package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.dto.MovieDto;
import com.example.demo.entity.MovieEntity;
import com.example.demo.service.MovieService;

import lombok.extern.log4j.Log4j2;
/*
@Log4j2
@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("add")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {

		log.info("Received Request to add new movie: " + movieDto);

		return ResponseEntity.ok(movieService.addMovie(movieDto));
	}

	@GetMapping("{id}")
	public ResponseEntity<MovieDto> getUser(@PathVariable(name = "id") @Min(value = 1, message = "Movie Id Cannot be -ve") long id) {

		log.info("Received Request to get movie: " + id);

		return ResponseEntity.ok(movieService.getMovie(id));
	}
}
*/


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/movie")
public class MovieController 
{
	@Autowired
	MovieService service;
	
	@PostMapping("/addmovie")
	public ResponseEntity<MovieEntity> addMovie(@Valid @RequestBody MovieEntity movie) {

		return new ResponseEntity<MovieEntity>(service.addMovie(movie), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<MovieEntity> getAllMovie() {
		return service.getAllMovie();
	}

	@GetMapping("find/{movieid}")
	public ResponseEntity<MovieEntity> getMovieById(@PathVariable("movieid") int movieid) {
		return new ResponseEntity<MovieEntity>(service.getMovieById(movieid), HttpStatus.OK);
	}
	@PutMapping("update")
	public ResponseEntity<MovieEntity> updateMovie(@Valid  @RequestBody MovieEntity movie) {
		return new ResponseEntity<MovieEntity>(service.updateMovie(movie),HttpStatus.OK);
	}

	@DeleteMapping("delete/{movieid}")
	public ResponseEntity<Boolean> deleteMovie(@PathVariable("movieid") int movieid) {
		service.deleteMovie(movieid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}