package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.ChefOrchestre;
import com.inti.repository.IChefOrchestreRepository;

@Controller
@RequestMapping("chef_orchestre")
public class ChefOrchestreController {
	
	@Autowired
	IChefOrchestreRepository icor;
	
	@GetMapping("creerChefOrchestre")
	public String formChefOrchestre() {
		return "creerChefOrchestre";
	}

	@PostMapping("saveChefOrchestre")
	public String saveChefOrchestre(@ModelAttribute("chefOrchestre") ChefOrchestre co) {
		icor.save(co);
		return "redirect:/listeChefOrchestre";
	}

	@GetMapping("listeChefOrchestre")
	public String listeChefOrchestre(Model m) {
		m.addAttribute("listeChefOrchestre", icor.findAll().toArray());
		return "listeChefOrchestre";
	}
	@GetMapping("deleteChefOrchestre")
	public String deleteChefOrchestre(@RequestParam("id") int id) {
		icor.deleteById(id);
		return "redirect:/listeChefOrchestre";
	}
	
	@GetMapping("modifierChefOrchestre")
	public String modifierChefOrchestre(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("chefOrchestre", icor.findById(id).get());
		return "modifierChefOrchestre";
	}
	
	@PostMapping("updateChefOrchestre")
	public String updateChefOrchestre(@ModelAttribute("chefOrchestre") ChefOrchestre co)
	{
		icor.save(co);
		return "redirect:/listeChefOrchestre";
	}

}
