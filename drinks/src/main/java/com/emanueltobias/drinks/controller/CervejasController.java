/**
 * @author Emanuel
 *
 */
package com.emanueltobias.drinks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emanueltobias.drinks.controller.page.PageWrapper;
import com.emanueltobias.drinks.dto.CervejaDTO;
import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.model.Origem;
import com.emanueltobias.drinks.model.Sabor;
import com.emanueltobias.drinks.repository.Cervejas;
import com.emanueltobias.drinks.repository.Estilos;
import com.emanueltobias.drinks.repository.filter.CervejaFilter;
import com.emanueltobias.drinks.service.CadastroCervejaService;
import com.emanueltobias.drinks.service.excepition.ImpossivelExcluirEntidadeException;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@Autowired
	private Cervejas cervejas;

	@RequestMapping("/nova")
	public ModelAndView nova(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}

	@RequestMapping(value = { "/nova", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return nova(cerveja);
		}
		
		

		// Salvar no banco de dados...
		System.out.println(">>>> Sku: " + cerveja.getSku());
		System.out.println(">>> sabor: " + cerveja.getSabor());
		System.out.println(">>> origem: " + cerveja.getOrigem());
		System.out.println(">>> estilo: " + cerveja.getEstilo());
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso !");
		return new ModelAndView("redirect:/cervejas/nova");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result
			,@PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		
		PageWrapper<Cerveja> paginaWrapper = new PageWrapper<>(cervejas.filtrar(cervejaFilter, pageable),
				httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CervejaDTO> pesquisar(String skuOuNome) {
		return cervejas.porSkuOuNome(skuOuNome);
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Cerveja cerveja) {
		try {
		cadastroCervejaService.excluir(cerveja);
		} catch (ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().build();

	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Cerveja cerveja) {
		ModelAndView mv = nova(cerveja);
		return mv.addObject(cerveja);
	}
}

