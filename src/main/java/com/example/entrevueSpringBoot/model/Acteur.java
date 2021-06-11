/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.model;

import com.example.entrevueSpringBoot.model.dto.ActeurDto;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author RomaG
 */
@Data
@Entity
public class Acteur {

    @Id
    private Long id;
    private String nom;
    private String prenom;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private Film film;

    public Acteur() {
    }

    public static Acteur from(ActeurDto acteurDto) {
        Acteur acteur = new Acteur();
        acteur.setId(acteurDto.getId());
        acteur.setNom(acteurDto.getNom());
        acteur.setPrenom(acteurDto.getPrenom());
        return acteur;
    }
}
