/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author RomaG
 */
public interface FilmRepository extends JpaRepository<Film, Long> {
    
}
