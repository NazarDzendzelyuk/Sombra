package ua.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.Dao.UserDao;
import ua.com.Entities.User;
@Repository
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext(unitName="Sombra")
	EntityManager entityManager;

	@Transactional
	public void save(User user) {
		entityManager.persist(user);
	}

	@Transactional
	public void update(User user) {
		entityManager.merge(user);
	}

	@Transactional
	public void delete(int id) {
		entityManager.remove(id);
	}

	@Override
	public User findOne(int id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		
		return entityManager.createNamedQuery("User.findAll").getResultList();
	}

	@Override
	public User findByEmail(String email) {
		try {
			return (User) entityManager.createNamedQuery("User.findByEmail").setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
