package com.example.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Favorite {
	
	@Id
	private String id; 
	
	@DBRef
	private User user;
	
	@DBRef
	private List<Manga> favoriteMangas;

	public Favorite(User user, List<Manga> favoriteMangas) {
		super();
		this.user = user;
		this.favoriteMangas = favoriteMangas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Manga> getFavoriteMangas() {
		return favoriteMangas;
	}

	public void setFavoriteMangas(List<Manga> favoriteMangas) {
		this.favoriteMangas = favoriteMangas;
	}
	

}
