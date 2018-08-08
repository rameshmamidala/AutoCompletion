/**
 * 
 */
package com.ramesh.service;

import java.util.List;

/**
 * @author Ramesh
 *
 */
public interface SuggestionsService {
	
	public List<String> getSuggestedCities(String start,int atmost);

	public String getSuggestedCitiesString(String start, int atmost);

}
