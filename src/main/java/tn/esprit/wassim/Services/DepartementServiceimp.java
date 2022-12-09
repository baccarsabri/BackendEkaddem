package tn.esprit.wassim.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.wassim.Entity.Demande;
import tn.esprit.wassim.Entity.Departement;
import tn.esprit.wassim.Entity.Etudiant;
import tn.esprit.wassim.Repository.DemandeRepository;
import tn.esprit.wassim.Repository.DepartementRepository;
import tn.esprit.wassim.Repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class DepartementServiceimp implements DepartementService {

@Autowired
    DepartementRepository departementRepository ;
@Autowired
    EtudiantRepository etudiantRepository;
@Autowired
    DemandeRepository demandeRepository;

@Override
public Departement Adddepartement (Departement departement) {
    return departementRepository.save(departement);

}
@Override
    public Departement UpdateDepartment (int id,Departement departement) {

    Departement dep1 = departementRepository.findById(id).orElse(null);
    if (dep1!=null){
        ////   etudiant1.setEquipes(etudiant.getEquipes());
        dep1.setNomDepart(departement.getNomDepart());
      

        return departementRepository.save(dep1);
    }
    else return null;

}
    @Override
    public String deleteDepartement(Departement departement) {
        if(departement != null){
            departementRepository.delete(departement);
            return "Deleted";
        }
        return " not existant";
    };
    @Override
    public List<Departement> getAllDepartements(){
        return departementRepository.findAll();
    };
    @Override
    public Departement getDepartementById (int id) {
        return departementRepository.findById(id).orElse(null);
    };

    @Override
    public Demande addDemande(int idEtudiant , int idDepartement){
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);;
        Departement departement=departementRepository.findById(idDepartement).orElse(null);;
        Demande demande=new Demande();
        demande.setEtudiants(etudiant);
        demande.setDepartement(departement);
        List<Demande> demandes=new ArrayList<Demande>();
        demandes.add(demande);
        etudiant.setDemandes(demandes);
        departement.setDemandes(demandes);
        return demandeRepository.save(demande);
    }
    @Override
    public Boolean getDemandebyDepartAndEtud(Departement departement , Etudiant etudiant){
        Demande d= demandeRepository.findDemandeByDepartementAndEtudiants(departement,etudiant);
        if(d!=null){
            return true;
        }
        else return false;
    }
    @Override
    public List<Demande> findDemandeByEtudiants(Etudiant etudiant){
        return demandeRepository.findDemandeByEtudiants(etudiant);
    }
    @Override
    public Demande cancelDemande(int idEtudiant, int idDepartement){
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);;;
        Departement departement=departementRepository.findById(idDepartement).orElse(null);
        Demande demande=demandeRepository.findDemandeByDepartementAndEtudiants(departement,etudiant);
        demande.setStatut("Canceled");
        return demandeRepository.save(demande);
    }
    @Override
    public int countPendingStatut(int idEtudiant){
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);
        return demandeRepository.countByStatutAndEtudiants("Pending",etudiant);

    }

}
