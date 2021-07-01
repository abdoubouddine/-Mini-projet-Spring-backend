package univ.ensam.iagi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties("matches")
public class Arbitre implements Serializable {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idArbitre;
	@Column
	String nom;
	@Column
	String nationalité;
	@JsonManagedReference(value="matches")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "arbitre")
	Collection<Match> matches;
	
	public Arbitre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arbitre(Long idArbitre, String nom, String nationalité, Collection<Match> matches) {
		super();
		this.idArbitre = idArbitre;
		this.nom = nom;
		this.nationalité = nationalité;
		this.matches = matches;
	}

	public Long getIdArbitre() {
		return idArbitre;
	}

	public void setIdArbitre(Long idArbitre) {
		this.idArbitre = idArbitre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNationalité() {
		return nationalité;
	}

	public void setNationalité(String nationalité) {
		this.nationalité = nationalité;
	}

	public Collection<Match> getMatches() {
		return matches;
	}

	public void setMatches(Collection<Match> matches) {
		this.matches = matches;
	}
	
	
}
