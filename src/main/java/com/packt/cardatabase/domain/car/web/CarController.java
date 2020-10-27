package com.packt.cardatabase.domain.car.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.car.model.Car;
import com.packt.cardatabase.domain.car.repository.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository repository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
	
}
