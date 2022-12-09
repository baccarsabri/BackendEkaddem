package tn.esprit.wassim.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdDemande ;
    @JsonIgnore
    @ManyToOne()
    private Etudiant etudiants;
    @ManyToOne()
    private Departement departement;
    private String statut="Pending";
    private LocalDateTime date = LocalDateTime.now();

}
