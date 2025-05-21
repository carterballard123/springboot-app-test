package com.springboot.springboot_app_test.model;

import java.util.List;
import java.util.Set;

public class Ghost {
	private String name;
	private Set<String> evidence;
	private List<String> strengths;
	private List<String> abilities;
	private List<String> weaknesses;
	
	
	// Getters
	public String getName() { 
		return name; 
	}
	
	public Set<String> getEvidence() { 
		return evidence;
	}
	
	public List<String> getStrengths() {
		return strengths;
	}
	
	public List<String> getAbilities() {
		return abilities;
	}
	
	public List<String> getWeaknesses() {
		return weaknesses;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEvidence(Set<String> evidence) {
		this.evidence = evidence;
	}
	
	public void setStrengths(List<String> strengths) {
		this.strengths = strengths;
	}
	
	public void setAbilites(List<String> abilites) {
		this.abilities = abilites;
	}
	
	public void setWeaknesses(List<String> weaknesses) {
		this.weaknesses = weaknesses;
	}
}
