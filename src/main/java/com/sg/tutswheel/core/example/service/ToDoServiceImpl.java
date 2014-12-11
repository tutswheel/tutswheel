package com.sg.tutswheel.core.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sg.tutswheel.core.example.domain.ToDo;
import com.sg.tutswheel.core.example.domain.builder.ToDoBuilder;

@Service(value="todoService")
public class ToDoServiceImpl implements ToDoService{

	@Override
	public List<ToDo> findAll() {
		ToDo firstTodo = new ToDoBuilder()
		.id(1L)
		.description("Lorem ipsum")
		.title("Title1").build();
		
		ToDo secondTodo = new ToDoBuilder()
		.id(2L)
		.title("Title2")
		.description("sido rido").build();
		
		return Arrays.asList(firstTodo, secondTodo);
	}


}
