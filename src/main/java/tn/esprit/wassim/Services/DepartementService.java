package tn.esprit.wassim.Services;

import tn.esprit.wassim.Entity.Demande;
import tn.esprit.wassim.Entity.Departement;
import tn.esprit.wassim.Entity.Etudiant;

import java.util.List;

public interface DepartementService {
    public Departement Adddepartement(Departement departement) ;
    public Departement UpdateDepartment(int id , Departement departement) ;

    public String deleteDepartement(Departement departement) ;

    public List<Departement> getAllDepartements();

    public Departement getDepartementById(int id) ;
    public Demande addDemande(int idEtudiant , int idDepartement);
    public Boolean getDemandebyDepartAndEtud(Departement departement , Etudiant etudiant);
    public List<Demande> findDemandeByEtudiants(Etudiant etudiant);
    public Demande cancelDemande(int idEtudiant, int idDepartement);
    public int countPendingStatut(int idEtudiant);

}
