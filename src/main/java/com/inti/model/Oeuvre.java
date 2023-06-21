package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@ToString

public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idOeuvre;
	@NonNull
	private String nomOeuvre;
	@NonNull
	private double dureeOeuvre;
	
	public Oeuvre() {}
	
}
