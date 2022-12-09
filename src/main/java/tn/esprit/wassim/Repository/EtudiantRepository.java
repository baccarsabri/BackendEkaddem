package tn.esprit.wassim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wassim.Entity.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {


}
