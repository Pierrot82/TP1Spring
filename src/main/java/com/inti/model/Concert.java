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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroConcert;
	@NonNull
	private String nomConcert;
	private LocalDate dateConcert;
	
	public Concert(@NonNull String nomConcert, LocalDate dateConcert) {
		super();
		this.nomConcert = nomConcert;
		this.dateConcert = dateConcert;
	}
}
