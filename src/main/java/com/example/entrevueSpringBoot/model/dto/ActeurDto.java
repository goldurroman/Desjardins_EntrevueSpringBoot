/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.model.dto;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import lombok.Data;

/**
 *
 * @author RomaG
 */
@Data
public class ActeurDto {

    private Long id;
    private String nom;
    private String prenom;
    private Film film;

    public static ActeurDto from(Acteur acteur) {
        ActeurDto acteurDto = new ActeurDto();
        acteurDto.id = acteur.getId();
        acteurDto.nom = acteur.getNom();
        acteurDto.prenom = acteur.getPrenom();
        return acteurDto;
    }

}
