package ua.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Dao.CommodityDao;
import ua.com.Entities.Commodity;
@Repository
public class CommodityDaoImpl implements CommodityDao {
	
	@PersistenceContext(unitName="Sombra")
	EntityManager entityManager;
	
	@Transactional
	public void save(Commodity commodity) {
		entityManager.merge(commodity);
	}

	@Transactional
	public void update(Commodity commodity) {
		entityManager.merge(commodity);
	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(findOne(id));
	}

	@Override
	public Commodity findOne(int id) {
		return entityManager.find(Commodity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findAll() {
		return entityManager.createNamedQuery("Commodity.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findByCategory() {
		return entityManager.createNamedQuery("Commodity.findByCategory").getResultList();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findByCategoryId(int id) {
		return entityManager.createNamedQuery("Commodity.findByCategoryId").setParameter("id", id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findByMaterial() {
		return entityManager.createNamedQuery("Commodity.findByMaterial").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findByCountry() {
		return entityManager.createNamedQuery("Commodity.findByCountry").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findByCommodityId(int id) {
		return entityManager.createNamedQuery("Commodity.findByCommodityId").setParameter("id", id).getResultList();
	}
}
