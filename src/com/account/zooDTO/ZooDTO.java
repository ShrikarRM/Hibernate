package com.account.zooDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "zoo_details")
public class ZooDTO implements Serializable {
	@Id
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator="ref")
	@Column (name="id")
	private int zooId;
	@Column (name="ZooName")
	private String name;
	@Column (name="place")
	private String place;
	@Column (name="noOfAnimals")
	private int noOfAnimals;

	public ZooDTO() {
		System.out.println(ZooDTO.class.getSimpleName() + " ZooDTO created");
	}

	public int getZooId() {
		return zooId;
	}

	public void setZooId(int zooId) {
		this.zooId = zooId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getNoOfAnimals() {
		return noOfAnimals;
	}

	public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}

	@Override
	public String toString() {
		return "ZooDTO [zooId=" + zooId + ", name=" + name + ", place=" + place + ", noOfAnimals=" + noOfAnimals + "]";
	}

}
