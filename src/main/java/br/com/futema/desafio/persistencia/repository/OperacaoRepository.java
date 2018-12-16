package br.com.futema.desafio.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futema.desafio.persistencia.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>{

}
