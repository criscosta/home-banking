package br.jus.trt3.homebanking;

import java.util.Date;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.jus.trt3.homebanking.model.Boleto;
import br.jus.trt3.homebanking.model.BoletoRepository;

@Path("/homebanking/boleto")
public class BoletoResource {

	@Inject
	BoletoRepository repository;

	@GET
	@Path("{boletoId}/recalcular")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recalcular(@PathParam("boletoId") Long boletoId) {

		Optional<Boleto> boletoVencido = repository.findById(boletoId);

		if (boletoVencido.isPresent()) {

			Boleto boleto = boletoVencido.get();
			
			// Boleto está vencido?
			if (boleto.getVencimento().before(new Date())) {
				
				//Adiciona 5 dias ao boleto. 
				Date tomorrow = new Date(new Date().getTime() + (5 * 1000 * 60 * 60 * 24));
				boleto.setVencimento(tomorrow);
				
				// Aplica multa de atraso.
				boleto.setValor(boleto.getValor() + 10);
				
				repository.save(boleto);
			}

			return Response.status(200).entity(boleto).build();

		}

		return Response.status(404).build();

	}
}