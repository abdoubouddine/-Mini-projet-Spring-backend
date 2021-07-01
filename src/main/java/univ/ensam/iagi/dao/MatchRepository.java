package univ.ensam.iagi.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import univ.ensam.iagi.entities.*;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

	@Query(value="SELECT * FROM matches WHERE YEAR(date_match)= :year AND MONTH(date_match)= :month AND DAY(date_match)=:day",nativeQuery=true)
	List<Match> findByDateMatch(@Param("year") int y,@Param("month") int m,@Param("day") int d);
	
	@Query(value="SELECT stade_id_stade FROM matches WHERE id_match=:id",nativeQuery=true)
	Long findStadeById(@Param("id") Long id);
}
