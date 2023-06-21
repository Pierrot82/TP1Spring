package com.inti.model;

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
public class Lieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeLieu;
	@NonNull
	private String nomLieu;
	private String rue;
	private int nombreFauteuils;
	
	public Lieu(@NonNull String nomLieu, String rue, int nombreFauteuils) {
		super();
		this.nomLieu = nomLieu;
		this.rue = rue;
		this.nombreFauteuils = nombreFauteuils;
	}
}
