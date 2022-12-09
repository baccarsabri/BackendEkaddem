package tn.esprit.wassim.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.wassim.Entity.Contrat;
import tn.esprit.wassim.Entity.Departement;
import tn.esprit.wassim.Entity.Equipe;
import tn.esprit.wassim.Entity.Etudiant;
import tn.esprit.wassim.Repository.ContratRepository;
import tn.esprit.wassim.Repository.DepartementRepository;
import tn.esprit.wassim.Repository.EquipeRepository;
import tn.esprit.wassim.Repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service


public class IEtudiantServiceimp implements EtudiantService {


    @Autowired
    EtudiantRepository etudiantRepository;

   @Autowired
    DepartementRepository departementRepository ;
   @Autowired
    ContratRepository contratRepository ;
   @Autowired
    EquipeRepository equipeRepository ;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }



    @Override
    public Etudiant updateEtudiant(int id,Etudiant etudiant) {
       Etudiant etudiant1 = etudiantRepository.findById(id).orElse(null);
        if (etudiant1!=null){
         ////   etudiant1.setEquipes(etudiant.getEquipes());
         etudiant1.setPrenomE(etudiant.getPrenomE());
         etudiant1.setNomE(etudiant.getNomE());

            return etudiantRepository.save(etudiant1);
        }
        else return null;
    }



    @Override
    public String deleteEtudiant(Etudiant etudiant) {
        if(etudiant != null){
            etudiantRepository.delete(etudiant);
            return "etudiant supprimé";
        }
        return "etudiant non existant";

    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getById(int id) {
        return etudiantRepository.findById(id).orElse(null);

    }

    @Override
    public void  assignEtudiantToDepartement(Integer IdEtudiant, Integer idDepart) {
        Etudiant etudiant= etudiantRepository.findById(IdEtudiant).orElse(null) ;
        Departement departement=departementRepository.findById(idDepart).orElse(null) ;
        if (etudiant!=null && departement!=null) {
            etudiant.setDept(departement);
            etudiantRepository.save(etudiant);
        }

    }

    @Override
    public void addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Integer idContrat, Integer idEquipe) {
etudiantRepository.save(etudiant) ; 

        Contrat contrat=contratRepository.findById(idContrat).orElse(null) ;
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        if ( contrat!=null && equipe!=null ){
            contrat.setEtudiant(etudiant);


          /////////  etudiant1.getEquipes().add(equipe);


           // etudiant1.setEquipes(etudiant1);
         equipe.getEtudiants().add(etudiant);
         etudiant.getEquipes().add(equipe);
            contrat.setEtudiant(etudiant);


            etudiantRepository.save(etudiant);

            contratRepository.save(contrat);
            equipeRepository.save(equipe);

        }
else System.out.println("erah");
    }


}

