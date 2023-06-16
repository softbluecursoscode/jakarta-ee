package br.com.softblue.javaee;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/random")
public class RandomService {
	
	private Random random = new Random();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int[] loadByIdQuery(
			@QueryParam("min") int min,
			@QueryParam("max") int max,
			@QueryParam("qtde") int qtde) {
		
		int[] numbers = new int[qtde];
		
		for (int i = 0; i < qtde; i++) {
			numbers[i] = min + random.nextInt(max - min);
		}
		
		return numbers;
	}
}
