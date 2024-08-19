package com.inhoo.cutieBug.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inhoo.cutieBug.service.CutieBugService;

@Controller
public class HomeController {
	
		private final CutieBugService cutieBugService;
	
	public HomeController(CutieBugService cutieBugService) {
			super();
			this.cutieBugService = cutieBugService;
		}

	@RequestMapping(value = "/")
	public String home(@RequestParam(name="bugName",required=false, defaultValue = "") 
	String bugName,Model model)	{
		
		return "home";
	}

}
