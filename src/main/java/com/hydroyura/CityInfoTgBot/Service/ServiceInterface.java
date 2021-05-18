package com.hydroyura.CityInfoTgBot.Service;

import java.util.Optional;

public interface ServiceInterface<T> {
	
	public Iterable<T> getAllEntities();
	
	public Optional<T> getEntity(long id);
	
	public void saveEntity(T entity);
	
	public void updateEntity(T entity);
	
	public void deleteEntity(long id);

}
