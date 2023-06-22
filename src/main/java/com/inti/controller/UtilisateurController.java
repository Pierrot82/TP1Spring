package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {
	
	@GetMapping("creerUtilisateur")
	public String creerUtilisateur() {
		return "creerUtilisateur";
	}

}
