package ua.com.Service;

import java.util.List;

import ua.com.Entities.Item;

public interface ItemService {
	
	List<Item>findByUser(String userName,String status);
	
	Item findByUserName(String userName);

	
	void save(Item item);
	Item findOne(int id);
	List<Item> findAll();
	void delete(int id);
}