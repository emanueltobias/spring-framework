package com.emanueltobias.drinks.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emanueltobias.drinks.model.Cidade;

@Controller
public class CidadesController{

	@RequestMapping("cidades/novo")
	public String novo(Cidade cidade) {
		// model.addAttribute(new Cerveja());
		return "cidade/CadastroCidade";
	}

	@RequestMapping(value = "estados/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// model.addAttribute(cerveja);
			// model.addAttribute("mensagem", "Erro formulário");
			return novo(cidade);
		}

		// Salvar no banco de dados...
		System.out.println(">>>> Cidade	:" + cidade.getNome());
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		return "redirect:/usuarios/novo";
	}


}
