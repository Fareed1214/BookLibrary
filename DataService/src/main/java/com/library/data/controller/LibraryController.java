package com.library.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.data.bo.BookInfo;
import com.library.data.bo.LibraryView;
import com.library.data.service.DataService;

@RestController
public class LibraryController
{


	//@Value("${service.addBook}")
	//private String addbook;


	@Autowired
	@Qualifier("addBook")
	DataService addService;

	@Autowired
	@Qualifier("removeBook")
	DataService removeService;

	@Autowired
	@Qualifier("searchBook")
	DataService searchService;

	@Autowired
	@Qualifier("searchBooks")
	DataService searchAllService;

	@Autowired
	@Qualifier("issueBook")
	DataService issueService;

	@Autowired
	@Qualifier("returnBook")
	DataService returnService;

	@Autowired
	@Qualifier("isBookAvailable")
	DataService isAvailableService;

	@RequestMapping(value = "/dataservice/Addbook", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addBook(@RequestBody BookInfo input)
	{
		System.out.println("Data Service Request - addBook - " + input);
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		Boolean result = (Boolean) addService.operation(input);
		if (result)
			status = HttpStatus.OK;
		System.out.println("Data Service Request - addBook - " + result);
		return new ResponseEntity<Boolean>(result, status);
	}

	@RequestMapping(value = "/dataservice/Removebook/{input}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> removeBook(@PathVariable("input") String input)
	{
		System.out.println("Data Service Request - removeBook - " + input);
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		Boolean result = (Boolean) removeService.operation(input);
		if (result)
			status = HttpStatus.OK;
		System.out.println("Data Service Request - removeBook - " + result);
		return new ResponseEntity<Boolean>(result, status);
	}

	@GetMapping("/dataservice/Searchbook/{input}")
	public ResponseEntity<BookInfo> searchBook(@PathVariable("input") String input)
	{
		System.out.println("Data Service Request - searchBook - " + input);
		HttpStatus status = HttpStatus.NO_CONTENT;
		BookInfo result = (BookInfo) searchService.operation(input);
		if (result != null)
			status = HttpStatus.OK;
		System.out.println("Data Service Response - searchBook - " + result);
		return new ResponseEntity<BookInfo>(result, status);
	}

	@GetMapping("/dataservice/Searchbooks")
	public ResponseEntity<LibraryView> searchBooks()
	{
		System.out.println("Data Service Request - searchBooks !");
		HttpStatus status = HttpStatus.NO_CONTENT;
		LibraryView result = (LibraryView) searchAllService.operation(null);
		if (result != null)
			status = HttpStatus.OK;
		System.out.println("Data Service Request - searchBooks - " + result);
		return new ResponseEntity<LibraryView>(result, status);
	}

	@GetMapping("/dataservice/IsAvailable/{input}")
	public ResponseEntity<Boolean> isAvailable(@PathVariable("input") String input)
	{
		System.out.println("Data Service Request - isAvailable - " + input);
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		Boolean result = (Boolean) isAvailableService.operation(input);
		if (result)
			status = HttpStatus.OK;
		System.out.println("Data Service Response - isAvailable - " + result);
		return new ResponseEntity<Boolean>(result, status);
	}

}
