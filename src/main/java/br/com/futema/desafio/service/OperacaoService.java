package br.com.futema.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.futema.desafio.exception.BusinessException;
import br.com.futema.desafio.mq.Producer;
import br.com.futema.desafio.persistencia.model.Operacao;
import br.com.futema.desafio.persistencia.repository.OperacaoRepository;
import br.com.futema.desafio.view.ResponseView;

@Service
public class OperacaoService {

	@Autowired
	private OperacaoRepository operacaoRepository;
	
	@Autowired
	private Producer producer;
	
	public ResponseView enviarFilaSalvar(Operacao operacao) throws BusinessException {
		
		try {
			Gson gson = new Gson();
			producer.addFila(gson.toJson(operacao));			
		} catch (Exception e) {
			throw new BusinessException(10l, "Erro ao enviar operação para fila");
		}
		
		ResponseView view = new ResponseView();
		view.setCode(0l);
		view.setMsg("OK");
		return view;
	}
	
	public Page<Operacao> buscarPaginado(int pagina, int tamanho) {
		
		final PageRequest pr = PageRequest.of(pagina - 1 , tamanho);
		
		return operacaoRepository.findAll(pr);
	}
	
}
