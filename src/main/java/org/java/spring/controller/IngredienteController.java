package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Ingrediente;
import org.java.spring.db.repo.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredienteController {

	@Autowired
	IngredienteRepository ingredienteRepository;

	@GetMapping("/ingredienti")
	public String indexIngredienti(Model model) {
		List<Ingrediente> ingredienti = ingredienteRepository.findAll();
		model.addAttribute("ingredienti", ingredienti);
		model.addAttribute("ingrediente", new Ingrediente());
		return "indexIngredienti";
	}

	@PostMapping("/ingredienti")
	public String addIngrediente(@ModelAttribute Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return "redirect:/indexIngredienti";
	}

	@GetMapping("/ingredienti/delete/{id}")
	public String deleteIngrediente(@PathVariable("id") int id) {
		ingredienteRepository.deleteById(id);
		return "redirect:/indexIngredienti";
	}
}