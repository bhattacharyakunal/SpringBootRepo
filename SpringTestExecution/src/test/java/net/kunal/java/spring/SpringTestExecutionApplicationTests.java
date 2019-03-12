package net.kunal.java.spring;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import net.kunal.java.spring.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringTestExecutionApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTestExecutionApplicationTests {

	@LocalServerPort
	private int port;
	@MockBean DemoService demoService;
	
	
	TestRestTemplate testRestTemplate=new TestRestTemplate();
	HttpHeaders httpHeaders=new HttpHeaders();
	
	@Test
	public void testsayHello() {
		HttpEntity<String> entity=new HttpEntity<>(null,httpHeaders);
		String expected="Hello";
		when(demoService.sayHelloService()).thenReturn(expected);
		ResponseEntity<String> response=testRestTemplate.exchange(createURLWithPort("/hello/application"), HttpMethod.GET,entity,String.class);
		assertEquals(expected, response.getBody());
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
