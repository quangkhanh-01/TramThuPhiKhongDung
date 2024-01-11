package com.example.tramthuphikhongdung.service;

import java.text.ParseException;
import java.util.List;

import com.example.tramthuphikhongdung.entity.QuaTram;
import com.example.tramthuphikhongdung.entity.User;

public interface QuaTramService {
	void save(QuaTram quatram);
	List<QuaTram> getQuaTramByUser(User user) throws ParseException;
}
