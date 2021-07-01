package univ.ensam.iagi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import univ.ensam.iagi.entities.*;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

	@Query("from Match m where m.idMatch= :id ")
	List<Stade> findByMatchesId(@Param("id") Long id);
	
}
