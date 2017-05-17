package ua.com.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Entities.Country;
import ua.com.Service.CountryService;

public class CountryEditor extends PropertyEditorSupport {

	private CountryService countryService;

	public CountryEditor(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Country country=countryService.findOne(Integer.valueOf(text));
		setValue(country);
	}
	
	
}
