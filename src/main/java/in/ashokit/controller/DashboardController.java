package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.service.DashboardService;

@Controller
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/dashboard")
	public String buildDashboard(Model model) {

		String quoteTxt = dashboardService.getQuote();

		model.addAttribute("quote", quoteTxt);

		return "dashboard";
	}

}
