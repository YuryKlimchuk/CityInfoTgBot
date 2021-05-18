package com.hydroyura.CityInfoTgBot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.CityInfoTgBot.Entities.City;
import com.hydroyura.CityInfoTgBot.Repositories.CityRepositiory;
	

/*
 * Для Restконтроллера
 */
@Component("ServiceInterfaceImpl")
@Service
public class ServiceInterfaceImpl implements ServiceInterface<City> {
	
	@Autowired
	private CityRepositiory repository;

	@Override
	public Iterable<City> getAllEntities() {
		return repository.findAll();
	}

	@Override
	public Optional<City> getEntity(long id) {
		return repository.findById(id);
	}

	@Override
	public void saveEntity(City entity) {
		repository.save(entity);
	}

	@Override
	public void updateEntity(City entity) {
		repository.save(entity);
	}

	@Override
	public void deleteEntity(long id) {
		repository.deleteById(id);
	}

}
