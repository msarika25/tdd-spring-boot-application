package com.demo.tdd.service;

import com.demo.tdd.domain.Car;
import com.demo.tdd.domain.TDDDemoRepository;
import com.demo.tdd.web.CarNotFoundException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TDDDemoService {

	private TDDDemoRepository carRepository;

	public TDDDemoService(TDDDemoRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Cacheable("cars")
	public Car getCarDetails(String name) {
		Car car = carRepository.findByName(name);
		if(car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}
}
