package br.com.softblue.javaee.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Songs {

	private static final Map<Integer, Song> songs = Map.of(
		1, new Song(1, "Let It Be", "Beatles"),
		2, new Song(2, "Hey Jude", "Beatles"),
		3, new Song(3, "Crazy", "Aerosmith"),
		4, new Song(4, "Angel", "Aerosmith")
	);
	
	public static List<Song> list() {
		return new ArrayList<Song>(songs.values());
	}
}
