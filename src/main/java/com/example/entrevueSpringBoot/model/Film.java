/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.model;

import com.example.entrevueSpringBoot.model.dto.FilmDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author RomaG
 */
@Data
@Entity
public class Film {

    @Id
    private Long id;
    private String titre;
    private String description;
    @JsonIgnore
    @OneToMany(
            mappedBy = "film",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Acteur> acteurs;

    public static Film from(FilmDto filmDto) {
        Film film = new Film();
        film.setId(filmDto.getId());
        film.setTitre(filmDto.getTitre());
        film.setDescription(filmDto.getDescription());
        film.setActeurs(filmDto.getActeursDto().stream().map(Acteur::from).collect(Collectors.toList()));
        return film;
    }

}
