package univ.ensam.iagi.entities;

import java.util.Optional;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idJoueur;
	@Column
	String nomJoueur;
	@Column
	String poste;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	@JoinColumn(name="idEq",nullable=false)
	@JsonBackReference(value="players")
	Equipe equipe;
	
	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Joueur(Long idJoueur, String nomJoueur, String poste, Equipe equipe) {
		super();
		this.idJoueur = idJoueur;
		this.nomJoueur = nomJoueur;
		this.poste = poste;
		this.equipe = equipe;
	}
	
	public Long getIdJoueur() {
		return idJoueur;
	}
	
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	public String getNomJoueur() {
		return nomJoueur;
	}
	
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	
	public String getPoste() {
		return poste;
	}
	
	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe eq) {
		this.equipe = eq;
	}
	
}
