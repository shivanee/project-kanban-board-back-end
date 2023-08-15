package com.project.kanban.springboot.springbootbackend;

public class Todo{
	private int id;
	private String title;
	private String status;
	
	public Todo(int id, String title, String status) {
		this.id = id;
		this.title = title;
		this.status=status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}	

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", status=" + status + "]";
	}

	
}
