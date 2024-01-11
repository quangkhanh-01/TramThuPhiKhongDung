package com.example.tramthuphikhongdung.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.repository.UserRepository;
import com.example.tramthuphikhongdung.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if(user.isPresent()){
           return user.get();
        }else{
            return null;
        }
    }	

    @Override
    public User saveUser(User user) {
        user.setAdmin(false);
        return userRepository.save(user);
    }

    @Override
    public Boolean exitsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByBienso(String bienso) {
        return userRepository.existsByBienso(bienso);
    }

    @Override
    public Boolean existsByRfid(String rfid) {
        return userRepository.existsByRfid(rfid);
    }
	@Override
	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User getUserByRfid(String rfid) {
		Optional<User> user = userRepository.findByRfid(rfid);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	@Override
	public List<User> getUsers() {
		List<User> users = userRepository.findByIsAdmin(false);
		if(users.size()!=0) {
			return users;
		}
		return null;
	}
}
