package com.example.tramthuphikhongdung.api;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tramthuphikhongdung.entity.QuaTram;
import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.QuaTramService;
import com.example.tramthuphikhongdung.service.UserService;

@RestController
@RequestMapping("/api")
public class QuaTramApi {
	@Autowired
	private QuaTramService quaTramService;
	@Autowired
	private UserService userService;
	@GetMapping("/quatram/{idUser}")
	public ResponseEntity<?> getQuatram(@PathVariable("idUser") Integer idUser) throws ParseException{
		User user = userService.getUserById(idUser);
		List<QuaTram> listQuaTram = quaTramService.getQuaTramByUser(user); 
		return new ResponseEntity<List<QuaTram>>(listQuaTram,HttpStatus.OK);
	}
}
