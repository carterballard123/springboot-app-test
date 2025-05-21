package com.springboot.springboot_app_test.controller;

import com.springboot.springboot_app_test.service.GhostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class GhostController {
	
	// Holds filtering logic
	private final GhostService service;
	
	// Constructor
	public GhostController(GhostService service) {
		this.service = service;
	}
	
	/**
	*	Maps HTTP GET requests on /api/possible to this method.
	*   For ex: GET /api/possible?confirmed=EMF%20Level%205&ruledOut=Spirit%20Box
	*/
	@GetMapping("/api/possible")
	public List<String> possible(
		// Binds all “confirmed” query params into a Set<String>, if present
		@RequestParam(required = false) Set<String> confirmed,
		// Binds all “ruledOut” query params into a Set<String>, if present
		@RequestParam(required = false) Set<String> ruledOut
			) {
		
    	/*
	     * 	Default to empty sets if the client didn’t include those params,
	     *  so service.filter(...) never sees null
	     *   Delegate to the service layer, returning a List<String> of ghost names
	     *   Spring Boot will automatically serialize that List into JSON
	     */ 
		return service.filter(
				confirmed != null ? confirmed : Set.of(), 
				ruledOut != null ? ruledOut : Set.of()
						);
	}
}
