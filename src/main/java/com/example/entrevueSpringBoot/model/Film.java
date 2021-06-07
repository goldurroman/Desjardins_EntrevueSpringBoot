/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.model;

import com.example.entrevueSpringBoot.model.dto.FilmDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "Film")
public class Film implements Serializable {

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
    private List<Acteur> acteurs = new ArrayList<>();
    
    public static Film from(FilmDto filmDto){
    Film film = new Film();
    film.setId(filmDto.getId());
    film.setTitre(filmDto.getTitre());
    film.setDescription(filmDto.getDescription());
    film.setActeurs(filmDto.getActeursDto().stream().map(Acteur::from).collect(Collectors.toList()));
    return film;
    }
    
    public Film() {
    }

    public void addActeur(Acteur acteur){
    acteurs.add(acteur);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public Film(Long id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

}
