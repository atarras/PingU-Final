package com.fdmgroup.model;

public class OneToOneMessage {
	private String time;
	private String content;
	private String From;

	
	
	public OneToOneMessage(String time, String content, String from) {
		super();
		this.time = time;
		this.content = content;
		From = from;
	}


	public String getFrom() {
		return From;
	}


	public void setFrom(String from) {
		From = from;
	}


	public OneToOneMessage(String time, String content) {
		super();
		this.time = time;
		this.content = content;
	}

	
	public OneToOneMessage() {
		super();
	}


	public OneToOneMessage(String content) {
		super();
		this.content = content;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
