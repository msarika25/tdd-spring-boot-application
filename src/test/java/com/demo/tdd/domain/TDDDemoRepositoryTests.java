package com.demo.tdd.domain;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.tdd.domain.Car;
import com.demo.tdd.domain.TDDDemoRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TDDDemoRepositoryTests {

	@Autowired
	private TDDDemoRepository repository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void findByName_ReturnsCar() throws Exception {
		Car savedCar = testEntityManager.persistFlushFind(new Car("prius", "hybrid"));
		Car car = this.repository.findByName("prius");
		assertThat(car.getName()).isEqualTo(savedCar.getName());
		assertThat(car.getType()).isEqualTo(savedCar.getType());
	}
}