package br.com.futema.desafio.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void addFila(String json) {
		jmsTemplate.convertAndSend("queue.operacoes", json);
	}
	
}
