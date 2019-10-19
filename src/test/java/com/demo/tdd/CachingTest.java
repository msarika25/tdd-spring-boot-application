package com.demo.tdd;

import com.demo.tdd.domain.Car;
import com.demo.tdd.domain.TDDDemoRepository;
import com.demo.tdd.service.TDDDemoService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

	@Autowired
	private TDDDemoService service;

	@MockBean
	private TDDDemoRepository repository;

	@Test
	public void getCar_ReturnsCachedValue() throws Exception {
		given(repository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));
		service.getCarDetails("prius");
		service.getCarDetails("prius");
		verify(repository, times(1)).findByName("prius");
	}
}
