package ua.com.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Entities.Country;
import ua.com.Service.CountryService;

public class CountryValidator implements Validator {
	@Autowired
	private final CountryService countryService;
	
	public CountryValidator(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Country country=(Country) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","Can't be empty");
		if(countryService.findByCountry(country.getName())!=null){
			errors.rejectValue("name","", "Already exist!");
		}
	}

}
