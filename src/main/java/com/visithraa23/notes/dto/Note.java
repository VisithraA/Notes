package com.visithraa23.notes.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private String lastEdit;
	private int wordCount;
	
	

	public Note() {
	}

	public Note(String title, String content, int wordCount, String lastEdit) {
		this.title = title;
		this.content = content;
		this.lastEdit = lastEdit;
		this.wordCount = wordCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(String lastEdit) {
		this.lastEdit = lastEdit;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", lastEdit=" + lastEdit
				+ ", wordCount=" + wordCount + "]";
	}
	
	
}
