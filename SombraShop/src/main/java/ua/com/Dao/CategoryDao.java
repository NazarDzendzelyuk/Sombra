package ua.com.Dao;

import ua.com.Entities.Category;

public interface CategoryDao extends BasicDao<Category> {

	Category findByCategory(String name);
}
