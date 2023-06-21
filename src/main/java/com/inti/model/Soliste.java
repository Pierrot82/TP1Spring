package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soliste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int num;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;

}
