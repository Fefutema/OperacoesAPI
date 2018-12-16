package br.com.futema.desafio.persistencia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6370816910193565952L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome do cedente não pode ser nulo")
	@Column(name = "NOME_CEDENTE")
	private String nomeCedente;
	
	@NotNull(message = "CPF / CNPJ do cedente não pode ser nulo")
	@Column(name = "CPF_CNPJ_CEDENTE")
	private String cpfCnpjCedente;
	
	@Column(name = "VALOR_TOTAL")
	private BigDecimal valorTotal;
	
	@NotNull(message = "Uma operação deve ter no minimo um titulo")
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_OPERACAO")
	private List<Titulo> titulos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCedente() {
		return nomeCedente;
	}

	public void setNomeCedente(String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}

	public String getCpfCnpjCedente() {
		return cpfCnpjCedente;
	}

	public void setCpfCnpjCedente(String cpfCnpjCedente) {
		this.cpfCnpjCedente = cpfCnpjCedente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

}
