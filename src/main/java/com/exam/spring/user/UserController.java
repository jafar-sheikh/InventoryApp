package com.exam.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User> listUser = userRepo.findAll();
		model.addAttribute("listUser" , listUser);
		return "users";
		
	}
	
	@GetMapping("/users/new")
	public String createNewUserForm(Model model) {
		List<Role> listRole = roleRepo.findAll();
		model.addAttribute("listRole" ,listRole );
		model.addAttribute("user" , new User());
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		userRepo.save(user);
		return "redirect:/users";
	}

}
