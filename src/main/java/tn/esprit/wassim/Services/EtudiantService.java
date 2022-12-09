package tn.esprit.wassim.Services;

import tn.esprit.wassim.Entity.Etudiant;
import tn.esprit.wassim.Entity.Departement;

import java.util.List;

public interface EtudiantService {
    public Etudiant addEtudiant(Etudiant etudiant) ;

    Etudiant updateEtudiant(int id,Etudiant etudiant);

    public String deleteEtudiant(Etudiant etudiant) ;
    public List<Etudiant> getAllEtudiants();

    public Etudiant getById (int id) ;

    public void assignEtudiantToDepartement (Integer IdEtudiant, Integer
            idDepart);
   public void  addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Integer idContrat,
                                                     Integer idEquipe);
}
