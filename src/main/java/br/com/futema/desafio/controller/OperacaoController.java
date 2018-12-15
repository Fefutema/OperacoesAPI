package br.com.futema.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

	@GetMapping
	public ResponseEntity<?> buscaOperacoes() {
		
		
		return ResponseEntity.ok("Teste");
	}
	
}
