/**
 * 
 */
package com.ramesh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramesh.constants.CommonConstants;

/**
 * @author Ramesh
 * 
 */
@Component
public class SuggestedServicesUtil {
	
	private final Logger logger = LoggerFactory
			.getLogger(SuggestedServicesUtil.class);
	
	@Autowired
	CommonConstants commonConstants;
	
	/**
	 * To get the set of available cities
	 * 
	 * @return set of available cities
	 */
	public Set<String> getAvailableCities() {
		
		File file = new File(getClass().getClassLoader().getResource(commonConstants.fileLocation).getFile());
		
		logger.info("getting the available cities from "+file.getAbsolutePath());
		
		BufferedReader reader = null;
		Set<String> availableCities = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			availableCities = new HashSet<>();
			String city = null;
			while (null != (city = reader.readLine())) {
				availableCities.add(city);
			}
			
		} catch (FileNotFoundException e) {
			logger.error("Failed to read the file");
		} catch (IOException e) {
			logger.error("Failed to read the file");
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error("Unable to close the reader");
				}
			}
		}
		
		logger.info("availble cities size "+availableCities.size());
		
		return availableCities;
	}
}
