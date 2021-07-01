package univ.ensam.iagi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import univ.ensam.iagi.entities.*;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {

	@Query(value="SELECT * FROM joueur j,equipe e WHERE e.id_equipe = j.id_eq AND e.nom_equipe LIKE :nom",nativeQuery=true)
	List<Joueur> findByEquipeNom(@Param("nom") String nomEquipe);
	
	@Query(value= "SELECT * FROM joueur j,equipe e WHERE j.id_eq = e.id_equipe AND e.nom_equipe LIKE :nom AND j.poste LIKE :poste",nativeQuery=true)
	List<Joueur> findByPostAndEquipeNom(@Param("nom") String nom,@Param("poste") String poste);
}
