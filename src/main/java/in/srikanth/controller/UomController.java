package in.srikanth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.srikanth.model.Uom;
import in.srikanth.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;

	// 1. show Register Page
	@GetMapping("/register")
	public String showReg() {
		return "UomRegister";
	}

	// 2. on click save
	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom, // Read form data as object
			Model model) // send data to UI
	{
		// calling service
		Integer id = service.saveUom(uom);
		String message = " Uom saved with id:" + id;
		// sending data to UI
		model.addAttribute("message", message);
		return "UomRegister";
	}

	// 3. show data
	@GetMapping("/all")
	public String getAllUoms(Model model) {
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
}