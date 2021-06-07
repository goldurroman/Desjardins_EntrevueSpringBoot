/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RomaG
 */
@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final ActeurService acteurService;

    @Autowired
    public FilmService(FilmRepository filmRepository, ActeurService acteurService) {
        this.filmRepository = filmRepository;
        this.acteurService = acteurService;
    }
    
    public Film addFilm(Film film){
    return filmRepository.save(film);
    }
    
    public List<Film> getListFilms(){
    return StreamSupport.stream(filmRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }
    
    public Film getFilm(Long id){
        try {
            return filmRepository.findById(id).orElseThrow(()->
                    new ClassNotFoundException());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Transactional
    public Film addActeurToFilm(Long filmId, Long acteurId){
        Film film = getFilm(filmId);
        Acteur acteur = acteurService.getActeur(acteurId);
     List<Acteur> acteurs = Arrays.asList(acteur);
        film.setActeurs(acteurs);
            return film;
    }
    
}
