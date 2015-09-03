package com.rest.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.example.bean.Person;
import com.rest.example.service.MangoService;

@Controller
public class ClientController {

	@Autowired
	MangoService mangoService;
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
	public String indexPage(HttpServletRequest request, Model model) {
		String submit = request.getParameter("submit");
		if(submit.equals("login")){
			String uname = request.getParameter("uname");
			String pword = request.getParameter("pword");
			return "index";
		} else{
			return "register";
		}
		
	}
	
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public String register(HttpServletRequest request, Model model) {
		Person person = new Person(request.getParameter("fname"), request.getParameter("lname"), Integer.parseInt(request.getParameter("age")));
		mangoService.insertDocument(person,"person");
		return "success";
	}
	
	@RequestMapping(value = "/userDetails" , method = RequestMethod.GET)
	public @ResponseBody List UserDetails(HttpServletRequest request, Model model) {
		return mangoService.getAllDocuments("person");
	}
	

}
