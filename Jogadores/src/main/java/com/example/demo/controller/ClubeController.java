package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DAO.ClubeDAO;
import com.example.demo.model.Clube;
@Controller
public class ClubeController {
	@Autowired
	private ClubeDAO clubeDAO;
	
	@GetMapping("/cadastrarclub")
	public String cadastroclub(Clube clube ) {
		return "Cadastros/cadastro-clube";
	}
	
	@PostMapping("/salvarclube")
	public String salvarCLube( Clube clube) {
		
		this.clubeDAO.save(clube);		
		return "redirect:/home";
	}
}
