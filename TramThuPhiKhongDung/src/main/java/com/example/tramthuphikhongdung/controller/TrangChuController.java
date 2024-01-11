package com.example.tramthuphikhongdung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tramthuphikhongdung.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TrangChuController {
	
	@GetMapping("/trangchu")
	public String trangchu(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "redirect:/dangnhap";
		}
		return "admin_home";
	}
	@GetMapping("/quanly/user")
	public String managerUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "redirect:/dangnhap";
		}
		return "admin_user";
	}
	@GetMapping("/quanly/quatram")
	public String managerQuaTram(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "redirect:/dangnhap";
		}
		return "admin_quatram";
	}
}
