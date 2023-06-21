package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@Controller
@RequestMapping("/soliste")
public class SolisteController {
	
	@Autowired
	ISolisteRepository isr;
	
	@GetMapping("creerSoliste")
	public String formSoliste() {
		return "creerSoliste";
	}

	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste s) {
		isr.save(s);
		return "redirect:/listeSoliste";
	}

	@GetMapping("listeSoliste")
	public String listeSoliste(Model m) {
		m.addAttribute("listeSoliste", isr.findAll().toArray());
		System.out.println(isr.findAll());
		return "listeSoliste";
	}
	@GetMapping("getSoliste")
	public String getSoliste(@RequestParam("id") int id, Model m) {
		m.addAttribute("soliste", isr.findById(id).get());
		return "getSoliste";
	}
	@GetMapping("deleteSoliste")
	public String deleteSoliste(@RequestParam("id") int id) {
		isr.deleteById(id);
		return "redirect:/listeSoliste";
	}
	
	@GetMapping("modifierSoliste")
	public String modifierSoliste(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("soliste", isr.findById(id).get());
		return "modifierSoliste";
	}
	
	@PostMapping("updateSoliste")
	public String updateSoliste(@ModelAttribute("soliste") Soliste s)
	{
		isr.save(s);
		return "redirect:/listeSoliste";
	}

}
