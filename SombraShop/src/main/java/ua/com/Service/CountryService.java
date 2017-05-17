package ua.com.Service;

import java.util.List;

import ua.com.Entities.Country;

public interface CountryService {

	void save(Country country);

	void update(Country country);

	void delete(int id);

	List<Country> findAll();

	Country findOne(int id);
	Country findByCountry(String name);
	
}
