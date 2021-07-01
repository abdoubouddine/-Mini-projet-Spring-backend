package univ.ensam.iagi.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import univ.ensam.iagi.entities.*;
import univ.ensam.iagi.services.*;

@RestController
public class JoueurControleur {

	@Autowired
	JoueurService joueurservice;
	
	@GetMapping("/joueurs")
	public Collection<Joueur> getAllJoueurs(){
		return joueurservice.getAllJoueurs();
	}
	
	@PostMapping("/equipes/{equipeId}/joueurs")
	public void addJoueur(@RequestBody Joueur j,@PathVariable(value="equipeId") Long id) {
		joueurservice.addJoueur(j, id);
	}
	
	@GetMapping("/joueurs/{joueurId}")
	public Joueur getJoueur(@PathVariable(value="joueurId") Long joueurId ) {
		return joueurservice.getJoueurById(joueurId);
	}
	
	@PutMapping("/equipes/{equipeId}/joueurs/{joueurId}")
	public Joueur updateJoueur(@PathVariable(value="joueurId") Long id,@PathVariable(value="equipeId") Long idEq,@RequestBody Joueur j) {
		return joueurservice.updateJoueur(id,idEq, j);
	}
	
	@DeleteMapping("joueurs/{joueurId}")
	public Joueur suppJoueur(@PathVariable(value="joueurId") Long joueurId) {
		return joueurservice.deleteJoueur(joueurId);
	}
	
	@GetMapping("/joueurs/{nomEquipe}/equipe")
	public List<Joueur> findByEquipeNom(@PathVariable(value="nomEquipe") String nom){
		return joueurservice.findByEquipeNom(nom);
	}
	
	@GetMapping("/equipes/{nomEquipe}/{poste}/joueurs")
	public List<Joueur> findByEquipeNomAndPoste(@PathVariable(value="nomEquipe") String nom,@PathVariable(value="poste") String poste){
		return joueurservice.findByEquipeNomAndPoste(nom, poste);
	}
}
