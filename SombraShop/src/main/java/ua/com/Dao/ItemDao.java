package ua.com.Dao;

import java.util.List;

import ua.com.Entities.Item;

public interface ItemDao extends BasicDao<Item> {
	List<Item>findByUser(String userName,String status);
	
	List<Item>findAll();
	
	Item findByUserName(String userName);
}
