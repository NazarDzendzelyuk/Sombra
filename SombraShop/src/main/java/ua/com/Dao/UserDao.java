package ua.com.Dao;

import ua.com.Entities.User;

public interface UserDao extends BasicDao<User>{

	User findByEmail(String email);
}
