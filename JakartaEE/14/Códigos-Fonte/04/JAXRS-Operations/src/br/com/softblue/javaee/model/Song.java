package br.com.softblue.javaee.model;

public class Song {

	private Integer id;
	private String name;
	private String singer;
	
	public Song() {
	}

	public Song(int id, String name, String singer) {
		this.id = id;
		this.name = name;
		this.singer = singer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", singer=" + singer + "]";
	}
}
