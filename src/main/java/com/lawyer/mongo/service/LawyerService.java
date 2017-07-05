package com.lawyer.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawyer.mongo.component.dao.LawyerDao;
import com.lawyer.mongo.component.entity.Lawyer;

@Service
public class LawyerService {

	@Autowired
	private LawyerDao lawyerDao;

	public void add(Lawyer lawyer) {
		lawyerDao.addLawyer(lawyer);
	}

	public void update(Lawyer lawyer) {
		lawyerDao.updateLawyer(lawyer);
	}

	public Lawyer get(String id) {
		return lawyerDao.get(id);
	}

	public List<Lawyer> getAll() {
		return lawyerDao.getAll();
	}

	public void remove(String id) {
		lawyerDao.remove(id);
	}
}
