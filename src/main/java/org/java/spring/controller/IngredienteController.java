package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Ingrediente;
import org.java.spring.db.serv.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class IngredienteController {

	@Autowired
	IngredienteService ingredienteService;

	@GetMapping("/ingredienti")
	public String indexIngredienti(Model model) {
		List<Ingrediente> ingredienti = ingredienteService.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "indexIngredienti";
	}

	@PostMapping("/ingredienti")
	public String addIngrediente(@ModelAttribute Ingrediente ingrediente) {
		ingredienteService.save(ingrediente);
		return "redirect:/indexIngredienti";
	}

	@GetMapping("/ingredienti/create")
	public String createIngredienti(Model model) {

		model.addAttribute("ingrediente", new Ingrediente());

		return "ingredienteForm";
	}

	@PostMapping("/ingredienti/create")
	public String storeIngredient(Model model, @Valid @ModelAttribute Ingrediente ingrediente,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("ingrediene", ingrediente);

			return "ingredienteForm";
		}

		ingredienteService.save(ingrediente);

		return "redirect:/ingredienti";
	}
}