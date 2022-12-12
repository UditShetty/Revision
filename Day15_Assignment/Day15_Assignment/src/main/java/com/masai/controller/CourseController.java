package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CourseException;
import com.masai.model.Course;
import com.masai.service.CourseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService empService;
	
	@GetMapping("/courses/{employeeid}")
	public ResponseEntity<Course> getEmployeeById(@PathVariable("employeeid") Integer employeeid) throws CourseException{
		Course employee = empService.getCourseById(employeeid);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllEmployeeByReportingMsnagerId() throws CourseException{
		List<Course> employee = empService.getAllCourse();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/courses/{employeeid}")
	public ResponseEntity<Course> deleteEmployeeByIdHandlet(@PathVariable("employeeid") Integer employeeid) throws CourseException{
		Course employee = empService.deleteCourse(employeeid);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addEmployeeHandler(@RequestBody Course emp){
		Course employee = empService.addCourse(emp);
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateEmployeeHandler(@RequestBody Course emp) throws CourseException{
		Course employee = empService.updateCourse(emp);
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
	}
	
	
	

}
