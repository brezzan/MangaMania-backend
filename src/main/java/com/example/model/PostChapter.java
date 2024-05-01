package com.example.model;


public class PostChapter {
	
	
	/*   the body of the POST ("/chapter/save") should be this way, then it constructs actual chapter object
	 {
		  "chapterName": "Chapter 2",
		  "chapterNumber": 2,
		  "description": "Chapter 2",
		  "mangaId": " "
		}
	 */
	
	private String chapterName;
	private int chapterNumber;
	private String description;
	private String mangaId;
	
	public PostChapter(String chapterName, int chapterNumber, String description, String mangaId) {
		super();
		this.chapterName = chapterName;
		this.chapterNumber = chapterNumber;
		this.description = description;
		this.mangaId = mangaId;
	}
	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public int getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMangaId() {
		return mangaId;
	}

	public void setMangaId(String mangaId) {
		this.mangaId = mangaId;
	}

	

}
