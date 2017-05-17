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

import ua.com.Entities.Material;
import ua.com.Service.MaterialService;
import ua.com.validator.MaterialValidator;

@Controller
@RequestMapping("/admin/material")
@SessionAttributes("material")
public class MaterialController {
	
	@Autowired
	private MaterialService  materialService;
	
	@ModelAttribute("material")
	public Material getForm(){
		return new Material();
	}
	
	@InitBinder
	protected void bind(WebDataBinder binder){
		binder.setValidator(new MaterialValidator(materialService));
	}

	
	@GetMapping
	public String show(Model model){
		model.addAttribute("materials", materialService.findAll());
		return "admin-material";
	}
	@GetMapping("update/{id}")
	public String update(@PathVariable int id,Model model){
		model.addAttribute("material", materialService.findOne(id));
		return show(model);
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id){
		materialService.delete(id);
		return "redirect:/admin/material";
	}
	@PostMapping
	public String save(@ModelAttribute("material")@Validated Material material,BindingResult br,SessionStatus status,Model model){
		if(br.hasErrors()) return show(model);
		materialService.save(material);
		status.setComplete();
		return "redirect:/admin/material";
	}
}
