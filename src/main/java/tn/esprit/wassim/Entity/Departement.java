package tn.esprit.wassim.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart ;
    private String nomDepart ;
    private String surNomDepart;

    @OneToMany  (mappedBy="dept")
    private List<Etudiant> etudiants ;
    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Demande> demandes;
    private String description;


}
