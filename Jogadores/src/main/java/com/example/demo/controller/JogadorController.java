package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DAO.ClubeDAO;
import com.example.demo.DAO.JogadorDAO;
import com.example.demo.model.Jogador;

@Controller
public class JogadorController {

	@Autowired
	private JogadorDAO jogadorDAO;
	@Autowired
	private ClubeDAO clubeDAO;
	
	@GetMapping("/cadastrarjogador")
	public String cadastrojogador(Jogador jogador, Model model) {
		model.addAttribute("lista", this.clubeDAO.findAll());
		return "Cadastros/cadastro-jogador";
	}
	
	@PostMapping("/salvarJogador")
	public String salvarJogador( Jogador jogador) {
		
		this.jogadorDAO.save(jogador);		
		return "redirect:/home";
	}
}
