package ua.com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Dao.CommodityDao;
import ua.com.Entities.Commodity;
import ua.com.Service.CommodityService;
import ua.com.Service.FileWriter;

@Service
public class CommodityServiceImpl implements CommodityService  {

	@Autowired
	CommodityDao commodityDao;
	@Autowired
	private FileWriter fileWriter;

	
	@Override
	public void save(Commodity commodity) {
		commodityDao.save(commodity);
		
	}

	@Override
	public void update(Commodity commodity) {
		commodityDao.update(commodity);
	}

	@Override
	public void delete(int id) {

		commodityDao.delete(id);
	}

	@Override
	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	@Override
	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	@Override
	public List<Commodity> findByCategory() {
		return commodityDao.findByCategory();
	}

	@Override
	public List<Commodity> findByCategoryId(int id) {
		return commodityDao.findByCategoryId(id);
	}

	@Override
	public List<Commodity> findByMaterial() {
		return commodityDao.findByMaterial();
	}

	@Override
	public List<Commodity> findByCountry() {
		return commodityDao.findByCountry();
	}

	@Override
	public List<Commodity> findByCommodityId(int id) {
		return commodityDao.findByCommodityId(id);
	}

}
