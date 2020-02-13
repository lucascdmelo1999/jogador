package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AlimentoDAO;
import com.example.demo.model.Alimento;
import com.example.demo.service.AlimentoService;

@Controller
public class AlimentoController {

	@Autowired
	private AlimentoService alimentoService;
	@Autowired
	private AlimentoDAO alimentoDAO;

	@GetMapping("/home")
	public String paginainicial() {
		return "/pagina-inicial";
	}

	@GetMapping("/listaralimento")
	public String listaralimento(Alimento alimento, Model model) {
		model.addAttribute("lista", this.alimentoDAO.findAll());
		return "Listas/listar-alimento";
	}

	@GetMapping("/cadastraralimento")
	public String cadastroalimento(Alimento alimento, Model model) {
		model.addAttribute("lista", this.alimentoDAO.findAll());
		return "Cadastros/cadastrar-alimento";
	}

	@PostMapping("/pesquisaralimento")
	public String pesquisaralimento(Alimento alimento, Model model) {
		// select nome from Alimento where nome LIKE %nome%;
		@SuppressWarnings("unchecked")
		List <Alimento> resultado = (List<Alimento>) this.alimentoDAO.findByNomeContainingIgnoreCase(alimento.getNome(), Sort.by("nome"));
		model.addAttribute("listaralimento", resultado);
		return "redirect:/listaralimento";
	}

	@PostMapping("/salvaralimento")
	public String salvarJogador(@Valid Alimento alimento, BindingResult br, Model model, RedirectAttributes ra,
			Errors errors) {

		if (errors.hasErrors()) {
			ra.addFlashAttribute("menssage", "erro");
			return "redirect:/cadastrarjogador";
		} else {
			try {
				this.alimentoService.salvaralimento(alimento);

			} catch (ServiceException | MessagingException e) {
				ra.addFlashAttribute("menssage", "Não foi possível cadastrar esse alimento: " + e.getMessage());
				ra.addFlashAttribute("alimento", alimento);
				return "redirect:/cadastraralimento";
			}
			ra.addFlashAttribute("menssage", "Conta criada com sucesso!");
		}
		return "redirect:/listaralimento";
	}

	

	@GetMapping("/removerAlimento")
	public String removerAlimento(Integer id) {
		this.alimentoService.remover(id);
		return "redirect:/listaralimento";
	}

	@GetMapping("/editarAlimento")
	public String editarAlimento(Integer id, Model model) {
		model.addAttribute("lista", this.alimentoService.obterPorId(id));
		return "redirect:/cadastraralimento";
	}

}
