package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Oeuvre;

public interface IOeuvreRepository extends JpaRepository<Oeuvre, Integer>{

}
