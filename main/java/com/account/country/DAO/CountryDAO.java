package com.account.country.DAO;

import java.util.List;

import com.account.country.DTO.CountryDTO;

public interface CountryDAO {
void saveCountry(CountryDTO dto);
public void updatePopulationByName(long population, String name);
public void deleteCountryNameByCurrency(String currency);
public String getCountryByCurrency(String currency) ;
public CountryDTO getCountryNameCurrency(String currency) ;
public List<CountryDTO> getAllCountries();

}
