package com.ivo.Task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ivo.Task2.service.UserService;

@Controller
public class appController {
	@Autowired
	UserService user;
	
	//-----------Abstract page------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	//-------------Welcome------------------
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String add() {
		return "welcome";
	}
	//-------------Contains an empty table------------------
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		return "view";
	}
	//-------------Admin user page------------------
	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String panel(){
		return "/partials/controlPane";
	}
	
	//-------------Emploee user page------------------
	@RequestMapping(value = "/employeePanel", method = RequestMethod.GET)
	public String employeePanel(){
		return "/partials/employeeControlPane";
	}
	//-------------Employer user page------------------
	@RequestMapping(value = "/employerPanel", method = RequestMethod.GET)
	public String employerPanel(){
		return "/partials/employerControlPane";
	}

}
