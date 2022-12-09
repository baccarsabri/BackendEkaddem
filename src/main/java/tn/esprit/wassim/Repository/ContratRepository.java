package tn.esprit.wassim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wassim.Entity.Contrat;
@Repository
public interface ContratRepository extends JpaRepository <Contrat,Integer>  {

}
