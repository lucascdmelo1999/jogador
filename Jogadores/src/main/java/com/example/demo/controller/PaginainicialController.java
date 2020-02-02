package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginainicialController {

	@GetMapping("/home")
	public String paginainicial() {
		return "pagina-inicial";
	}

}
