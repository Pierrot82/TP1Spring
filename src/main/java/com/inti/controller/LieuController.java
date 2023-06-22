package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Lieu;
import com.inti.repository.ILieuRepository;

@Controller
@RequestMapping("lieu")
public class LieuController {
	
	@Autowired
	ILieuRepository ilr;
	
	@GetMapping("creerLieu")
	public String formLieu() {
		return "creerLieu";
	}

	@PostMapping("saveLieu")
	public String saveLieu(@ModelAttribute("lieu") Lieu l) {
		ilr.save(l);
		//return "redirect:/listeLieu";
		return "redirect:/lieu/creerLieu";
		
		
	}

	@GetMapping("listeLieu")
	public String listeLieu(Model m) {
		
		m.addAttribute("listeLieu", ilr.findAll());
		
		return "listeLieu";
	}
	
	@GetMapping("getLieu/{id}")
	public String getLieu(@PathVariable("id") int id, Model m) {
		
		
		m.addAttribute("lieu1", ilr.findById(id).get());
		
		return "getLieu";
	}
	


	
	@GetMapping("deleteLieu/{id}")
	public String deleteLieu(@PathVariable("id") int id) {

		ilr.deleteById(id);
		return "redirect:/lieu/listeLieu";
	}
	
	@GetMapping("modifierLieu")
	public String modifierLieu(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("lieu", ilr.findById(id).get());
		return "modifierLieu";
	}
	
	@PostMapping("updateLieu")
	public String updateLieu(@ModelAttribute("lieu") Lieu l)
	{
		ilr.save(l);
		return "redirect:/listeLieu";
	}

}
