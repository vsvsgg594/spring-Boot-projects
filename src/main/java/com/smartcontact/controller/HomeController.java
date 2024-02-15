package com.smartcontact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartcontact.dao.UserRepository;
import com.smartcontact.entities.User;
import com.smartcontact.helper.Messages;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordProvicer;
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/")
	public String test(Model model)
	{
		model.addAttribute("title","Home - smart contact manager");
		
		return "home";
		
	}

	@GetMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title","About - smart contact manager");
		
		return "about";
		
	}
	@GetMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Register - smart contact manager");
		model.addAttribute("user",new User());
		return "signup";
		
	}
	//this is handler ragistering user
	@RequestMapping(path="/do_register",method=RequestMethod.POST)
	public String resesterUser( @ModelAttribute("user") User user,
			@RequestParam(value ="agreement",defaultValue="false") boolean agreement,Model model,HttpSession session)
	{
		try 
		{
			if(!agreement)
			{
				System.out.println("You have not accept terms and conditions");
				throw new Exception("You have not accept terms and conditions");
			}
//			if(result.hasErrors())
//			{
//				System.out.println(("Errors "+ result.toString()));
//				model.addAttribute("user",user);
//				return "signup";
//			}
//			 
			user.setRole("ROLE_USER");
			user.setActive(true);
			user.setPassword(passwordProvicer.encode(user.getPassword()));
			System.out.println("Agreement"+agreement);
//			System.out.println(("User "+user));
			
			User results=this.userRepository.save(user);
			
			
			
			model.addAttribute("user",new User());
			session.setAttribute("message",new Messages("success","alert-success"));
			return "signup";
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Messages("Server error"+e.getMessage(),"alert-error"));
			return "signup";
			
		}
		
	}
	
	// handler for custome login pages
	@GetMapping("/signin")
	public String cutomLogin(Model model)
	{
		model.addAttribute("title","Login");
		return "login";
	}
}
