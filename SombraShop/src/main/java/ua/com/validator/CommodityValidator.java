package ua.com.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Entities.Commodity;
import ua.com.Service.CommodityService;

public class CommodityValidator implements Validator{
	private final static Pattern REG = Pattern.compile("^[0-9]+$");

	private final CommodityService commodityService;
	
	public CommodityValidator(CommodityService commodityService) {
		super();
		this.commodityService = commodityService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Commodity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Commodity commodity=(Commodity) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "","Can't be empty");
		
		

		
	}

}
