package in.srikanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.srikanth.model.WhUserType;
import in.srikanth.service.IWhUserType;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserType service;

	// Landing on register page
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("whusertype", new WhUserType());
		return "WhUserTypeRegister";
	}

	// saving the object
	@PostMapping("/save")
	public String saveWhUserType(@ModelAttribute WhUserType whusertype, // Read form data as object
			Model model) // send data to UI
	{
		// calling service
		Integer id = service.saveWhUserType(whusertype);
		String message = " WhUserType saved with id: " + id;
		// sending data to UI
		model.addAttribute("message", message);
		// reset the form data
		model.addAttribute("whusertype", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("list", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
}
