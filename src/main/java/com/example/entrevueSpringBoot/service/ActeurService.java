/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.repository.ActeurRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RomaG
 */
@Service
public class ActeurService {
    
    private final ActeurRepository acteurRepository;
    
    @Autowired
    public ActeurService(ActeurRepository acteurRepository){
    this.acteurRepository=acteurRepository;
    }
    
    public Acteur addActeur(Acteur acteur){
    return acteurRepository.save(acteur);
    }
    
    public List<Acteur> getListActeurs(){
    return StreamSupport.stream(acteurRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }
    
    public Acteur getActeur(Long id){
        try {
            return acteurRepository.findById(id).orElseThrow(()->
                    new ClassNotFoundException());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActeurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
   
    }
}
