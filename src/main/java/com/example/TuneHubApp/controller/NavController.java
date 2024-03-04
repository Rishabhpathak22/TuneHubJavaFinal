package com.example.TuneHubApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registermapping() {
		return "register";
	}
	@GetMapping("/map-login")
	public String loginmapping()
	{
		return "login";
	}
	@GetMapping("/map-addsongs")
	public String songsmapping() {
		return "addsongs";

	}
	@GetMapping("/adminhome1")
	public String adminhomemapping() {
		return "adminhome";

	}
	@GetMapping("/custhome1")
	public String customerMapping() {
		return "customerhome";

	}
	@GetMapping("/custplaylistd")
	public String customerMappingplaylist() {
		return "viewcustplaylist";

	}
	@GetMapping("/homepage")
	public String homepage() {
		return "index";

	}
}
