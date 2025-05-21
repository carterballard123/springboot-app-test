package com.springboot.springboot_app_test.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.springboot_app_test.model.Ghost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

@Configuration
public class GhostConfig {

	/**
	 * Loads the ghost definitions from the JSON file and registers them
	 * as a Spring bean named "allGhosts" in the application context.
	 *
	 * @return a List of Ghost objects read from classpath:/ghosts.json
	 * @throws Exception if there’s an I/O or parsing error
	 */
	@Bean
	public List<Ghost> allGhosts() throws Exception {
	    // Creates a resource pointing to the JSON file on the classpath
	    ClassPathResource resource = new ClassPathResource("ghosts.json");
	    // Opens an InputStream to read the raw bytes of ghosts.json
	    try (InputStream in = resource.getInputStream()) { 
	        // Jackson's ObjectMapper deserialize the JSON into Java objects
	        ObjectMapper mapper = new ObjectMapper();
	        List<Ghost> ghosts = mapper.readValue(in, new TypeReference<List<Ghost>>() {});
	        // Returns the fully-populated list of Ghost instances
	        return ghosts;
	    }
	}
}
