package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Soliste;
import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Controller
public class UtilisateurController {
	
	@Autowired
	IUtilisateurRepository iur;
	
	@GetMapping("creerUtilisateur")
	public String creerUtilisateur() {
		return "creerUtilisateur";
	}

	@PostMapping("saveUtilisateur")
	public String saveUtilisateur(@ModelAttribute("utilisateur") Utilisateur u) {
		iur.save(u);
		return "redirect:creerUtilisateur";
	}

}
