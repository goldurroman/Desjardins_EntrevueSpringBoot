/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.model.dto;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * @author RomaG
 */
@Data
public class FilmDto {
    private Long id;
    private String titre;
    private String description;
    private List<ActeurDto> acteursDto = new ArrayList<>();

    
    public static FilmDto from(Film film){
    FilmDto filmDto = new FilmDto();
    filmDto.setId(film.getId());
    filmDto.setTitre(film.getTitre());
    filmDto.setDescription(film.getDescription());
    filmDto.setActeursDto(film.getActeurs().stream().map(ActeurDto::from).collect(Collectors.toList()));
    return filmDto;
    }
}
