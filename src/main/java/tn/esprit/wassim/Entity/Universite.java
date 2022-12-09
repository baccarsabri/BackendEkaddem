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
@AllArgsConstructor
@NoArgsConstructor

public class Universite {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int idUniv;
    private  String nomUniv ;

@OneToMany
private List<Departement> departemnts ;
@Enumerated(EnumType.STRING)
    private Niveau niveau ;

}
