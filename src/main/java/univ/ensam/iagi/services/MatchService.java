package univ.ensam.iagi.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.ensam.iagi.dao.*;
import univ.ensam.iagi.entities.*;

@Service
public class MatchService {

	@Autowired
	MatchRepository matchrepository;
	@Autowired
	EquipeRepository equiperepository;
	@Autowired
	ArbitreRepository arbitrerepository;
	@Autowired 
	StadeRepository staderepository;
	
	public Collection<Match> getAllMatches(){
		return matchrepository.findAll();
	}
	
	public Match getMatchById(Long id) {
		return matchrepository.getOne(id);
	}
	
	public Match addMatch(Long idA,Match m,Long id1,Long id2,Long idS) {
		Arbitre arb = arbitrerepository.getOne(idA);
		m.setArbitre(arb);
		m.setEquipes(Arrays.asList(new Equipe[] {equiperepository.getOne(id1),equiperepository.getOne(id2)}));
		Stade std = staderepository.getOne(idS);
		m.setStade(std);
		return matchrepository.save(m);
	}
	
	public Match updateMatch(Match m,Long id) {
		if(matchrepository.existsById(id)) {
			Match mat = this.getMatchById(id);
			mat.setDateMatch(m.getDateMatch());
			mat.setHeureMatch(m.getHeureMatch());
			mat.setStade(m.getStade());
			mat.setArbitre(m.getArbitre());
			mat.setEquipes(m.getEquipes());
			return matchrepository.save(mat);
		}
		return null;
	}
	
	public Match deleteMatch(Long id) {
		if(matchrepository.existsById(id)) matchrepository.deleteById(id);
		return matchrepository.getOne(id);
	}
	
	public void deleteAll() {
		matchrepository.deleteAll();
	}
	
	public List<Match> getByDate(int y,int m,int d) {
		return matchrepository.findByDateMatch(y,m,d);
	}
	
	public Stade getStadeById(Long id) {
		return staderepository.findById(matchrepository.findStadeById(id)).get();
	}
}
