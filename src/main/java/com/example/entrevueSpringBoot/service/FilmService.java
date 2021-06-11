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

    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> getListFilms() {
        return filmRepository.findAll();
    }

    public Film getFilm(Long id) {
        Film film = new Film();
        if (filmRepository.findById(id).isEmpty()) {
            return film;
        } else {
            return filmRepository.findById(id).get();
        }
    }

    @Transactional
    public Film addActeurToFilm(Long filmId, Long acteurId) {
        Film film = getFilm(filmId);
        Acteur acteur = acteurService.getActeur(acteurId);
        List<Acteur> acteurs = Arrays.asList(acteur);
        film.setActeurs(acteurs);
        return film;
    }

}
