package com.hydroyura.CityInfoTgBot.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "area")
	private float area;
	
	@Column(name = "population")
	private float population;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getArea() {
		return area;
	}

	public float getPopulation() {
		return population;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setArea(float area) {
		this.area = area;
	}

	public void setPopulation(float population) {
		this.population = population;
	}

}
