package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping ("/viral")
	public String viral () {
		return "viral";
	}
	
	@RequestMapping ("/challenge")
	public String challenge (@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping (value= {"/challenge","challenge/{name}"})
	public String challengePath (@PathVariable Optional <String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping ("/generator")
	public String viralGen (@RequestParam (value="a", required=false, defaultValue="0")  int a, @RequestParam (value = "b", required=false, defaultValue="0") int b, Model model) {
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		String str = "hm";
		for(int i=0; i<= a; i++) {
			if(i >1) {
			str += "m";}
			
		}
		String strs = str;
		for(int i=0; i<=b;i++) {
			if(i>1) {
			str += " ";
			str += strs;}
			model.addAttribute("words", str);
		}	
		return "viralgenerator";	
	}
}
