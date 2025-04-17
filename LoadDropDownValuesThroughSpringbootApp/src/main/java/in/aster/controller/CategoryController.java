package in.aster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.aster.service.ICategoryService;

@Controller
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/")
	public String LoadDropDownWithValues(Model model) {
		List<String> allCategories = categoryService.getAllCategories();
		model.addAttribute("categories", allCategories);
		return "formdropdown";
	}
}
