package org.dreamcatcher.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stations")
public class Stations {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Double lat;
	private Double lon;
	private String addrsuffix;
	private Integer angle;
	
	@OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="stations")
	private List<RouteStops> routeStops;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "streetid")
	private StreetNames streetNames;
	
	
	Stations(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getAngle() {
		return angle;
	}

	public void setAngle(Integer angle) {
		this.angle = angle;
	}

	public List<RouteStops> getRouteStops() {
		return routeStops;
	}

	public void setRouteStops(List<RouteStops> routeStops) {
		this.routeStops = routeStops;
	}

	@Override
	public String toString() {
		return "Stations [id=" + id + ", name=" + name + ", lat=" + lat + ", lon=" + lon + ", addrsuffix=" + addrsuffix
				+ ", angle=" + angle + ", routeStops=" + routeStops + "]";
	}
	
	


	
	
	

}
