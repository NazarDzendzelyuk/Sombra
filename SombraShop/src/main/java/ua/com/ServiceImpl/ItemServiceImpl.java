package ua.com.ServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Dao.ItemDao;
import ua.com.Entities.Item;
import ua.com.Service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	public List<Item> findByUser(String userName,String status) {
		return itemDao.findByUser(userName,status);
	}

	@Override
	public Item findByUserName(String userName) {
		return itemDao.findByUserName(userName);
	}

	@Override
	public void save(Item item) {
		itemDao.save(item);
	}

	@Override
	public Item findOne(int id) {
		return itemDao.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public void delete(int id) {
		itemDao.delete(id);
	}
	
	
}
