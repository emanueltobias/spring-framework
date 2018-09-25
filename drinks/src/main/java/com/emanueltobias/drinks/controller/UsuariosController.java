package com.emanueltobias.drinks.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emanueltobias.drinks.model.Usuario;

@Controller
public class UsuariosController{

	@RequestMapping("usuarios/novo")
	public String novo(Usuario usuario) {
		// model.addAttribute(new Cerveja());
		return "usuario/CadastroUsuario";
	}

	@RequestMapping(value = "usuarios/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// model.addAttribute(cerveja);
			// model.addAttribute("mensagem", "Erro formulário");
			return novo(usuario);
		}

		// Salvar no banco de dados...
		System.out.println(">>>> Usuario:" + usuario.getNome());
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		return "redirect:/usuarios/novo";
	}


}
