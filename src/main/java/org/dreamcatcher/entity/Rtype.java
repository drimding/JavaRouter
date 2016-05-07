package org.dreamcatcher.entity;


import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;

import javax.persistence.Table;


@Entity
@Table(name = "tb_type", indexes = {@Index(name="type_name_index", columnList = "type_name")})

public class Rtype {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String type_name;
	private String cyrillic_name;
	
	@OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="type")
	private List<Routes> routes;
	
	
	public Rtype() {
		
	}
	public Rtype(String type_name, String cyrillic_name) {
		super();
		this.type_name = type_name;
		this.cyrillic_name = cyrillic_name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getCyrillic_name() {
		return cyrillic_name;
	}
	public void setCyrillic_name(String cyrillic_name) {
		this.cyrillic_name = cyrillic_name;
	}
	public List<Routes> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Routes> routes) {
		this.routes = routes;
	}
	@Override
	public String toString() {
		return "Rtype [id=" + id + ", type_name=" + type_name + ", cyrillic_name=" + cyrillic_name + ", routes="
				+ routes + "]";
	}



	

	
	
}
