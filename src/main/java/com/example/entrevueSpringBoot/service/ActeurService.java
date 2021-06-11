/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.repository.ActeurRepository;
import java.util.List;
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
    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public Acteur addActeur(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public List<Acteur> getListActeurs() {
        return acteurRepository.findAll();
    }

    public Acteur getActeur(Long id) {
        Acteur acteur = new Acteur();
        if (acteurRepository.findById(id).isEmpty()) {
            return acteur;
        } else {
            return acteurRepository.findById(id).get();
        }
    }
}
