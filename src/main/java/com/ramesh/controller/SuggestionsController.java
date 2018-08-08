/**
 * 
 */
package com.ramesh.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramesh.service.SuggestionsService;

/**
 * REST controller to get the suggestions
 * 
 * @author Ramesh
 *
 */
@RestController
public class SuggestionsController {
	
	private final Logger logger = LoggerFactory.getLogger(SuggestionsController.class);
	
	/** Suggestions service */
	@Autowired
	SuggestionsService suggestionsService;
	
	/**
	 * 
	 * To get the suggested cities based on search string
	 * 
	 * @param start
	 * @param atmost
	 * @return suggested cities
	 */
	@RequestMapping(method=RequestMethod.GET,value="/suggest_cities",produces="text/plain")
	public ResponseEntity<String> getSuggestedCities(@RequestParam String start,
			@RequestParam Integer atmost){
		logger.info("Processing getSuggestedCities request");
		
		String response = null;
		HttpStatus httpStatus = null;
		try {
			response = suggestionsService.getSuggestedCitiesString(start, atmost);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response = "";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
			
		logger.info("getSuggestedCities processing completed");
		return new ResponseEntity<>(response, httpStatus);
	}
	
	/**
	 * 
	 * To get the suggested cities based on search string
	 * 
	 * @param start
	 * @param atmost
	 * @return list of suggested cities
	 */
	@RequestMapping(method=RequestMethod.GET,value="/suggest_cities_json")
	public ResponseEntity<List<String>> getSuggestedCitiesAsJson(@RequestParam String start,
			@RequestParam Integer atmost){
		logger.info("Processing getSuggestedCities request");
		List<String> cities = null;
		HttpStatus httpStatus = null;
		try {
			cities = suggestionsService.getSuggestedCities(start, atmost);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			cities = new ArrayList<>();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		logger.info("suggested cities size "+cities.size());
		logger.info("getSuggestedCities processing completed");
		return new ResponseEntity<>(cities, httpStatus);
	}
	
}
