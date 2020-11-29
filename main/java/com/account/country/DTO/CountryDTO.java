package com.account.country.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQueries({
		@NamedQuery(query = "update CountryDTO dto set dto.population=:pop where dto.name=:nm", name = "updatePopByCountry"),
		@NamedQuery(query = "delete from CountryDTO cd where cd.currency=:cr", name = "deleteByCurrency"),
		@NamedQuery(query = "select name from CountryDTO dto where dto.currency=:cr", name = "selectQuery"),
		@NamedQuery(query = "from CountryDTO dto", name = "selectAllCountriesList"),
		@NamedQuery(query = "select dto from CountryDTO dto where dto.currency=:cr", name = "selectQueryCurrency")

})
@Table(name = "country_details")
public class CountryDTO implements Serializable {
	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "country_id")
	private int countryId;
	@Column(name = "country_name")
	private String name;
	@Column(name = "no_of_states")
	private int noOfStates;
	@Column(name = "country_population")
	private long population;
	@Column(name = "country_currency")
	private String currency;

	public CountryDTO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfStates() {
		return noOfStates;
	}

	public void setNoOfStates(int noOfStates) {
		this.noOfStates = noOfStates;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "CountryDTO [countryId=" + countryId + ", name=" + name + ", noOfStates=" + noOfStates + ", population="
				+ population + ", currency=" + currency + "]";
	}

}
