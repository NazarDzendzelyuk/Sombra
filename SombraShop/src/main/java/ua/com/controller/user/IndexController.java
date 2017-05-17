package ua.com.controller.user;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.Entities.User;
import ua.com.Service.CategoryService;
import ua.com.Service.CommodityService;
import ua.com.Service.CountryService;
import ua.com.Service.MaterialService;
import ua.com.Service.UserService;
import ua.com.validator.UserValidator;

@Controller
public class IndexController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	CommodityService commodityService;
	@Autowired
	CountryService countryService;
	@Autowired
	MaterialService materialService;
	@Autowired
	UserService userService;
	
	private static final int WEAK=1;
	private static final int MEDIUM=4;
	private static final int STRONG=7;

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("commodities", commodityService.findAll());
		return "index";
	}
	@RequestMapping("/admin/commodity")
	public String admin(){
		return "admin";
	}
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable int id, Model model){
			model.addAttribute("category",categoryService.findOne(id));
			model.addAttribute("commodities", commodityService.findByCategoryId(id));
		return "user-category";
	}
	
	@RequestMapping("/commodity/{id}")
	public String commodity(@PathVariable int id, Model model){
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("commodities", commodityService.findByCommodityId(id));
		return "user-commodity";
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@PostMapping("/registration")
	public String save(Model model,@ModelAttribute("user")@Validated User user, BindingResult br){
		if(br.hasErrors())return "user-registration";
		userService.save(user);
		userService.sendMail("Реєстрація", user.getEmail(), "Дякуємо за реєстрацію в SombraShop");

		return "redirect:/login";
	}
	@GetMapping("/login")
	public String login(@ModelAttribute("user")User user){
		
		return "user-login";
	}
	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));
	}
	
	@RequestMapping(value="/checkStrength", method=RequestMethod.GET,produces={"text/html; charset=UTF-8"})
	public @ResponseBody String checkStrength(@RequestParam String password){
		
		if(password.length()>=WEAK & password.length()<MEDIUM){
			return "Слабий пароль";
		}else if(password.length()>=MEDIUM & password.length()<STRONG ){
			return "Середній пароль";
		}else if(password.length()>=STRONG){
			return "Сильний пароль";
		}
		return "";
	}
	@RequestMapping(value="/checkemail", method=RequestMethod.GET,produces={"text/html; charset=UTF-8"})
	public @ResponseBody String checkEmail(@RequestParam String email){
		
		if(userService.findByEmail(email)!=null){
			return "логін вже існує";
		}
		return "";
	}
	
}
