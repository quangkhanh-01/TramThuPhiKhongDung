package com.example.tramthuphikhongdung.api;

import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.UserService;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userInfo, HttpSession session){
        User user = userService.findUserByEmailAndPassword(userInfo.getEmail(),userInfo.getPassword());
        if(user!=null){
            session.setAttribute("user",user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Tài khoản hoặc mật khẩu không đúng", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userInfo){
        if(userService.exitsByEmail(userInfo.getEmail())){
            return new ResponseEntity<>("Email đã tồn tại", HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByBienso(userInfo.getBienso())){
            return new ResponseEntity<>( "Biển số đã tồn tại", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(userService.saveUser(userInfo),HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
    	return new ResponseEntity<List<User>> (userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> informationUser(@PathVariable("id") int id){
    	User user = userService.getUserById(id);
    	return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PutMapping("/user/update")
    public ResponseEntity<?> changeProfile(@RequestBody User user){
    	return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
    }

}
