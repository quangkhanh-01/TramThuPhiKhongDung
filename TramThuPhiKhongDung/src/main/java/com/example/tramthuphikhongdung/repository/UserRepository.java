package com.example.tramthuphikhongdung.repository;

import java.util.List;
import java.util.Optional;

import com.example.tramthuphikhongdung.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmailAndPassword(String email, String password);
	Optional<User> findByRfid(String rfid);
	List<User> findByIsAdmin(boolean admin);
	Boolean existsByEmail(String email);
	Boolean existsByBienso(String bienso);
	Boolean existsByRfid(String rfid);
}
