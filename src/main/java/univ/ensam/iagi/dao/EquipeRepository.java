package univ.ensam.iagi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import univ.ensam.iagi.entities.*;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	@Query(value="SELECT * FROM Equipe WHERE pays LIKE :pays",nativeQuery=true)
	List<Equipe> findByPays(@Param("pays") String pays);
	
	@Query(value="SELECT * FROM Equipe e,matches_equipes me WHERE me.id_match= :id AND me.id_equipe=e.id_equipe",nativeQuery=true)
	List<Equipe> getEquipesByMatchId(@Param("id") Long id);
	
	@Query(value="DELETE FROM Equipe")
	void deleteAll();
}
