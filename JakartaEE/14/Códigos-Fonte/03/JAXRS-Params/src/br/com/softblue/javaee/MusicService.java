package br.com.softblue.javaee;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.softblue.javaee.model.Song;
import br.com.softblue.javaee.model.Songs;

@Path("/music")
public class MusicService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Song> loadAll() {
		 List<Song> songs = Songs.list();
		 return songs;
	}
	
	@GET
	@Path("/{songId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Song loadById(@PathParam("songId") int id) {
		return Songs.findById(id);
	}
	
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Song loadByIdQuery(@QueryParam("songId") int id) {
		return Songs.findById(id);
	}
}
