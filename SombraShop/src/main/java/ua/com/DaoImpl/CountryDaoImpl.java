package ua.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Dao.CountryDao;
import ua.com.Entities.Country;
@Repository
public class CountryDaoImpl implements CountryDao {
	
	@PersistenceContext(unitName="Sombra")
	EntityManager entityManager;
	
	@Transactional
	public void save(Country country) {
		entityManager.merge(country);
	}

	@Transactional
	public void update(Country country) {
		entityManager.merge(country);
	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(findOne(id));
	}

	@Override
	public Country findOne(int id) {
		return entityManager.find(Country.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findAll() {
		return entityManager.createNamedQuery("Country.findAll").getResultList();
	}

	@Override
	public Country findByCountry(String name) {
		try{
			return  (Country) entityManager.createNamedQuery("Country.findByCountry").setParameter("name", name).getSingleResult();

		}catch(NoResultException e){
			
			return null;
		}
	}

}