package br.com.futema.desafio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.futema.desafio.persistencia.model.Operacao;
import br.com.futema.desafio.persistencia.model.Titulo;
import br.com.futema.desafio.service.OperacaoService;
import br.com.futema.desafio.view.ResponseView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OperacaoService.class)
public class ServiceTests {

	@Autowired
	private OperacaoService operacaoService;
	
	@Test
	public void inserirOperacao() {
		List<Titulo> titulos = new ArrayList<>();
		Titulo t1 = new Titulo();
		t1.setCpfCnpjSacado("12345678955");
		t1.setNomeSacado("t1");
		t1.setValor(new BigDecimal("150"));
		titulos.add(t1);
		
		Titulo t2 = new Titulo();
		t2.setCpfCnpjSacado("12345678966");
		t2.setNomeSacado("t2");
		t2.setValor(new BigDecimal("125"));
		titulos.add(t2);
		
		Operacao operacao = new Operacao();
		operacao.setCpfCnpjCedente("42515265844");
		operacao.setNomeCedente("Cedente");
		operacao.setTitulos(titulos);
		
		ResponseView enviarFilaSalvar = operacaoService.enviarFilaSalvar(operacao);
		
		assertThat(enviarFilaSalvar.getCode() == 0);
		
	}
	
	@Test
	public void buscarTodosPaginadosNotNull() {
		Page<Operacao> buscarPaginado = operacaoService.buscarPaginado(1, 1);
		assertNotNull(buscarPaginado);
	}

	@Test
	public void buscarTodosPaginados() {
		Page<Operacao> buscarPaginado = operacaoService.buscarPaginado(1, 1);
		assertThat(!buscarPaginado.getContent().isEmpty());
	}
	
}

