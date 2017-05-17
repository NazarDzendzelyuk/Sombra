package ua.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Dao.CategoryDao;
import ua.com.Entities.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext(unitName = "Sombra")
	private EntityManager entityManager;

	@Transactional
	public void save(Category category) {
		entityManager.merge(category);
	}

	@Transactional
	public void update(Category category) {
		entityManager.merge(category);
	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(findOne(id));
	}

	@Override
	public Category findOne(int id) {
		return entityManager.find(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		return entityManager.createNamedQuery("Category.findAll")
				.getResultList();
	}

	@Override
	public Category findByCategory(String name) {
		try {
			return (Category) entityManager.createNamedQuery("Category.findByCategory").setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
}
