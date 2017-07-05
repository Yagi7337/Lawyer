package com.lawyer.mongo.component.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lawyer.mongo.component.entity.Lawyer;

public interface ILawyer extends MongoRepository<Lawyer, String> {

	public Lawyer findByFirstName(String firstName);

	public List<Lawyer> findByLastName(String lastName);

}
