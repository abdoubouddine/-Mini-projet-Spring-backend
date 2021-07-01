package univ.ensam.iagi.controllers;

import java.util.Collection;
import java.util.List;

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
public class EquipeControleur {

	@Autowired
	EquipeService equipeservice;
	
	@GetMapping("/equipes")
	public Collection<Equipe> getAllEquipes(){
		return equipeservice.getAllEquipes();
	}
	
	@PostMapping("/equipes")
	public void addEquipe(@RequestBody Equipe e) {
		equipeservice.addEquipe(e);
	}
	
	@GetMapping("/equipes/{idEquipe}")
	public Equipe getEquipe(@PathVariable(value="idEquipe") Long id) {
		return equipeservice.getEquipeById(id);
	}
	
	@PutMapping("/equipes/{equipeId}")
	public Equipe updateJoueur(@PathVariable(value="equipeId") Long id,@RequestBody Equipe e) {
		return equipeservice.updateEquipe(id, e);
	}
	
	@DeleteMapping("equipes")
	public void suppJoueur(){
		equipeservice.deleteAll();
	}
	
	@DeleteMapping("/equipes/{equipeId}")
	public Equipe suppJoueur(@PathVariable(value="equipeId") Long id) {
		return equipeservice.deleteEquipe(id);
	}
	
	@GetMapping("/equipe/{pays}")
	public List<Equipe> getEquipeByPays(@PathVariable(value="pays") String pays){
		return equipeservice.getEquipeByPays(pays);
	}
	
	@GetMapping("/match/{idMatch}/equipes")
	public List<Equipe> getEquipeByMatchId(@PathVariable(value="idMatch") Long id){
		return equipeservice.getEquipesByMatchId(id);
	}
}
