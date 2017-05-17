package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Entities.Material;
import ua.com.Service.MaterialService;

public class MaterialValidator implements Validator {
	
	
	private final MaterialService materialService;

	public MaterialValidator(MaterialService materialService) {
		super();
		this.materialService = materialService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Material.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Material material=(Material)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","Can't be empty");
		if(materialService.findByMaterial(material.getName())!=null){
			errors.rejectValue("name","", "Already exist!");
		}
	}

}
