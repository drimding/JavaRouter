package org.dreamcatcher.dto;

import org.dreamcatcher.controller.Views;

import com.fasterxml.jackson.annotation.JsonView;

public class RoutesStopsDTO {
	@JsonView(Views.Public.class)
	private Integer number;
	@JsonView(Views.Public.class)
	private boolean direction;
	@JsonView(Views.Public.class)
	private Double lat;
	@JsonView(Views.Public.class)
	private Double lon;
	@JsonView(Views.Public.class)
	private String addrsuffix;
	@JsonView(Views.Public.class)
	private String name;
	
	
	public RoutesStopsDTO(){
		
	}
	

	public RoutesStopsDTO(Integer number, boolean direction, Double lat, Double lon, String addrsuffix, String name) {
		super();
		this.number = number;
		this.direction = direction;
		this.lat = lat;
		this.lon = lon;
		this.addrsuffix = addrsuffix;
		this.name = name;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public boolean isDirection() {
		return direction;
	}


	public void setDirection(boolean direction) {
		this.direction = direction;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}


	public String getAddrsuffix() {
		return addrsuffix;
	}


	public void setAddrsuffix(String addrsuffix) {
		this.addrsuffix = addrsuffix;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "RoutesStopsDTO [number=" + number + ", direction=" + direction + ", lat=" + lat + ", lon=" + lon
				+ ", addrsuffix=" + addrsuffix + ", name=" + name + "]";
	}
	



	

}
