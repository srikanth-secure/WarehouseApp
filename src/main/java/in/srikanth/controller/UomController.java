package in.srikanth.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.srikanth.model.Uom;
import in.srikanth.service.IUomService;
import in.srikanth.util.UomUtil;
import in.srikanth.view.UomExcelView;
import in.srikanth.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@Autowired
	private UomUtil util;

	@Autowired
	private ServletContext sc;

	// 1. show Register Page
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("uom", new Uom());
		return "UomRegister";
		// return "UomRegister";
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
		// reset the form data
		model.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	// 3. show data
	@GetMapping("/all")
	public String getAllUoms(Model model) {
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}

	// 4. delete one uom
	@GetMapping("/delete")
	public String deleteUom(@RequestParam Integer id, Model model) {
		service.deleteUom(id);
		model.addAttribute("message", "Uom '" + id + "' deleted");
		model.addAttribute("list", service.getAllUoms());
		return "UomData";
	}

	// 5. show uom edit
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		Uom uom = service.getOneUom(id);
		model.addAttribute("uom", uom);
		return "UomEdit";
	}

	// 6. update uom
	@PostMapping("/update")
	public String updateUom(@ModelAttribute Uom uom, Model model) {
		service.updateUom(uom);
		model.addAttribute("message", "Uom '" + uom.getId() + "' Updated");
		model.addAttribute("list", service.getAllUoms());
		return "UomData";
	}

//7. Creating Excel
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView mav = new ModelAndView();

		mav.setView(new UomExcelView());
		List<Uom> list = service.getAllUoms();
		mav.addObject("list", list);
		return mav;
	}

	// 8. create PDF
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView mav = new ModelAndView();
		mav.setView(new UomPdfView());
		List<Uom> list = service.getAllUoms();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/validate")
	public @ResponseBody String validateModel(@RequestParam String model) {
		String message = "";
		if (service.isUomModelExist(model)) {
			message = "Uom Model ' " + model + " ' already exist";
		}
		return message;
	}

	// Charts
	@GetMapping("/charts")
	public String showCharts() {
		List<Object[]> data = service.getUomTypeAndCount();
		String path = sc.getRealPath("/");
		util.generatePie(path, data);
		return "UomCharts";
	}
}