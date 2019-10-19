package com.demo.tdd.web;

import com.demo.tdd.domain.Car;
import com.demo.tdd.service.TDDDemoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TDDDemoController {

	private final TDDDemoService carService;

	public TDDDemoController(TDDDemoService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	public Car getCar(@PathVariable String name) {
		Car car = this.carService.getCarDetails(name);
		if (car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}

}
