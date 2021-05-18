package com.hydroyura.CityInfoTgBot.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hydroyura.CityInfoTgBot.Entities.City;


public interface CityRepositiory extends CrudRepository<City, Long> {
	
	
	@Query(value = "SELECT name FROM city", nativeQuery = true)
	public Iterable<String> getCityNames();
	
	public Optional<City> findCityByName(String name);
	
}
