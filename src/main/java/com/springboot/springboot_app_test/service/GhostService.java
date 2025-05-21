package com.springboot.springboot_app_test.service;

import com.springboot.springboot_app_test.model.Ghost;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GhostService {
	// Holds all ghosts from JSON file
	private final List<Ghost> allGhosts;
	
	// Constructor
	public GhostService(List<Ghost> allGhosts) {
		this.allGhosts = allGhosts;
	}
	
	/**
	* Core filtering method
	*
	* @param confirmed the set of evidence the player has seen
	* @param ruledOut  the set of evidence the player has determined is NOT present
	* @return a List of ghost names matching exactly those constraints
	*/
	public List<String> filter(Set<String> confirmed, Set<String> ruledOut){
		
		return allGhosts.stream()
		// Keep only ghosts that have *all* of the confirmed evidence
		.filter(g -> g.getEvidence().containsAll(confirmed))
		// Make sure they have *none* of the ruled-out evidence
		.filter(g -> Collections.disjoint(g.getEvidence(), ruledOut))
		// Extract just the ghost’s name for client
		.map(Ghost::getName)
		// Collect the results into a List<String>
		.collect(Collectors.toList());
	}
	
	
}
