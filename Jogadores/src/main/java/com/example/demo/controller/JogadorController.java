package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DAO.JogadorDAO;
import com.example.demo.model.Jogador;

@Controller
public class JogadorController {

	@Autowired
	private JogadorDAO jogadorDAO;
	
	@GetMapping("/cadastrarjogador")
	public String cadastrojogador() {
		return "Cadastros/cadastro-jogador";
	}
	
	@PostMapping("/salvarJogador")
	public String salvarJogador(@Valid Jogador jogador, BindingResult br) {
		if (br.hasErrors()) {
			return "redirect:/cadastrarjogador";
		}
		this.jogadorDAO.save(jogador);		
		return "redirect:/home";
	}
}
