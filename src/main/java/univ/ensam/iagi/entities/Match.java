package univ.ensam.iagi.entities;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="matches")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idMatch;
	@Column
	Date dateMatch;
	@Column
	Time heureMatch;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY ) 
	@JoinColumn(foreignKey = @ForeignKey(name = "std_id"),nullable=false)
	@JsonBackReference(value="matches")
	Stade stade;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY ) 
	@JoinColumn(nullable=false,foreignKey = @ForeignKey(name = "arb_id"))
	@JsonBackReference(value="players")
	Arbitre arbitre;
	@ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(
			name = "matches_equipes",
			joinColumns = @JoinColumn(name = "idMatch", nullable = false, referencedColumnName="idMatch"),
			inverseJoinColumns = @JoinColumn(name = "idEquipe", nullable = false, referencedColumnName="idEquipe"))
	List<Equipe> equipes;
	
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Match(Long idMatch, Date dateMatch, Time heureMatch, Stade stade, Arbitre arbitre,
			List<Equipe> equipes) {
		super();
		this.idMatch = idMatch;
		this.dateMatch = dateMatch;
		this.heureMatch = heureMatch;
		this.stade = stade;
		this.arbitre = arbitre;
		this.equipes = equipes;
	}

	public Long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public Time getHeureMatch() {
		return heureMatch;
	}

	public void setHeureMatch(Time heureMatch) {
		this.heureMatch = heureMatch;
	}

	public Stade getStade() {
		return stade;
	}

	public void setStade(Stade stade) {
		this.stade = stade;
	}

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public List<Equipe>  getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe>  equipes) {
		this.equipes = equipes;
	}
	
	
}
