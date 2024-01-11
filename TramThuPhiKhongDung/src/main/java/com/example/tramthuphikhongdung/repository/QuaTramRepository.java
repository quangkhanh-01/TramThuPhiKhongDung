package com.example.tramthuphikhongdung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tramthuphikhongdung.entity.QuaTram;
import com.example.tramthuphikhongdung.entity.User;

import java.util.List;


public interface QuaTramRepository extends JpaRepository<QuaTram, Integer>{
	List<QuaTram> findByUser(User user);
}
