package ua.com.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Entities.User;
import ua.com.Service.UserService;

public class UserValidator implements Validator {

	private final static Pattern REG = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	@Autowired
	private final UserService userService;
	
	public UserValidator(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address","", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber","", "Can't be empty");

		

		if(userService.findByEmail(user.getEmail())!=null){
			errors.rejectValue("email", "", "Already exist");
		}else{
			if (!REG.matcher(user.getEmail()).matches()) {
				errors.rejectValue("email", "", "Invalid format");
			}
		}
	}

}
