package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "formLieu";
	}

	@PostMapping("saveLieu")
	public String saveLieu(@ModelAttribute("lieu") Lieu l) {
		ilr.save(l);
		return "redirect:/listeLieu";
	}

	@GetMapping("listeLieu")
	public String listeLieu(Model m) {
		m.addAttribute("listeLieu", ilr.findAll().toArray());
		System.out.println(ilr.findAll());
		return "listeLieu";
	}
	@GetMapping("getLieu")
	public String getLieu(@RequestParam("id") int id, Model m) {
		m.addAttribute("lieu", ilr.findById(id).get());
		return "getLieu";
	}
	@GetMapping("deleteLieu")
	public String deleteLieu(@RequestParam("id") int id) {
		ilr.deleteById(id);
		return "redirect:/listeLieu";
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
