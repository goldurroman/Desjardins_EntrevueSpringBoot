/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.model.dto.ActeurDto;
import com.example.entrevueSpringBoot.model.dto.FilmDto;
import com.example.entrevueSpringBoot.service.ActeurService;
import com.example.entrevueSpringBoot.service.FilmService;
import java.util.List;
import java.util.stream.Collectors;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RomaG
 */
@RestController
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;
    private final ActeurService acteurService;

    @Autowired
    public FilmController(FilmService filmService,ActeurService acteurService) {
        this.filmService = filmService;
        this.acteurService = acteurService;
    }

    @PostMapping
    public ResponseEntity<FilmDto> addFilm(@RequestBody final FilmDto filmDto) {
        Film film = filmService.addFilm(Film.from(filmDto));        
        List<Acteur> acteurs = filmDto.getActeursDto().stream().map(Acteur::from).collect(Collectors.toList());
        for(Acteur acteur : acteurs){
        acteurService.addActeur(acteur);
        }
        return new ResponseEntity<>(FilmDto.from(film), HttpStatus.CREATED);
    }

    

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmDto> getFilm(@PathVariable final Long id) {
        Film film = filmService.getFilm(id);
        return new ResponseEntity<>(FilmDto.from(film), HttpStatus.OK);
    }
    
    
   }
