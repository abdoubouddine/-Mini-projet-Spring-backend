package univ.ensam.iagi.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.ensam.iagi.dao.*;
import univ.ensam.iagi.entities.*;

@Service
public class EquipeService {

	@Autowired
	EquipeRepository equiperepository;
	
	public Collection<Equipe> getAllEquipes(){
		return equiperepository.findAll();
	}
	
	public Equipe addEquipe(Equipe e) {
		return equiperepository.save(e);
	}
	
	public Equipe getEquipeById(Long id) {
		return equiperepository.getOne(id);
	}
	
	public Equipe updateEquipe(Long id,Equipe e) {
		if(equiperepository.existsById(id)) {
			Equipe team = this.getEquipeById(id);
			team.setNomEquipe(e.getNomEquipe());
			team.setPays(e.getPays());
			return equiperepository.save(team);
		}
		return null;
	}
	
	public void deleteAll() {
		equiperepository.deleteAll();
	}
	public Equipe deleteEquipe(Long id) {
		Equipe team = this.getEquipeById(id);
		equiperepository.delete(team);
		return team;
	}
	
	public List<Equipe> getEquipeByPays(String pays) {
		return equiperepository.findByPays(pays);
	}
	
	public List<Equipe> getEquipesByMatchId(Long id){
		return equiperepository.getEquipesByMatchId(id);
	}
}
