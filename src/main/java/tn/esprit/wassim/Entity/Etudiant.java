package tn.esprit.wassim.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdEtudiant ;
    private String prenomE ;
    private String nomE ;
    private String email;
   @Enumerated(EnumType.STRING)
    private Option option ;

   @OneToMany (mappedBy = "etudiant")
   @JsonIgnore
   private List<Contrat>  contrats ;
   @JsonIgnore
   @ManyToOne
   private  Departement dept ;
   @ManyToMany(fetch=FetchType.EAGER)

   private List<Equipe> equipes ;
    @JsonIgnore
   @OneToMany()
    private List<Demande> demandes;
}
