package ua.com.Service;

import java.util.List;

import ua.com.Entities.Category;

public interface CategoryService {

	void save(Category category);
	void update(Category category);
	void delete(int id);
	Category findOne(int id);
	List<Category>findAll();
	Category findByCategory(String name);
	

}
