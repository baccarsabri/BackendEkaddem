package tn.esprit.wassim.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wassim.Entity.*;
import tn.esprit.wassim.Services.DepartementService;
import tn.esprit.wassim.Services.EtudiantService;
import tn.esprit.wassim.Services.UniversiteService;
import tn.esprit.wassim.Utils.EmailService;


import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("departements")
@Slf4j
public class DepartementController {
    @Autowired
    DepartementService depService ;
    @Autowired
    UniversiteService universiteService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    EmailService emailService;



    @GetMapping
    public List<Departement> displayDepartements (){
        return depService.getAllDepartements() ;
    }
    @PostMapping
    public Departement addDepartement (@RequestBody Departement departement){

        return depService.Adddepartement(departement);

    }

    @PutMapping("{id}")
    public Departement updateDept (@PathVariable("id")int id , @RequestBody Departement Dept){
        return depService.UpdateDepartment(id,Dept) ;

    }
    @DeleteMapping("{id}")
    public String deleteDept(@PathVariable("id")int id){
        return depService.deleteDepartement(depService.getDepartementById(id));
    }

    @GetMapping("{id}")
    public Departement getDeptById(@PathVariable("id")int id){
        return depService.getDepartementById(id) ;
    }

   @GetMapping("/universite/{id}")
    public Universite getUniversiteById(@PathVariable("id")int id){
        Universite u=universiteService.getUniversiteById(id) ;
        return  u;
    }
    @PostMapping("/addDemande/{idEtudiant}/{idDepartement}")
    public Demande addDemande(@PathVariable("idEtudiant") int idEtudiant , @PathVariable("idDepartement") int idDepartement){
        if(depService.countPendingStatut(idEtudiant)>=5){
            return null;
        }else{
            Etudiant etudiant=etudiantService.getById(idEtudiant);
            Departement departement=depService.getDepartementById(idDepartement);
            EmailDetails emailDetails=new EmailDetails();
            emailDetails.setRecipient(etudiant.getEmail());
            emailDetails.setSubject("Demande de rejoidre Departement");
            emailDetails.setMsgBody("Votre demande de rejoindre le departement "+departement.getNomDepart()+" a été Crée avec Succées");
            String mailer=emailService.sendSimpleMail(emailDetails);
            log.info("this:::::::::::::::"+mailer);
            return depService.addDemande(idEtudiant,idDepartement);
        }



    }
    @GetMapping("/demand/{idDept}/{idEtudiant}")
    public Verify getDemandeByDeptAndEtud(@PathVariable("idDept")int idDept , @PathVariable("idEtudiant")int idEtudiant  ){
        Departement d=depService.getDepartementById(idDept) ;
        Etudiant etudiant= etudiantService.getById(idEtudiant);
       Verify v=new Verify(depService.getDemandebyDepartAndEtud(d,etudiant));
       return v;

    }
    @GetMapping("/demand/{idEtudiant}")
    public List<Demande> findDemandeByEtudiants(@PathVariable("idEtudiant")int idEtudiant){
        Etudiant e=etudiantService.getById(idEtudiant);
        return depService.findDemandeByEtudiants(e);
    }
    @PutMapping("/demand/{idEtudiant}/{idDepartement}")
    public Demande cancelDemande(@PathVariable("idEtudiant")int idEtudiant,@PathVariable("idDepartement") int idDepartement){
        return depService.cancelDemande(idEtudiant,idDepartement);
    }
}
