package br.jus.trt3.homebanking;

import java.util.ArrayList;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.jus.trt3.homebanking.model.AgenciaRepository;
import br.jus.trt3.homebanking.model.Cidade;
import br.jus.trt3.homebanking.model.CidadeRepository;

@Path("/homebanking/cidade")
public class CidadeResource {

	@Inject
	AgenciaRepository agenciaRepository;
	
	@Inject
	CidadeRepository cidadeRepository;

	@GET
	@Path("{idCidade}/agencias")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgencias(@PathParam("idCidade") Long idCidade) {
		
		Optional<Cidade> cidade = cidadeRepository.findById(idCidade);
		if(cidade.isPresent()) {
			return Response.status(200).entity(agenciaRepository.findByCidade(cidade.get().getId())).build();
		}

		return Response.status(404).entity(new ArrayList<Cidade>()).build();

	}
}