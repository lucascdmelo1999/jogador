package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DAO.ClubeDAO;
import com.example.demo.model.Clube;
@Controller
public class ClubeController {
	@Autowired
	private ClubeDAO clubeDAO;
	
	@GetMapping("/cadastrarclub")
	public String cadastrojogador() {
		return "Cadastros/cadastro-club";
	}
	
	@PostMapping("/salvarclube")
	public String salvarCLube(@Valid Clube clube, BindingResult br) {
		if (br.hasErrors()) {
			return "redirect:/cadastrarclub";
		}
		this.clubeDAO.save(clube);		
		return "redirect:/home";
	}
}
