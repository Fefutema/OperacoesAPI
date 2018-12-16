package br.com.futema.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.futema.desafio.persistencia.model.Operacao;
import br.com.futema.desafio.service.OperacaoService;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

	@Autowired
	private OperacaoService operacaoService;
	
	@PostMapping
	public ResponseEntity<?> salvarOperacao(@Valid @RequestBody Operacao operacao) {
		return ResponseEntity.ok(operacaoService.enviarFilaSalvar(operacao));
	}
	
	@GetMapping
	public ResponseEntity<?> buscaOperacoes(@RequestParam(defaultValue = "1", value = "pagina") int pagina,
			@RequestParam(defaultValue = "10", value = "tamanho") int tamanho) {
		
		return ResponseEntity.ok(operacaoService.buscarPaginado(pagina, tamanho));
	}
	
}
