package univ.ensam.iagi.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.ensam.iagi.dao.*;
import univ.ensam.iagi.entities.*;

@Service
public class ArbitreService {

	@Autowired
	ArbitreRepository arbitrerepository;
	
	public Collection<Arbitre> getAllArbitres(){
		return arbitrerepository.findAll();
	}
	
	public Arbitre addArbitre(Arbitre a) {
		return arbitrerepository.save(a);
	}
	
	public Arbitre getArbitreById(Long id) {
		return arbitrerepository.getOne(id);
	}
	
	public Arbitre updateArbitre(Long id,Arbitre a) {
		if(arbitrerepository.existsById(id)) {
			Arbitre arb = this.getArbitreById(id);
			arb.setNom(a.getNom());
			arb.setNationalité(a.getNationalité());
			return arbitrerepository.save(arb);
		}
		return null;
	}
	
	public Arbitre deleteArbitre(Long id) {
		Arbitre arb = this.getArbitreById(id);
		arbitrerepository.delete(arb);
		return arb;
	}
}
