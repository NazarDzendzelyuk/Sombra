package ua.com.Service;

import java.util.List;

import ua.com.Entities.Material;

public interface MaterialService {

	void save(Material material);
	void update(Material material);
	void delete(int id);
	List<Material>findAll();
	Material findOne(int id);
	
	Material findByMaterial(String name);
}
