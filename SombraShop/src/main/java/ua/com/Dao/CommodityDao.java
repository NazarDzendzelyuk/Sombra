package ua.com.Dao;

import java.util.List;

import ua.com.Entities.Commodity;

public interface CommodityDao extends BasicDao<Commodity> {

	List<Commodity> findByCategory();

	List<Commodity> findByMaterial();
	List<Commodity> findByCountry();


	List<Commodity>findByCategoryId(int id);
	List<Commodity>findByCommodityId(int id);

}
