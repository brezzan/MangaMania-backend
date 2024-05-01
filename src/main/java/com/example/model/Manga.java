package com.example.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Manga {
	
	@Id 
	private String mangaId;
	
	@Field("title_ov")
	private String titleOv;
	@Field("title_en")
    private String titleEn;
    private String synopsis;
    @Field("alternative_titles")
    private AlternativeTitles alternativeTitles;
    private Information information;
    private Statistics statistics;
    private List<Character> characters;
    @Field("picture_url")
    private String pictureUrl;
    
    
    
   
    public Manga( String titleOv, String titleEn, String synopsis, AlternativeTitles alternativeTitles,
			Information information, Statistics statistics, List<Character> characters, String pictureUrl) {
		super();
		
		this.titleOv = titleOv;
		this.titleEn = titleEn;
		this.synopsis = synopsis;
		this.alternativeTitles = alternativeTitles;
		this.information = information;
		this.statistics = statistics;
		this.characters = characters;
		this.pictureUrl = pictureUrl;
	}

	public String getMangaId() {
		return mangaId;
	}

	public void setMangaId(String mangaId) {
		this.mangaId = mangaId;
	}

	public String getTitleOv() {
		return titleOv;
	}

	public void setTitleOv(String titleOv) {
		this.titleOv = titleOv;
	}

	public String getTitleEn() {
		return titleEn;
	}

	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public AlternativeTitles getAlternativeTitles() {
		return alternativeTitles;
	}

	public void setAlternativeTitles(AlternativeTitles alternativeTitles) {
		this.alternativeTitles = alternativeTitles;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public static class AlternativeTitles {
        private String japanese;
        private String english;


        public String getJapanese() {
            return japanese;
        }

        public void setJapanese(String japanese) {
            this.japanese = japanese;
        }

        public String getEnglish() {
            return english;
        }

        public void setEnglish(String english) {
            this.english = english;
        }
        
    }
    
    public static class Information {

        private List<Type> types;
        private String volumes;
        private String chapters;
        private String status;
        private String published;
        private List<Type> genres;
        private List<Type> themes;
        private List<Type> demographics;
        private List<Type> serializations;
        private List<Type> authors;

        // Getters and Setters

        public List<Type> getTypes() {
            return types;
        }

        public void setTypes(List<Type> types) {
            this.types = types;
        }

        public String getVolumes() {
            return volumes;
        }

        public void setVolumes(String volumes) {
            this.volumes = volumes;
        }

        public String getChapters() {
            return chapters;
        }

        public void setChapters(String chapters) {
            this.chapters = chapters;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public List<Type> getGenres() {
            return genres;
        }

        public void setGenres(List<Type> genres) {
            this.genres = genres;
        }

        public List<Type> getThemes() {
            return themes;
        }

        public void setThemes(List<Type> themes) {
            this.themes = themes;
        }

        public List<Type> getDemographics() {
            return demographics;
        }

        public void setDemographics(List<Type> demographics) {
            this.demographics = demographics;
        }

        public List<Type> getSerializations() {
            return serializations;
        }

        public void setSerializations(List<Type> serializations) {
            this.serializations = serializations;
        }

        public List<Type> getAuthors() {
            return authors;
        }

        public void setAuthors(List<Type> authors) {
            this.authors = authors;
        }
    
    } 
    
    public static class Type {
        private String name;
        private String url;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
	
    public static class Statistics {
        private String score;
        private String ranked;
        private String popularity;
        private String members;
        private String favorites;

        // Getters and Setters

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getRanked() {
            return ranked;
        }

        public void setRanked(String ranked) {
            this.ranked = ranked;
        }

        public String getPopularity() {
            return popularity;
        }

        public void setPopularity(String popularity) {
            this.popularity = popularity;
        }

        public String getMembers() {
            return members;
        }

        public void setMembers(String members) {
            this.members = members;
        }

        public String getFavorites() {
            return favorites;
        }

        public void setFavorites(String favorites) {
            this.favorites = favorites;
        }
    }
    
    public static class Character {
        private String name;
        private String pictureUrl;
        private String myanimelistUrl;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getMyanimelistUrl() {
            return myanimelistUrl;
        }

        public void setMyanimelistUrl(String myanimelistUrl) {
            this.myanimelistUrl = myanimelistUrl;
        }
    }

	
    
    
    
}

    
    