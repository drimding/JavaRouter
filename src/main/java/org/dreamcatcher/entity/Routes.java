package org.dreamcatcher.entity;


import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "Routes")
public class Routes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	

	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	private  Rtype type;
	
	@OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="routes")
	private List<RouteWaypoints> routeWaypoints;
	
	@OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="routes")
	private List<RouteStops> routeStops;
	
	public Routes() {
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

	public Rtype getType() {
		return type;
	}

	public void setType(Rtype type) {
		this.type = type;
	}

	public List<RouteWaypoints> getRouteWaypoints() {
		return routeWaypoints;
	}

	public void setRouteWaypoints(List<RouteWaypoints> routeWaypoints) {
		this.routeWaypoints = routeWaypoints;
	}

	public List<RouteStops> getRouteStops() {
		return routeStops;
	}

	public void setRouteStops(List<RouteStops> routeStops) {
		this.routeStops = routeStops;
	}

	@Override
	public String toString() {
		return "Routes [id=" + id + ", name=" + name + ", type=" + type + ", routeWaypoints=" + routeWaypoints
				+ ", routeStops=" + routeStops + "]";
	}

	
}
