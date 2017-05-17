package ua.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Dao.MaterialDao;
import ua.com.Entities.Material;

@Repository
public class MaterialDaoImpl implements MaterialDao {

	@PersistenceContext(unitName = "Sombra")
	EntityManager entityManager;

	@Transactional
	public void save(Material material) {
		entityManager.merge(material);
	}

	@Transactional
	public void update(Material material) {
		entityManager.merge(material);
	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(findOne(id));
	}

	public Material findOne(int id) {
		return entityManager.find(Material.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> findAll() {
		return entityManager.createNamedQuery("Material.findAll").getResultList();
	}

	@Override
	public Material findByMaterial(String name) {
		try {
			return (Material) entityManager.createNamedQuery("Material.findByMaterial").setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
