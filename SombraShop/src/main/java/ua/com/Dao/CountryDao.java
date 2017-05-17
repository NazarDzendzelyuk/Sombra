package ua.com.Dao;

import ua.com.Entities.Country;

public interface CountryDao extends BasicDao<Country> {
	Country findByCountry(String name);
	
}
