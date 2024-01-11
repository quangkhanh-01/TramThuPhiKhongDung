package com.example.tramthuphikhongdung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/dangnhap")
	public String dangnhap() {
		return "dangnhap";
	}
	@GetMapping("/dangky")
	public String dangky(){
		return "dangky";
	}
}
