package com.account.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="oota_project")
public class OotaDTO implements Serializable{
	@Id
	@GenericGenerator(name="ref",strategy = "increment")
	@GeneratedValue(generator="ref")
	private int id;
	private String name;
	private String type;
	private String place;
	
	
	public OotaDTO(){
		System.out.println(this.getClass().getSimpleName()+" crated");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "OotaDTO [id=" + id + ", name=" + name + ", type=" + type + ", place=" + place + "]";
	}
	
	

}
