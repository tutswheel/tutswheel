package com.sg.tutswheel.core.example.domain.builder;

import com.sg.tutswheel.core.example.domain.ToDo;

public class ToDoBuilder {

	private ToDo toDo;
	
	private long id;
	private String description;
	private String title;
	
	public ToDoBuilder id(long id) {
		this.id = id;
		return this;
	}

	public ToDoBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public ToDoBuilder title(String title) {
		this.title = title;
		return this;
	}

	public ToDo build() {
		toDo = new ToDo();
		toDo.setId(this.id);
		toDo.setDescription(this.description);
		toDo.setTitle(this.title);
		
		return toDo;
	}
	
}
