/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RomaG
 */
public interface ActeurRepository extends JpaRepository<Acteur, Long>{
    
}
