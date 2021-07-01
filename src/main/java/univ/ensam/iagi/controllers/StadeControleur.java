package univ.ensam.iagi.controllers;

import java.util.Collection;

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
public class StadeControleur {

	@Autowired
	StadeService stadeservice;
	
	@GetMapping("/stades")
	public Collection<Stade> getAllStades(){
		return stadeservice.getAllStades();
	}
	
	@PostMapping("/stades")
	public void addStade(@RequestBody Stade s) {
		stadeservice.addStade(s);
	}
	
	@GetMapping("/stades/{idStade}")
	public Stade getEquipe(@PathVariable(value="idStade") Long id) {
		return stadeservice.getStadeById(id);
	}
	
	@PutMapping("/stades/{stadeId}")
	public Stade updateStade(@PathVariable(value="stadeId") Long id,@RequestBody Stade s) {
		return stadeservice.updateStade(id, s);
	}
	
	@DeleteMapping("/stades/{stadeId}")
	public Stade suppStade(@PathVariable(value="stadeId") Long id) {
		return stadeservice.deleteStade(id);
	}
}
