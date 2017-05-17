package ua.com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Dao.CategoryDao;
import ua.com.Entities.Category;
import ua.com.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category findByCategory(String name) {
		return categoryDao.findByCategory(name);
	}
}
