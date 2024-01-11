package com.example.tramthuphikhongdung.service;

import java.util.List;

import com.example.tramthuphikhongdung.entity.User;

public interface UserService {
    User findUserByEmailAndPassword(String email,String password);
    User saveUser(User user);
    User getUserById(int id);
    User getUserByRfid(String rfid);
    User updateUser(User user);
    List<User> getUsers();
    Boolean exitsByEmail(String email);
    Boolean existsByBienso(String bienso);
    Boolean existsByRfid(String rfid);
}
