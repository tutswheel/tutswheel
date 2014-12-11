package com.sg.tutswheel.web.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.tutswheel.core.example.domain.ToDo;
import com.sg.tutswheel.core.example.service.ToDoService;

@Controller
@RequestMapping("/todo")
public class ToDoController {

	@Autowired
	private ToDoService todoService;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ToDo> findAll() {
		 List<ToDo> models = this.todoService.findAll();
		 return models;
	}
}
