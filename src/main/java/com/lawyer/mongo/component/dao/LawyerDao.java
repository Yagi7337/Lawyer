package com.lawyer.mongo.component.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lawyer.mongo.component.entity.Lawyer;

@Repository
public class LawyerDao {

	@Autowired
	private MongoOperations mongoOperations;

	public void addLawyer(Lawyer lawyer) {
		mongoOperations.insert(lawyer);
	}
	
	public void updateLawyer(Lawyer lawyer) {
		mongoOperations.save(lawyer);
	}

	public Lawyer get(String id) {
		return mongoOperations.findById(id, Lawyer.class);
	}

	public List<Lawyer> getAll() {
		return mongoOperations.findAll(Lawyer.class);
	}

	public void remove(String id) {
		mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Lawyer.class);
	}

}
