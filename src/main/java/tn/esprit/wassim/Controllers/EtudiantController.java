package tn.esprit.wassim.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wassim.Entity.Etudiant;
import tn.esprit.wassim.Services.EtudiantService;

import java.util.List;
@RestController
@RequestMapping("etudiants")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService ;

@Autowired


    @GetMapping
    public List<Etudiant> displayEtudiants (){
        return etudiantService.getAllEtudiants() ;
    }
@PostMapping
    public Etudiant addEtudiant (@RequestBody Etudiant etudiant){

        return etudiantService.addEtudiant(etudiant);

    }

 @PutMapping("{id}")
    public Etudiant updateetudiant (@PathVariable("id")int id ,@RequestBody Etudiant etudiant){
return etudiantService.updateEtudiant(id,etudiant) ;

 }
@DeleteMapping("{id}")
    public String deleteEtudiant(@PathVariable("id")int id){
    return etudiantService.deleteEtudiant(etudiantService.getById(id));
    }
    @GetMapping("{id}")
    public Etudiant getEtudiantById(@PathVariable("id")int id){
        return etudiantService.getById(id) ;
    }

    @PutMapping("/assign/{IdEtudiant}/{idDepart}")
    public void assignEtudiantToDepartement (@PathVariable ("IdEtudiant") Integer IdEtudiant,@PathVariable ("idDepart") Integer idDepart){
       etudiantService.assignEtudiantToDepartement(IdEtudiant,idDepart);
       return;
    }
    @PostMapping("/assignT/{idContrat}/{idEquipe}")
    public void  addAndAssignEtudiantToEquipeAndContract(@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquipe")Integer idEquipe,@RequestBody Etudiant etudiant){

  /////////
        // Etudiant etudiant1=etudiantService.getById(IdEtudiant);

    etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);
    return;
    }

    }