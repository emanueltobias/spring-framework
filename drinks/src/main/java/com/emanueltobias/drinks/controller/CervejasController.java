/**
 * @author Emanuel
 *
 */
package com.emanueltobias.drinks.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emanueltobias.drinks.model.Cerveja;

@Controller
public class CervejasController {

	//private static final Logger logger = LoggerFactory.getLogger(CervejasController.class); 
	@RequestMapping("cervejas/novo")
	public String novo(Cerveja cerveja) {
		
		/*if (logger.isDebugEnabled()) {
			logger.debug("O objeto cerveja é: " + cerveja);
		}
		logger.error("Aqui é um log nível error");
		logger.info("Aqui é um log nível info");*/
		// model.addAttribute(new Cerveja());
		return "cerveja/CadastroCerveja";
	}

	@RequestMapping(value = "cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// model.addAttribute(cerveja);
			// model.addAttribute("mensagem", "Erro formulário");
			return novo(cerveja);
		}

		// Salvar no banco de dados...
		System.out.println(">>>> Sku:" + cerveja.getSku() + cerveja.getNome());
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		return "redirect:/cervejas/novo";
	}


}
