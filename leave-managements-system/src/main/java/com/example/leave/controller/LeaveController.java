package com.example.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.leave.model.Leave;
import com.example.leave.service.LeaveService;



@Controller
public class LeaveController {

	@Autowired
	private LeaveService leaveService;


	

	@GetMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("===================================siva=====================");
		return findPaginated(1, "empname", "asc", model);

	}

	@GetMapping("/showNewLeaveForm")
	public String showNewLeaveForm(Model model) {
		
		Leave leave = new Leave();
		model.addAttribute("leave", leave);
		return "new_leave";
	}

	@PostMapping("/saveLeave")
	public String saveLeave(@ModelAttribute("leave") Leave leave) {
		leaveService.saveLeave(leave);
		System.out.println("===================================s=====================");
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Leave leave = leaveService.getLeaveById(id);
		model.addAttribute("leave", leave);
		return "update_leave";
	}


	@GetMapping("/deleteLeave/{id}")
	public String deleteLeave(@PathVariable (value = "id") int id) {
		this.leaveService.deleteLeaveById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page < Leave > page = leaveService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List < Leave > listLeave = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listLeave", listLeave);
		return "index";
	}

}



