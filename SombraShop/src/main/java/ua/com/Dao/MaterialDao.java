package ua.com.Dao;

import ua.com.Entities.Material;

public interface MaterialDao extends BasicDao<Material> {

	Material findByMaterial(String name);

}
