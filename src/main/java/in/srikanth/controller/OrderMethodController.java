package in.srikanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.srikanth.model.OrderMethod;
import in.srikanth.service.IOrderMethodService;

@Controller
@RequestMapping("/om")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	// 1. show Register Page

	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("om", new OrderMethod());
		return "OrderMethodRegister";
	}

}