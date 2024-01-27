package in.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.bindings.LoginForm;
import in.ashokit.bindings.RegisterForm;
import in.ashokit.bindings.ResetPwdForm;
import in.ashokit.entity.User;
import in.ashokit.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("login", new LoginForm());
		return "index";
	}
	
	@PostMapping("/login")
	public String loginCheck(@ModelAttribute("login") LoginForm login, Model model) {
		User user = userService.login(login);
		
		if(user == null) {
			model.addAttribute("errMsg", "Invalid Credentials");
			return "index";
		}
		
		if(user.getPwdUpdated().equals("NO")) {
			
			ResetPwdForm formObj = new ResetPwdForm();
			formObj.setUserId(user.getUserId());
			
			model.addAttribute("resetPwd", formObj);
			return "resetPwd";
		}
		
		return "redirect:dashboard";
	}
	
	@PostMapping("/updatePwd")
	public String updatePwd(@ModelAttribute("resetPwd") ResetPwdForm resetPwd, Model model) {
		
		if(!resetPwd.getNewPwd().equals(resetPwd.getConfirmPwd())) {
			model.addAttribute("errMsg", "Both Pwds should be same");
			return "resetPwd";
		}
		
		boolean status = userService.resetPwd(resetPwd);
		
		if(status) {
			return "redirect:dashboard";
		}
		
		model.addAttribute("errMsg", "Pwd update failed");
		return "resetPwd";
		
	}
	
	@GetMapping("/register")
	public String loadRegisterPage(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		Map<Integer,String> countries = userService.getCountries();
		model.addAttribute("countries", countries);
		return "register";
	}

	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStates(@RequestParam("countryId") Integer countryId) {
		return userService.getStates(countryId);
	}
	
	@GetMapping("/getCities")
	@ResponseBody
	public Map<Integer, String> getCities(@RequestParam("stateId") Integer stateId){
		return userService.getCities(stateId);
	}
	

	@PostMapping("/register")
	public String registerUser(@ModelAttribute RegisterForm registerForm, Model model) {
		
		boolean saveUser = userService.saveUser(registerForm);
		
		if(saveUser) {
			model.addAttribute("succMsg", "Registration Success");
		}else {
			model.addAttribute("errMsg", "Registration Failed");
		}
		
		Map<Integer,String> countries = userService.getCountries();
		model.addAttribute("countries", countries);
		
		return "register";
	}
	
	
	
}



















