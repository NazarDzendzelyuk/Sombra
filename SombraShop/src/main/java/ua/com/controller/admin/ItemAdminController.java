package ua.com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.Entities.Item;
import ua.com.Service.ItemService;

@Controller
@SessionAttributes("item")
@RequestMapping("/admin/item")
public class ItemAdminController {

	@Autowired
	ItemService itemService;
	@ModelAttribute("item")
	public Item getForm(){
		return new Item();
	}
	@GetMapping
	public String show(Model model){
		model.addAttribute("items", itemService.findAll());
		return "admin-item";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id){
		itemService.delete(id);
		return "redirect:/admin/item";
	}
}
