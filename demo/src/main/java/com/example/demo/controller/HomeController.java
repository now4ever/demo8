package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@GetMapping("/api1")
	@ResponseBody
	public String apiString(@RequestParam String name) {
		return "hello " + name;

		//http://localhost:9091/api1?name=hong
	}

	@GetMapping("/api2")
	@ResponseBody
	public User apiObject(@RequestParam("name") String name) {
		Person p = new Person();
		p.setName(name);
		
		User user = new User();
		user.setAge(20);
		user.setName("홍길동");
		System.out.println("user="+user);
		
		return user;
		
		//http://localhost:9091/api2?name=hong
	}

	@RequestMapping("/")
    public String index() { 
		System.out.println("index page!");
        return "index";
    }
	
	@RequestMapping("/pd/pdList")
	public String pdList() {  
		System.out.println("pdList page");
		return "pd/pdList";
	}
	
	@GetMapping("/pd/pdWrite")
	public String pdWrite() {  
		System.out.println("pdwrite page");
		return "pd/pdWrite";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "홍길동");
		return "thymeleaf/hello";
		
		//http://localhost:9091/hello
	}

}


class Person {
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

