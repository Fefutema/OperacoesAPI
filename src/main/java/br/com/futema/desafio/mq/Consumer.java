package br.com.futema.desafio.mq;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.futema.desafio.persistencia.model.Operacao;
import br.com.futema.desafio.persistencia.model.Titulo;
import br.com.futema.desafio.persistencia.repository.OperacaoRepository;

@Service
public class Consumer {

	@Autowired
	private OperacaoRepository operacaoRepository;
	
	@JmsListener(destination = "queue.operacoes")
	public void consumeQueue(String json) {
		Gson gson = new Gson();
		Operacao operacao = gson.fromJson(json, Operacao.class);
		
		BigDecimal valorTotal = operacao.getTitulos().stream()
				.map(Titulo::getValor)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		operacao.setValorTotal(valorTotal);
		operacaoRepository.save(operacao);
	}
	
}
