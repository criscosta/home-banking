package br.jus.trt3.homebanking.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BoletoRepository extends CrudRepository<Boleto, Long> {

	public Optional<Boleto> findById(Long id);
}
