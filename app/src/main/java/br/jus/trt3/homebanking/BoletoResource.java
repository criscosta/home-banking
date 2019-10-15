package br.jus.trt3.homebanking;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/homebanking/boleto")
public class BoletoResource {

    @GET
    @Path("recalcular")
    @Produces(MediaType.TEXT_PLAIN)
    public String recalcular() {
        return "recalcular";
    }
}