package com.example.tramthuphikhongdung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "redirect:/dangnhap";
	}
    @GetMapping("/dangxuat")
    public String logout(HttpSession session){
    	session.removeAttribute("user");
    	return "redirect:/dangnhap";
    }
}
