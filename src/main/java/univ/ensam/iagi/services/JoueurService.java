package univ.ensam.iagi.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import univ.ensam.iagi.dao.*;
import univ.ensam.iagi.entities.*;

@Service
public class JoueurService {

	@Autowired
	JoueurRepository joueurrepository;
	@Autowired 
	EquipeRepository equiperepository;
	
	public Collection<Joueur> getAllJoueurs(){
		return joueurrepository.findAll();
	}
	
	public Joueur addJoueur(Joueur j,Long id) {
		Equipe e = equiperepository.getOne(id);
		j.setEquipe(e);
		return joueurrepository.save(j);
	}
	
	public Joueur getJoueurById(Long id) {
		return joueurrepository.getOne(id);
	}
	
	public Joueur updateJoueur(Long id,Long idEq,Joueur j) {
		Equipe eq = equiperepository.getOne(idEq);
		Joueur player = joueurrepository.findById(id).get();
		player.setEquipe(eq);
		player.setNomJoueur(j.getNomJoueur());
		player.setPoste(j.getPoste());
		return joueurrepository.save(player);
	}
	
	public Joueur deleteJoueur(Long idJ) {
		Joueur j = joueurrepository.getOne(idJ);
		joueurrepository.delete(j);
		return j;
	}
	
	public List<Joueur> findByEquipeNomAndPoste(String nom,String poste) {
		return joueurrepository.findByPostAndEquipeNom(nom, poste);
	}
	
	public List<Joueur> findByEquipeNom(String nom){
		return joueurrepository.findByEquipeNom(nom);
	}
}
