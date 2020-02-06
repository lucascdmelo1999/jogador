package com.example.demo.controller;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.DAO.ClubeDAO;
import com.example.demo.model.Jogador;
import com.example.demo.service.JogadorService;

@Controller
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;
	@Autowired
	private ClubeDAO clubeDAO;
	
	@GetMapping("/cadastrarjogador")
	public String cadastrojogador(Jogador jogador, Model model) {
		model.addAttribute("lista", this.clubeDAO.findAll());
		return "Cadastros/cadastro-jogador";
	}
	
	@GetMapping("/fichacadastrojogador")
	public String fichacadastrojogador() {
		return"Listas/fichacadastrojogador";
	}
	
	//@PostMapping("/salvarJogador")
//	public String salvarJogador( Jogador jogador) {
		
		//this.jogadorService.save(jogador);		
		//return "redirect:/home";
	//}
	
	@PostMapping("/salvarJogador")
	public String salvarJogador(@Valid Jogador jogador, 
			BindingResult br,Model model, RedirectAttributes ra,Errors errors) {
		
		if (errors.hasErrors()) {
			ra.addFlashAttribute("menssage", "erro");
			return "redirect:/cadastrarjogador";
		} else {
			try {
				this.jogadorService.salvarJogador(jogador);

			} catch (ServiceException | MessagingException e) {
				ra.addFlashAttribute("menssage", "Não foi possível criar usuário: " + e.getMessage());
                ra.addFlashAttribute("jogador", jogador);
				return "redirect:/cadastrarjogador";
			}
			    ra.addFlashAttribute("menssage", "Conta criada com sucesso!");
		}
		return "redirect:/home";
	}
}
