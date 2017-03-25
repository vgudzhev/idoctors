package bg.idoctors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.idoctors.domain.Doctor;
import bg.idoctors.services.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("doctors", doctorService.listAllDoctors());
		System.out.println("Returning doctors:");
		return "doctors";
	}

	@RequestMapping("/id/{id}")
	public String showDoctor(@PathVariable Integer id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "doctorshow";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "doctorform";
	}

	@RequestMapping("/new")
	public String newDoctor(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "doctorform";
	}

	@RequestMapping(value = "/doctor", method = RequestMethod.POST)
	public String saveDoctor(Doctor doctor) {
		System.out.println("---");
		doctorService.saveDoctor(doctor);
		System.out.println("---");
		return "redirect:/doctor/id/" + doctor.getId();
	}

}
