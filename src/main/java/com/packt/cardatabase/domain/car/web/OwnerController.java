package com.packt.cardatabase.domain.car.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.car.model.Owner;
import com.packt.cardatabase.domain.car.repository.OwnerRepository;

@RestController
public class OwnerController {

	@Autowired
	private OwnerRepository repository;
	
	@RequestMapping("/owners")
	public Iterable<Owner> owners() {
		return repository.findAll();
	}
	
}
