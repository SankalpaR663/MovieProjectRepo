package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MovieEntity;
import com.example.demo.entity.ShowEntity;
import com.example.demo.repository.ShowRepository;
import com.example.demo.service.ShowService;

import lombok.extern.log4j.Log4j2;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ShowEntity;
import com.example.demo.entity.ShowSeatsEntity;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.ShowSeatsRepository;
import com.example.demo.repository.TheaterRepository;
import com.example.demo.service.LocalDate;
import com.example.demo.service.LocalTime;
import com.example.demo.service.PageResponse;
import com.example.demo.service.ShowDto;
import com.example.demo.service.ShowService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowRepository showsRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ShowSeatsRepository showSeatsRepository;

	@Override
	public ShowDto addShow(ShowDto showDto) {

		Optional<MovieEntity> optionalMovie = movieRepository.findById(showDto.getMovie().getId());

		if (!optionalMovie.isPresent()) {
			throw new DependencyException("Movie Not Found with ID: " + showDto.getMovie().getId() + " to add New Show");
		}

		Optional<TheaterEntity> optionalTheater = theaterRepository.findById(showDto.getTheatre().getId());

		if (!optionalTheater.isPresent()) {
			throw new DependencyException("Theater Not Found with ID: " + showDto.getMovie().getId() + " to add New Show");
		}

		log.info("Adding New Show: " + showDto);

		ShowEntity showEntity = ShowAdapter.toEntity(showDto);

		showEntity.setMovie(optionalMovie.get());
		showEntity.setTheater(optionalTheater.get());
		showEntity.setSeats(generateShowSeats(showEntity.getTheater().getSeats(), showEntity));

		for (ShowSeatsEntity seatsEntity : showEntity.getSeats()) {
			seatsEntity.setShow(showEntity);
		}

		showEntity = showsRepository.save(showEntity);

		log.info("Successfully Added New Show [ID: " + showEntity.getId() + ", ShowDate: " + showEntity.getShowDate() + ", ShowTime: " + showEntity.getShowTime() + "]");

		return ShowAdapter.toDto(showEntity);
	}

	private List<ShowSeatsEntity> generateShowSeats(List<TheaterSeatsEntity> theaterSeatsEntities, ShowEntity showEntity) {

		List<ShowSeatsEntity> showSeatsEntities = new ArrayList<>();

		for (TheaterSeatsEntity theaterSeatsEntity : theaterSeatsEntities) {

			ShowSeatsEntity showSeatsEntity =
					ShowSeatsEntity.builder()
							.seatNumber(theaterSeatsEntity.getSeatNumber())
							.seatType(theaterSeatsEntity.getSeatType())
							.rate((int) (theaterSeatsEntity.getRate() * showEntity.getRateMultiplier()))
							.build();

			showSeatsEntities.add(showSeatsEntity);
		}

		return showSeatsRepository.saveAll(showSeatsEntities);
	}

	@Override
	public PageResponse<ShowDto> searchShows(String movieName, String city, LocalDate showDate, LocalTime showTime, int pageNo, int limit) {

		log.info("Searching Shows by Params: [showName: " + movieName + ", city: " + city + ", showDate: " + showDate + ", showTime: " + showTime + "]");

		Specification<ShowEntity> specifications = ShowHelper.createSpecification(movieName, city, showDate, showTime);

		Page<ShowEntity> showsPage = showsRepository.findAll(specifications, PageRequest.of(pageNo - 1, limit));

		log.info("Found " + showsPage.getNumberOfElements() + " Shows on Page: " + showsPage.getNumber());

		PageResponse<ShowDto> pageResponse = new PageResponse<>();

		if (showsPage.hasContent()) {
			pageResponse.setNumber(pageNo);
			pageResponse.setRecords(showsPage.getNumberOfElements());

			pageResponse.setTotalPages(showsPage.getTotalPages());
			pageResponse.setTotalRecords(showsPage.getTotalElements());

			pageResponse.setData(ShowAdapter.toDto(showsPage.getContent()));
		}

		return pageResponse;
	}

}
*/


@Log4j2
@Service
public class ShowServiceImpl implements ShowService 
{

	@Autowired
	private ShowRepository dao;

	@Override
	public ShowEntity addShow(ShowEntity show) 
	{
		System.out.println("Show added successfully" +show);
		show.setShowDate(show.getShowDate());
		show.setShowTime(show.getShowTime());
		show.setMovie(show.getMovie());
		show.setTheater(show.getTheater());
		show.setTickets(show.getTickets());
		show.setSeats(show.getSeats());
		return dao.save(show);
	}

	@Override
	public List<ShowEntity> getAllShow()
	{
		return dao.findAll();
	}

	@Override
	public ShowEntity getShowById(long id) 
	{
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public ShowEntity updateShow(ShowEntity show) 
	{
		ShowEntity existingShow = dao.findById(show.getId()).orElse(null);
		
		existingShow.setShowDate(show.getShowDate());
		existingShow.setShowTime(show.getShowTime());
		existingShow.setMovie(show.getMovie());
		//existingShow.setTheater(show.getTheater());
		//existingShow.setTickets(show.getTickets());
		//existingShow.setSeats(show.getSeats());
		
		return dao.save(existingShow);
		
	}

	@Override
	public String deleteShow(long id)
	{
		ShowEntity existsID = dao.findById(id).orElse(null);
		if(existsID != null)
		{
			dao.deleteById(id);
			return "Show deleted!!";
		}
		else
		{
			return "Show does not exists!!";
		}
	}
	
	
}