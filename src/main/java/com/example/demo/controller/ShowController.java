package com.example.demo.controller;
/*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PageResponse;
import com.example.demo.dto.ShowDto;
import com.example.demo.service.ShowService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("show")
public class ShowController {

	@Autowired
	private ShowService showService;

	@GetMapping("/search/{pageNo}/{limit}")
	public ResponseEntity<PageResponse<ShowDto>> search(
			@PathVariable(name = "pageNo") @Min(value = 1, message = "Page No Cannot be less than 1") int pageNo,
			@PathVariable(name = "limit") @Min(value = 1, message = "Limit Cannot be less than 1") int limit,
			@RequestParam(name = "movieName", required = false) String movieName,
			@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "showDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate showDate,
			@RequestParam(name = "showTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") LocalTime showTime) {

		log.info("Received Request to search shows for Page: [Number: " + pageNo + ", Limit: " + limit + "]");

		return ResponseEntity.ok(showService.searchShows(movieName, city, showDate, showTime, pageNo, limit));
	}

	@PostMapping("add")
	public ResponseEntity<ShowDto> addShow(@RequestBody ShowDto showDto) {

		log.info("Received Request to add new show: " + showDto);

		return ResponseEntity.ok(showDto);
	}

}
*/

import java.util.List;

import javax.validation.Valid;

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

import com.example.demo.entity.ShowEntity;
import com.example.demo.service.ShowService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/shows")
public class ShowController 
{
	@Autowired
	ShowService service;
	
	@PostMapping("/addshow")
	public ResponseEntity<ShowEntity> addShow(@Valid @RequestBody ShowEntity show) {

		return new ResponseEntity<ShowEntity>(service.addShow(show), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<ShowEntity> getAllShow() {
		return service.getAllShow();
	}

	@GetMapping("find/{showid}")
	public ResponseEntity<ShowEntity> getShowById(@PathVariable("showid") int showid) {
		return new ResponseEntity<ShowEntity>(service.getShowById(showid), HttpStatus.OK);
	}
	@PutMapping("update")
	public ResponseEntity<ShowEntity> updateShow(@Valid  @RequestBody ShowEntity show) {
		return new ResponseEntity<ShowEntity>(service.updateShow(show),HttpStatus.OK);
	}

	@DeleteMapping("delete/{showid}")
	public ResponseEntity<Boolean> deleteShow(@PathVariable("showid") int showid) {
		service.deleteShow(showid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}