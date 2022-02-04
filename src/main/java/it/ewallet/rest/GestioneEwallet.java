package it.ewallet.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ejb.ConcurrentAccessException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import it.ewallet.pojo.ContoCorrente;
import it.ewallet.pojo.Movimento;

@Path("/ewallet")
public class GestioneEwallet {
	
	
	private static List<ContoCorrente> conti = new ArrayList<ContoCorrente>();
	private static List<Movimento> movimenti = new ArrayList<Movimento>();
	
	@GET
	@Path("/movimenti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimento> listaMovimenti(){
		return movimenti;
	}
	@GET
	@Path("/conti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContoCorrente> listaConti(){
		return conti;
	}
	
	@POST
	@Path("/crea")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creaConto(ContoCorrente cc) {
	 conti.add(cc);
	 return Response.status(200).entity("Conto Corrente Inserito").build();
	}
	
	
	@DELETE
	@Path("/cancella")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaConto(ContoCorrente cc) {
	conti.remove(cc); 
	return Response.status(200).entity("Conto Corrente eliminato!").build();
	}

	@PUT
	@Path("/aggiorna")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiornaConto(ContoCorrente cc) {
		for (ContoCorrente conto : conti) {
			if(conto.getIban() == cc.getIban()) {
				int index = conti.lastIndexOf(conto);
				 conti.set(index, cc);
				
			}	
	
		
		}
		return Response.status(200).entity("Conto Corrente aggiornato!").build();
	}
	
	@PUT
	@Path("/versa/{iban}/{importo}/{data}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response versa(@PathParam("iban")int iban,@PathParam("importo")int importo,@PathParam("data")String data) {
		double nuovoSaldo = 0;
		for (ContoCorrente contoCorrente : conti) {
			if(contoCorrente.getIban() == iban) {
				nuovoSaldo = contoCorrente.getSaldo() + importo;
				contoCorrente.setSaldo(nuovoSaldo);
				Movimento m = new Movimento();
				String tipo = "Operazione di versamento";
				m.setImporto(importo);
				m.setIban(iban);
				m.setData(data);
				m.setTipoMoviemnto(tipo);
				movimenti.add(m);	
			}
		}
		
		
		return Response.status(200).entity("Versamento di "+importo+ " effettuato!"+ System.lineSeparator() + " Saldo attuale : "+ nuovoSaldo).build();
	}
	
	@PUT
	@Path("/preleva/{iban}/{importo}/{data}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response preleva(@PathParam("iban")int iban,@PathParam("importo")int importo,@PathParam("data")String data) {
		double nuovoSaldo = 0;
		for (ContoCorrente contoCorrente : conti) {
			if(contoCorrente.getIban() == iban) {
				nuovoSaldo = contoCorrente.getSaldo() - importo;
				contoCorrente.setSaldo(nuovoSaldo);
				Movimento m = new Movimento();
				String tipo = "Operazione di versamento";
				m.setImporto(importo);
				m.setIban(iban);
				m.setData(data);
				m.setTipoMoviemnto(tipo);
				movimenti.add(m);	
			}
		}
		
		
		return Response.status(200).entity("Prelievo di "+importo+ " effettuato!"+ System.lineSeparator() + " Saldo attuale : "+ nuovoSaldo).build();
	}

}

