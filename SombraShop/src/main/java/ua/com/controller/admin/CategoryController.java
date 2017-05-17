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

import ua.com.Entities.Category;
import ua.com.Service.CategoryService;
import ua.com.validator.CategoryValidator;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@InitBinder("category")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CategoryValidator(categoryService));
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("categories",categoryService.findAll());
		return "admin-category";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id){
		categoryService.delete(id);
		return "redirect:/admin/category";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable int id,Model model){	
        model.addAttribute("category", categoryService.findOne(id));
		return show(model) ;
	}
	@PostMapping
	public String save(@ModelAttribute("category")@Validated Category category,BindingResult br,SessionStatus status,Model model){
		if(br.hasErrors()) return show(model);
		categoryService.save(category);
		status.setComplete();
		return "redirect:/admin/category";
	}
}
