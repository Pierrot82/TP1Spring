package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Concert;
import com.inti.repository.IConcertRepository;

@Controller
public class ConcertController {
	
	@Autowired
	IConcertRepository icr;
	
	@GetMapping("creerConcert")
	public String formConcert() {
		return "formConcert";
	}

	@PostMapping("saveConcert")
	public String saveConcert(@ModelAttribute("concert") Concert s) {
		icr.save(s);
		return "redirect:/listeConcert";
	}

	@GetMapping("listeConcert")
	public String listeConcert(Model m) {
		m.addAttribute("listeConcert", icr.findAll().toArray());
		System.out.println(icr.findAll());
		return "listeConcert";
	}
	@GetMapping("getConcert")
	public String getConcert(@RequestParam("id") int id, Model m) {
		m.addAttribute("concert", icr.findById(id).get());
		return "getConcert";
	}
	@GetMapping("deleteConcert")
	public String deleteConcert(@RequestParam("id") int id) {
		icr.deleteById(id);
		return "redirect:/listeConcert";
	}
	
	@GetMapping("modifierConcert")
	public String modifierConcert(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("concert", icr.findById(id).get());
		return "modifierConcert";
	}
	
	@PostMapping("updateConcert")
	public String updateConcert(@ModelAttribute("concert") Concert s)
	{
		icr.save(s);
		return "redirect:/listeConcert";
	}

}
