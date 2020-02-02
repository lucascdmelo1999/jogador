package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DAO.JogadorDAO;
import com.example.demo.model.Jogador;

@Controller
public class JogadorController {

	@Autowired
	private JogadorDAO jogadorDAO;
	
	@GetMapping("/cadastrarjogador")
	public String cadastrojogador(Jogador jogador) {
		return "Cadastros/cadastro-jogador";
	}
	
	@PostMapping("/salvarJogador")
	public String salvarJogador( Jogador jogador) {
		
		this.jogadorDAO.save(jogador);		
		return "redirect:/home";
	}
}
