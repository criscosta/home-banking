package br.jus.trt3.homebanking.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AgenciaRepository extends CrudRepository<Agencia, Long> {

	public List<Agencia> findByCidade(Long idCidade);
}
