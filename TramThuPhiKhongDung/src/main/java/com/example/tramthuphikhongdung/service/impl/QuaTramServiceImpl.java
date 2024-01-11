package com.example.tramthuphikhongdung.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tramthuphikhongdung.entity.QuaTram;
import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.repository.QuaTramRepository;
import com.example.tramthuphikhongdung.service.QuaTramService;

@Service
public class QuaTramServiceImpl implements QuaTramService {
	@Autowired
	private QuaTramRepository quaTramRepository;
	@Override
	public void save(QuaTram quatram) {
		quaTramRepository.save(quatram);
	}
	@Override
	public List<QuaTram> getQuaTramByUser(User user) throws ParseException {
		List<QuaTram> listQuaTram = quaTramRepository.findByUser(user);
		return listQuaTram;
	}

	
}
