package com.hgkimer.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {
	@Autowired
	private MockMvc mock;

	@Test
	public void hello() throws Exception {
		String hello = "hello";
		mock.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("hello"));
	}

	@Test
	public void helloDto() throws Exception {
		String name = "이름";
		int amount = 100;

		mock.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.amount", is(amount)));
	}


}
