package com.hydroyura.CityInfoTgBot.Controllers;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hydroyura.CityInfoTgBot.Entities.City;
import com.hydroyura.CityInfoTgBot.Service.ServiceInterface;



// REST контроллер для работы с сущностью City
@RestController
@RequestMapping("/api/v1/cities/")
public class CityController {
	
	@Autowired
	@Qualifier("ServiceInterfaceImpl")
	private ServiceInterface<City> service;
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<com.hydroyura.CityInfoTgBot.Entities.City>> getAll() {

		HttpHeaders headers = new HttpHeaders();
		headers.set("REQUEST_NAME", "GET_ALL_ENTITY");
		
		Iterable<City> cities = service.getAllEntities();
		
		if(StreamSupport.stream(cities.spliterator(), false).count() == 0) 
			new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); 
		
		return new ResponseEntity<>(cities, headers, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> getEntity(@PathVariable("id") Long id) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("REQUEST_NAME", "GET_ENTITY_BY_ID");
		
		if(id == null) 
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		
		
		Optional<City> city = service.getEntity(id);
		
		if(city.isEmpty()) 
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<>(city.get(), headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> saveEntity(@RequestBody @Validated City city) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("REQUEST_NAME", "SAVE_NEW_ENTITY");
		
		if(city == null) {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		
		service.saveEntity(city);
		return new ResponseEntity<>(city, headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> updateEntity(@RequestBody @Validated City city) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("REQUEST_NAME", "UPDATE_ENTITY");
		
		if(city == null) {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		
		service.updateEntity(city);
		return new ResponseEntity<>(city, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> deleteEntity(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("REQUEST_NAME", "DELETE_ENTITY");
		
		Optional<City> city = service.getEntity(id);
		if(city.isEmpty()) 
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		
		service.deleteEntity(id);
		
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}
	
}
