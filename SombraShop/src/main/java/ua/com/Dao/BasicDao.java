package ua.com.Dao;

import java.util.List;

public interface BasicDao<T> {

	void save(T t);

	void update(T t);

	void delete(int id);

	T findOne(int id);

	List<T> findAll();
	
}
