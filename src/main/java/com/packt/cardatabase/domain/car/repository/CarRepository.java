package com.packt.cardatabase.domain.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.packt.cardatabase.domain.car.model.Car;

@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

	List<Car> findByBrand(@Param("brand") String brand);
	
	List<Car> findByColor(@Param("color") String color);
	
	List<Car> findByYear(@Param("year") int year);
	
	List<Car> findByBrandAndModel(@Param("brand") String brand, @Param("model") String model);
	
	List<Car> findByBrandOrColor(@Param("brand") String brand, @Param("color") String color);
	
	List<Car> findByBrandOrderByYearAsc(@Param("brand") String brand);
	
	@Query("select c from Car c where c.brand like ?1")
	List<Car> findByBrandEndsWith(@Param("brand") String brand);
	
	
	
}
