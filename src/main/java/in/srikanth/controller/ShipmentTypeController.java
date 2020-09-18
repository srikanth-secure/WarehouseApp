package in.srikanth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.srikanth.model.ShipmentType;
import in.srikanth.service.IShipmentTypeService;
import in.srikanth.view.ShipmentTypeExcelView;
import in.srikanth.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	@GetMapping("/register")
	public String showReg(Model model) {
		// Form Backing Object
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute ShipmentType shipmentType, Model model) {

		Integer id = service.saveShipmentType(shipmentType);
		String message = "Shipment Type ' " + id + " ' Saved";
		model.addAttribute("message", message);

		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";
	}

	@GetMapping("/delete")
	public String deleteOne(@RequestParam Integer id, Model model) {
		service.deleteShipmentType(id);
		model.addAttribute("message", "Shipment Type ' " + id + " ' deleted");
		model.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";
	}

	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		model.addAttribute("shipmentType", service.getOneShipmentType(id));
		return "ShipmentTypeEdit";
	}

	@PostMapping("/update")
	public String doUpdate(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateShipmentType(shipmentType);
		model.addAttribute("message", "Shipment Type ' " + shipmentType.getId() + " ' updated");
		model.addAttribute("list", service.getAllShipmentTypes());
		return "ShipmentTypeData";
	}

	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView mav = new ModelAndView();
		mav.setView(new ShipmentTypeExcelView());
		List<ShipmentType> list = service.getAllShipmentTypes();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView mav = new ModelAndView();
		mav.setView(new ShipmentTypePdfView());
		List<ShipmentType> list = service.getAllShipmentTypes();
		mav.addObject("list", list);
		return mav;
	}
}