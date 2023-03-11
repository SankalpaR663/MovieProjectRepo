package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MovieEntity;
import com.example.demo.repository.MovieRepository;
//import com.example.demo.service.MovieDto;
import com.example.demo.service.MovieService;

import lombok.extern.log4j.Log4j2;
/*
@Log4j2
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public MovieDto addMovie(MovieDto movieDto) {

		if (movieRepository.existsByNameAndLanguage(movieDto.getName(), movieDto.getLanguage())) {
			throw new DuplicateRecordException("Movie Already Exists with Name: " + movieDto.getName() + " in Language: " + movieDto.getLanguage());
		}

		log.info("Adding New Movie: " + movieDto);

		MovieEntity movieEntity = MovieAdapter.toEntity(movieDto);

		movieEntity = movieRepository.save(movieEntity);

		log.info("Added New Movie [id: " + movieEntity.getId() + ", Name: " + movieEntity.getName() + ", Language: " + movieEntity.getLanguage() + "]");

		return MovieAdapter.toDto(movieEntity);
	}

	@Override
	public MovieDto getMovie(long id) {
		log.info("Searching Movie by id: " + id);

		Optional<MovieEntity> movieEntity = movieRepository.findById(id);

		if (!movieEntity.isPresent()) {
			log.error("Movie not found for id: " + id);
			throw new EntityNotFoundException("Movie Not Found with ID: " + id);
		}

		return MovieAdapter.toDto(movieEntity.get());
	}

	@Override
	public MovieDto addMovie(MovieDto movieDto) {
		// TODO Auto-generated method stub
		return null;
	}

}*/

@Service
public class MovieServiceImpl implements MovieService
{

	@Autowired
	MovieRepository dao;
	
	@Override
	public MovieEntity addMovie(MovieEntity movie) 
	{
		System.out.println("Movie added successfully" +movie);
		movie.setName(movie.getName());
		movie.setLanguage(movie.getLanguage());
		movie.setCertificateType(movie.getCertificateType());
		movie.setReleaseDate(movie.getReleaseDate());
		movie.setShows(movie.getShows());
		return dao.save(movie);
	}

	@Override
	public List<MovieEntity> getAllMovie() 
	{
		return dao.findAll();
	}

	@Override
	public MovieEntity getMovieById(long id) 
	{
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public MovieEntity updateMovie(MovieEntity movie) 
	{
		MovieEntity existingMovie = dao.findById(movie.getId()).orElse(null);
		
		existingMovie.setName(movie.getName());
		existingMovie.setLanguage(movie.getLanguage());
		existingMovie.setCertificateType(movie.getCertificateType());
		existingMovie.setReleaseDate(movie.getReleaseDate());
		existingMovie.setShows(movie.getShows());
		
		return dao.save(existingMovie);
	}

	@Override
	public String deleteMovie(long id) 
	{
		MovieEntity existsID = dao.findById(id).orElse(null);
		if(existsID != null)
		{
			dao.deleteById(id);
			return "Movie deleted!!";
		}
		else
		{
			return "Movie does not exists!!";
		}
	}
	
}