package com.leaptechstudio.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String message;
	private String author;

	public ErrorMessage() {}
	public ErrorMessage(Date timestamp, String message, String author) {
		
		this.timestamp = timestamp;
		this.message = message;
		this.author=author;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
