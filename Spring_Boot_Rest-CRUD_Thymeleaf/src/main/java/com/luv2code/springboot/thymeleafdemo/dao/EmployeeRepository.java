package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// add a method to sort by last name - create a special method by SprintDataJpa by parsing the name
	// looks for a specific format and patter : Creates appropriate query ... behind the scenes
	public List<Employee> findAllByOrderByLastNameAsc();
}
