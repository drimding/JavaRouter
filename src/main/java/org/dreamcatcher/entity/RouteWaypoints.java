package org.dreamcatcher.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dreamcatcher.controller.Views;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "route_waypoints")
public class RouteWaypoints {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@JsonView(Views.Public.class)
	private Integer number;
	@JsonView(Views.Public.class)
	private Double lat;
	@JsonView(Views.Public.class)
	private Double lon;
	@JsonView(Views.Public.class)
	private boolean direction;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "routeid")
	private Routes routes;
	

	public RouteWaypoints(){
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(double d) {
		this.lat = d;
	}


	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}


	public boolean isDirection() {
		return direction;
	}


	public void setDirection(boolean direction) {
		this.direction = direction;
	}


	public Routes getRoutes() {
		return routes;
	}


	public void setRoutes(Routes routes) {
		this.routes = routes;
	}


	@Override
	public String toString() {
		return "RouteWaypoints [id=" + id + ", number=" + number + ", lat=" + lat + ", lon=" + lon + ", direction="
				+ direction +  "]";
	}




	


}
