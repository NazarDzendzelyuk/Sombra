package ua.com.Service;

import java.util.List;

import ua.com.Entities.Commodity;

public interface CommodityService {

	void save(Commodity commodity);

	void update(Commodity commodity);

	void delete(int id);

	Commodity findOne(int id);

	List<Commodity> findAll();

	List<Commodity> findByCategory();
	
	List<Commodity> findByMaterial();
	List<Commodity> findByCountry();

	List<Commodity>findByCategoryId(int id);
	List<Commodity>findByCommodityId(int id);



}
