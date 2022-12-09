package tn.esprit.wassim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wassim.Entity.Universite;


@Repository
public interface UniveristeRepository extends JpaRepository<Universite,Integer> {
}
