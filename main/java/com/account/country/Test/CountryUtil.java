package com.account.country.Test;

import com.account.country.DAO.CountryDAO;
import com.account.country.DAO.CountryDAOImpl;
import com.account.country.DTO.CountryDTO;

public class CountryUtil 
{
    public static void main( String[] args )
    {
    	CountryDTO dto=new CountryDTO();
    	dto.setCurrency("Dinar");
    	dto.setName("Qtar");
    	dto.setNoOfStates(10);
    	dto.setPopulation(5583568);
    	
CountryDAO countryDAO=new CountryDAOImpl();
//countryDAO.saveCountry(dto);
//countryDAO.updatePopulationByName(3455555,"Qtar");
  //countryDAO.deleteCountryNameByCurrency("Dinar");
//String str=countryDAO.getCountryByCurrency("Dinar");
//System.out.println(str);
/*		CountryDTO countryDTO = countryDAO.getCountryNameCurrency("Dinar");
		System.out.println(countryDTO);
*/
countryDAO.getAllCountries();
    }
}
