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

import ua.com.Editor.CategoryEditor;
import ua.com.Editor.CountryEditor;
import ua.com.Editor.MaterialEditor;
import ua.com.Entities.Category;
import ua.com.Entities.Commodity;
import ua.com.Entities.Country;
import ua.com.Entities.Material;
import ua.com.Service.CategoryService;
import ua.com.Service.CommodityService;
import ua.com.Service.CountryService;
import ua.com.Service.MaterialService;
import ua.com.validator.CommodityValidator;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")
public class CommodityController {
	
	@Autowired
	CommodityService commodityService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	MaterialService materialService;
	
	
	@ModelAttribute("commodity")
	public Commodity getForm(){
		return new Commodity();
	}
	
	@InitBinder("commodity")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
		binder.registerCustomEditor(Country .class,	new CountryEditor(countryService));
		binder.setValidator(new CommodityValidator(commodityService));
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("commodities", commodityService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("materials", materialService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-commodity";
	}
	@GetMapping("/update/{id}")
	public String update(Model model,@PathVariable int id){
		model.addAttribute("commodity", commodityService.findOne(id));
		return show(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		commodityService.delete(id);
		return "redirect:/admin/commodity";
	}
	@PostMapping
	public String save(@ModelAttribute("commodity")@Validated Commodity commodity,BindingResult br,SessionStatus status,Model model){
		if(br.hasErrors())return show(model);
		commodityService.save(commodity);
		status.setComplete();
		return "redirect:/admin/commodity";
	}
	
}
