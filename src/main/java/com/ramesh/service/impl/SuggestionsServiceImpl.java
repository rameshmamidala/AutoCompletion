/**
 * 
 */
package com.ramesh.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramesh.service.SuggestionsService;
import com.ramesh.util.SuggestedServicesUtil;

/**
 * Service calls for getting suggestions
 * 
 * @author Ramesh
 * 
 */
@Service
public class SuggestionsServiceImpl implements SuggestionsService {

	private final Logger logger = LoggerFactory
			.getLogger(SuggestionsServiceImpl.class);

	@Autowired
	SuggestedServicesUtil servicesUtil;

	/**
	 * To get the suggested cities
	 * 
	 * return suggested cities as string
	 * 
	 */
	@Override
	public String getSuggestedCitiesString(String start, int atmost) {
		logger.info("getting suggested cities");

		Set<String> availableCities = servicesUtil.getAvailableCities();

		StringBuilder stringBuilder = new StringBuilder();
		int count = 0;

		for (String city : availableCities) {
			if (city.toUpperCase().startsWith(start.toUpperCase())) {
				stringBuilder.append(city);
				stringBuilder.append("\n");
				count++;
			}
			if (atmost == count) {
				break;
			}
		}
		
		logger.info("fetched the suggested cities");
		return stringBuilder.toString();
	}
	
	/**
	 * To get the suggested cities
	 * 
	 * return list of suggested cities
	 */
	@Override
	public List<String> getSuggestedCities(String start, int atmost) {
		logger.info("getting suggested cities");

		Set<String> availableCities = servicesUtil.getAvailableCities();

		List<String> suggestedCities = new ArrayList<>();
		int count = 0;

		for (String string : availableCities) {
			if (string.toUpperCase().startsWith(start.toUpperCase())) {
				suggestedCities.add(string);
				count++;
			}
			if (atmost == count) {
				break;
			}
		}
		
		Collections.sort(suggestedCities);
		
		logger.info("fetched the suggested cities");
		return suggestedCities;
	}

}
