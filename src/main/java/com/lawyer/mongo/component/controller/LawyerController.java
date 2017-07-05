package com.lawyer.mongo.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lawyer.mongo.component.entity.Lawyer;
import com.lawyer.mongo.service.LawyerService;

@RestController
@RequestMapping("/rest/lawyer/v1")
public class LawyerController {

	@Autowired
	private LawyerService lawyerService;

	/**
	 * @param lawyer
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addNewLawyer(@RequestBody Lawyer lawyer) {
		lawyerService.add(lawyer);
		return String.format("Lawyer was add with id : %s", lawyer.getId());
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public Lawyer getLawyerById(@PathVariable("id") String id) {
		return lawyerService.get(id);
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/read/all", method = RequestMethod.GET)
	public List<Lawyer> getAllLawyers() {
		return lawyerService.getAll();
	}

	/**
	 * Update lawyer
	 * @param lawyer
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateLawyer(@RequestBody Lawyer lawyer) {
		lawyerService.update(lawyer);
		return "Lawyer was updated.";
	}

	/**
	 * Delete lawyer by id (id - string)
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteLawyerById(@PathVariable("id") String id) {
		lawyerService.remove(id);
	}

}
