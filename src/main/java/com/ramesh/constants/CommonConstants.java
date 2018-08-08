/**
 * 
 */
package com.ramesh.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Common constants
 * 
 * @author Ramesh
 *
 */
@Component
@PropertySource("classpath:application.properties")
public class CommonConstants {
	
	@Value("${file.location}")
	public String fileLocation;

}
