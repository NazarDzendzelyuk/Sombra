package ua.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Dao.ItemDao;
import ua.com.Entities.Item;

@Repository
public class ItemDaoImpl implements  ItemDao {

	@PersistenceContext(unitName="Sombra")
	EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findByUser(String userName,String status) {
		return entityManager.createNamedQuery("Item.findByUser").setParameter("userName", userName).setParameter("status", status).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAll() {
		return entityManager.createNamedQuery("Item.findAll").getResultList();
	}

	@Override
	public Item findByUserName(String userName) {
		return findByUserName(userName);
	}

	@Transactional
	public void save(Item item) {
		entityManager.merge(item);
	}

	@Transactional
	public void update(Item item) {
		entityManager.merge(item);
	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(findOne(id));
	}

	@Override
	public Item findOne(int id) {
		return entityManager.find(Item.class, id);
	}

}
