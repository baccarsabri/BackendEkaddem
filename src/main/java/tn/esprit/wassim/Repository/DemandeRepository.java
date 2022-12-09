package tn.esprit.wassim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wassim.Entity.Demande;
import tn.esprit.wassim.Entity.Departement;
import tn.esprit.wassim.Entity.Etudiant;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande,Integer> {
    public Demande findDemandeByDepartementAndEtudiants(Departement departement, Etudiant etudiant);
    public List<Demande> findDemandeByEtudiants(Etudiant etudiant);
    public int countByStatutAndEtudiants(String statut , Etudiant etudiant);
}
