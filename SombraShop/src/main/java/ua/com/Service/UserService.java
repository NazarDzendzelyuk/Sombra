package ua.com.Service;

import ua.com.Entities.User;

public interface UserService  {

	User findByEmail(String email);
	void save(User user);
	void sendMail(String content, String email, String mailBody);

}
