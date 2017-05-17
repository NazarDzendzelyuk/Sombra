package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Entities.Category;
import ua.com.Service.CategoryService;

public class CategoryValidator implements Validator {

	private final CategoryService categoryService;
	
	
	public CategoryValidator(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category=(Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","Can't be empty");
		if(categoryService.findByCategory(category.getName())!=null){
			errors.rejectValue("name","", "Already exist!");
		}

		
	}

}
