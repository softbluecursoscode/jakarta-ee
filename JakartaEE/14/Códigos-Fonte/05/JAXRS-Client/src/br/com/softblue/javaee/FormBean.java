package br.com.softblue.javaee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import br.com.softblue.javaee.ejb.WSClientBean;
import br.com.softblue.javaee.model.Song;

@Named
@RequestScoped
public class FormBean implements Serializable {

	@EJB
	private WSClientBean wsClientBean;

	private List<Song> songs = new ArrayList<>();
	private Integer songId;
	private Song song = new Song();
	private String deleteMsg;
	private String createMsg;
	private String updateMsg;

	public String list() {
		this.songs = wsClientBean.list();
		return null;
	}

	public String find() {
		this.song = wsClientBean.find(songId);
		return null;
	}

	public String delete() {
		Response response = wsClientBean.delete(songId);

		if (response.getStatusInfo() == Response.Status.OK) {
			deleteMsg = "Música excluída";
		
		} else {
			deleteMsg = "Música não encontrada";
		}

		return null;
	}

	public String create() {
		Response response = wsClientBean.create(song);
		
		if (response.getStatusInfo() == Response.Status.CREATED) {
			createMsg = "Música criada: " + response.getLocation();
		
		} else {
			createMsg = "Música não criada";
		}
		
		return null;
	}

	public String update() {
		Response response = wsClientBean.update(song);
		
		if (response.getStatusInfo() == Response.Status.OK) {
			updateMsg = "Música atualizada";
		
		} else {
			updateMsg = "Música não encontrada";
		}
		
		return null;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public String getDeleteMsg() {
		return deleteMsg;
	}

	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}

	public String getCreateMsg() {
		return createMsg;
	}

	public void setCreateMsg(String createMsg) {
		this.createMsg = createMsg;
	}

	public String getUpdateMsg() {
		return updateMsg;
	}

	public void setUpdateMsg(String updateMsg) {
		this.updateMsg = updateMsg;
	}
}
