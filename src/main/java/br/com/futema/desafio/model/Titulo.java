package br.com.futema.desafio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TITULO")
public class Titulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "VALOR")
	private BigDecimal valor;

	@Column(name = "NOME_SACADO")
	private String nomeSacado;

	@Column(name = "CPF_CNPJ_SACADO")
	private String cpfCnpjSacado;

	@ManyToOne
	@JoinColumn(name = "id_operacao")
	private Operacao operacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeSacado() {
		return nomeSacado;
	}

	public void setNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
	}

	public String getCpfCnpjSacado() {
		return cpfCnpjSacado;
	}

	public void setCpfCnpjSacado(String cpfCnpjSacado) {
		this.cpfCnpjSacado = cpfCnpjSacado;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

}
