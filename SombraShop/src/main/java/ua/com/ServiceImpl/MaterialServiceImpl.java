package ua.com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Dao.MaterialDao;
import ua.com.Entities.Material;
import ua.com.Service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialDao materialDao;
	
	@Override
	public void save(Material material) {
		materialDao.save(material);
	}

	@Override
	public void update(Material material) {
		materialDao.update(material);
	}

	@Override
	public void delete(int id) {
		materialDao.delete(id);
	}

	@Override
	public List<Material> findAll() {
		return materialDao.findAll();
	}

	@Override
	public Material findOne(int id) {
		return materialDao.findOne(id);
	}

	@Override
	public Material findByMaterial(String name) {
		return materialDao.findByMaterial(name);
	}
}
