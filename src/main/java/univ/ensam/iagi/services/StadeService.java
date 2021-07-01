package univ.ensam.iagi.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.ensam.iagi.dao.*;
import univ.ensam.iagi.entities.*;

@Service
public class StadeService {

	@Autowired
	StadeRepository staderepository;
	
	public Collection<Stade> getAllStades(){
		return staderepository.findAll();
	}
	
	public Stade addStade(Stade s) {
		return staderepository.save(s);
	}
	
	public Stade getStadeById(Long id) {
		return staderepository.getOne(id);
	}
	
	public Stade updateStade(Long id,Stade s) {
		if(staderepository.existsById(id)) {
			Stade std = this.getStadeById(id);
			std.setNomStade(s.getNomStade());
			std.setVille(s.getVille());
			return staderepository.save(std);
		}
		return null;
	}
	
	public Stade deleteStade(Long id) {
		Stade std = this.getStadeById(id);
		staderepository.delete(std);
		return std;
	}
}
