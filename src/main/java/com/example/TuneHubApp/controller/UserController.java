package com.example.TuneHubApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TuneHubApp.entities.Songs;
import com.example.TuneHubApp.entities.Users;
import com.example.TuneHubApp.service.SongService;
import com.example.TuneHubApp.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UsersService userv;
	
	@Autowired
	SongService songserv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		boolean userstatus = userv.emailExists
				(user.getEmail());
		if(userstatus == false) {
			userv.addUser(user);
			return "registersuccess";
		}
		else
		{
			return "registerfail";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email,
			@RequestParam String password, HttpSession session)
	{
		//invoking validateUser() in service
		if(userv.validateUser(email, password) == true)
		{
			
			session.setAttribute("email", email);
			//checking whether the user is admin or customer
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else
		{
			return "loginfail";
		}
	}
	
	
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model) {
		
			String email = (String) session.getAttribute("email");
			
			Users user = userv.getUser(email);
			
			boolean userStatus = user.isPremium();
			if(userStatus == true) {
				List<Songs> songslist = songserv.fetchAllSongs();
				model.addAttribute("songslist", songslist);
				return "displaysongs";
			}
			else {
				return "payment";
			}
	}
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        // Invalidate the session
	        session.invalidate();
	        // Redirect the user to the login page or any other desired page
	        return "/login"; // Assuming you have a login page mapped to "/login"
	    }
}
