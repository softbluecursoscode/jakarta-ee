package br.com.softblue.javaee;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

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
	public Song findById(@PathParam("songId") int id) {
		Song song = Songs.findById(id);
		
		if (song == null) {
			return null;
		}
		
		return song;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Song song, @Context UriInfo uriInfo) {
		int id = Songs.create(song.getName(), song.getSinger());
		
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(String.valueOf(id));
		URI uri = uriBuilder.build();
		
		return Response.created(uri).build();
	}
	
	@Path("/{songId}")
    @DELETE
    public Response delete(@PathParam("songId") int id) {

        if (findById(id) == null) {
        	return Response.notModified().build();
        }
		
		Songs.delete(id);
		return Response.ok().build();
    }
	
	@Path("/{songId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Song song) {

        if (findById(song.getId()) == null) {
        	return Response.notModified().build();
        }
		
		Songs.update(song.getId(), song.getName(), song.getSinger());
		return Response.ok().build();
    }
}
