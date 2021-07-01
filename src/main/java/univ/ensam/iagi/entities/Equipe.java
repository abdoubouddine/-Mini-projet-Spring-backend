package univ.ensam.iagi.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"joueurs","matches"})
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idEquipe;
	@Column
	String nomEquipe;
	@Column
	String pays;
	@JsonManagedReference(value="players")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "equipe")
	Collection<Joueur> joueurs;
	@ManyToMany(mappedBy = "equipes",fetch = FetchType.LAZY)
	Collection<Match> matches;
	
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipe(Long idEquipe, String nomEquipe, String pays, Collection<Joueur> joueurs, Collection<Match> matches) {
		super();
		this.idEquipe = idEquipe;
		this.nomEquipe = nomEquipe;
		this.pays = pays;
		this.joueurs = joueurs;
		this.matches = matches;
	}

	public Long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Collection<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Collection<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Collection<Match> getMatches() {
		return matches;
	}

	public void setMatches(Collection<Match> matches) {
		this.matches = matches;
	}
	
}
