package com.packt.cardatabase.domain.car.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.packt.cardatabase.domain.car.model.Owner;

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long> {

}
