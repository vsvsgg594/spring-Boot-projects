package com.smartcontact.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.smartcontact.dao.UserRepository;
import com.smartcontact.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/index")
	public String dashBoard(Model model,Principal principal) {
		String username=principal.getName();
		System.out.println("username "+username);
		return "/normal/user_dashborad";
	}

}
