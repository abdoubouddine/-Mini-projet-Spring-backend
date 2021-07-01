package univ.ensam.iagi.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import univ.ensam.iagi.entities.*;
import univ.ensam.iagi.services.*;

@RestController
public class MatchControleur {

	@Autowired
	MatchService matchservice;
	
	@GetMapping("/matches")
	public Collection<Match> getAllMatches(){
		return matchservice.getAllMatches();
	}
	
	@PostMapping("{idArb}/matches/{idEq1}/{idEq2}/Stade/{idS}")
	public void addMatch(@RequestBody Match m,@PathVariable(value="idArb") Long idA,@PathVariable(value="idEq1") Long id1,
			@PathVariable(value="idEq2") Long id2,@PathVariable(value="idS") Long idS) {
		matchservice.addMatch(idA,m,id1,id2,idS);
	}
	
	@PutMapping("/matches/{id}")
	public void updateMatch(@PathVariable(value="id") Long idM,@RequestBody Match m) {
		matchservice.updateMatch(m, idM);
	}
	
	@DeleteMapping("/matches/{id}")
	public Match deleteMatch(@PathVariable(value="id") Long idM) {
		return matchservice.deleteMatch(idM);
	}
	
	@DeleteMapping("/matches")
	public void deleteMatches() {
		matchservice.deleteAll();
	}
	
	@GetMapping("/matches/{year}/{month}/{day}")
	public List<Match> getByDate(@PathVariable(value="year") int y,@PathVariable(value="month") int m,@PathVariable(value="day") int d){
		return matchservice.getByDate(y,m,d);
	}
	
	@GetMapping("/stade/{id}/match")
	public Stade getStadeById(@PathVariable(value="id") Long idS) {
		return matchservice.getStadeById(idS);
	}
}
