package univ.ensam.iagi.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Stade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idStade;
	@Column
	String nomStade;
	@Column
	String ville;
	@JsonManagedReference(value="matches")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stade")
	Collection<Match> matches;
	
	public Stade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stade(Long idStade, String nomStade, String ville, Collection<Match> matches) {
		super();
		this.idStade = idStade;
		this.nomStade = nomStade;
		this.ville = ville;
		this.matches = matches;
	}

	public Long getIdStade() {
		return idStade;
	}
	
	public void setIdStade(Long idStade) {
		this.idStade = idStade;
	}
	
	public String getNomStade() {
		return nomStade;
	}
	
	public void setNomStade(String nomStade) {
		this.nomStade = nomStade;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}

	public Collection<Match> getMatches() {
		return matches;
	}

	public void setMatches(Collection<Match> matches) {
		this.matches = matches;
	}
	
}
