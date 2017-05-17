package ua.com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.Entities.Country;
import ua.com.Service.CountryService;
import ua.com.validator.CategoryValidator;
import ua.com.validator.CountryValidator;

@Controller
@SessionAttributes("country")
@RequestMapping("/admin/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	@ModelAttribute("country")
	public Country getForm(){
		return new Country();
	}
	@GetMapping
	public String show(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "admin-country";
	}
	
	@InitBinder("country")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CountryValidator(countryService));
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	
	@GetMapping("update/{id}")
	public String update(Model model, @PathVariable int id){
		model.addAttribute("country", countryService.findOne(id));
		return show(model);
	}
	
	@PostMapping
	public String save(Model model,@ModelAttribute("country")@Validated Country country,BindingResult br,SessionStatus status){
		if(br.hasErrors()) return show(model);
		countryService.save(country);
		status.setComplete();
		return "redirect:/admin/country";
	}
}
