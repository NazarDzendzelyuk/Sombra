package ua.com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Dao.CountryDao;
import ua.com.Entities.Country;
import ua.com.Service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryDao countryDao;

	@Override
	public void save(Country country) {
		countryDao.save(country);		
	}

	@Override
	public void update(Country country) {
		countryDao.update(country);
	}

	@Override
	public void delete(int id) {
		countryDao.delete(id);
	}

	@Override
	public List<Country> findAll() {
		return countryDao.findAll();
	}

	@Override
	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	@Override
	public Country findByCountry(String name) {
		return countryDao.findByCountry(name);
	}
}
