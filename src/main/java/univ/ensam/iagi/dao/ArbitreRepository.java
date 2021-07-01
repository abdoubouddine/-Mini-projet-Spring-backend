package univ.ensam.iagi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.ensam.iagi.entities.Arbitre;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {

}
