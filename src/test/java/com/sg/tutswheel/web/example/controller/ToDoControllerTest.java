package com.sg.tutswheel.web.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sg.tutswheel.core.example.domain.ToDo;
import com.sg.tutswheel.core.example.domain.builder.ToDoBuilder;
import com.sg.tutswheel.core.example.service.ToDoService;
import com.sg.tutswheel.test.base.unit.BaseUnitTest;
import com.sg.tutswheel.web.example.controller.ToDoController;
@ContextConfiguration(locations={"classpath:spingcontexts/application/appContext-web.xml"})
@WebAppConfiguration
public class ToDoControllerTest extends BaseUnitTest{

	private MockMvc mockMvc;
	
	@Autowired
	private ToDoService todoService;

	@Autowired
	private ToDoController controller;
	
	@Before
	public void setUp() {
		ToDo firstTodo = new ToDoBuilder()
		.id(1L)
		.description("Lorem ipsum")
		.title("Title1").build();
		
		ToDo secondTodo = new ToDoBuilder()
		.id(2L)
		.title("Title2")
		.description("sido rido").build();
		
		Mockito.when(todoService.findAll()).thenReturn(Arrays.asList(firstTodo,secondTodo));
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@After
	public void tearDown() {
		Mockito.verify(todoService).findAll();
		Mockito.reset();
	}
	
	@Configuration
	static class ToDoTestConfigurations{
		
		@Bean
		public ToDoService todoService() {
			return Mockito.mock(ToDoService.class);
		}
	}

	@Test
	public void test_findAll_found_shouldReturnFoundToDoEntries() throws Exception {
		mockMvc.perform(get("/todo"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].id", is(1)))
		.andExpect(jsonPath("$[1].id", is(2)));
		verify(todoService, VerificationModeFactory.times(1)).findAll();
		verifyNoMoreInteractions(todoService);
	}
}
