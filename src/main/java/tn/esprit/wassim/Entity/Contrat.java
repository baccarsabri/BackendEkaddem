package tn.esprit.wassim.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contrat {
   @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idContrat ;
    private Date dateDebutContrat;
    private Date  dateFinContrat ;
    @Enumerated(EnumType.STRING)
     private  Specialite Specialite ;
    private Boolean archive ;
    @ManyToOne
    private Etudiant etudiant ;



}
