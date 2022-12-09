package tn.esprit.wassim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wassim.Entity.Equipe;


@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}
