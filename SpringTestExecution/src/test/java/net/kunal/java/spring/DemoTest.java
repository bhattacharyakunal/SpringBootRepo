package net.kunal.java.spring;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.kunal.java.spring.controller.DemoController;
import net.kunal.java.spring.service.DemoService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=DemoController.class,secure=false)
public class DemoTest {
	
	@Autowired private MockMvc mockMvc;
	@MockBean DemoService demoService;
	
	@Test
	public void helloApplicationTest() throws Exception {
		when(demoService.sayHelloService()).thenReturn("Helooooooo");
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/hello/application");
		MvcResult mvcresult=mockMvc.perform(requestBuilder).andReturn();
		String output=mvcresult.getResponse().getContentAsString();
		assertEquals("Helooooooo", output);
	}
	
}
