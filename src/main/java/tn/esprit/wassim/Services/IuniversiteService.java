package tn.esprit.wassim.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.wassim.Entity.Universite;
import tn.esprit.wassim.Repository.UniveristeRepository;

@Service
public class IuniversiteService implements UniversiteService{
    @Autowired
    UniveristeRepository univeristeRepository;

    @Override
    public Universite getUniversiteById(int id){
        return univeristeRepository.findById(id).orElse(null);

    }
}
