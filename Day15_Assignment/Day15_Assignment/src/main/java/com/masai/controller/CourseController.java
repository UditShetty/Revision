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
	private CourseService crsService;
	
	@GetMapping("/courses/{courseid}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseid") Integer courseid) throws CourseException{
		Course course = crsService.getCourseById(courseid);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourseByReportingMsnagerId() throws CourseException{
		List<Course> course = crsService.getAllCourse();
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@DeleteMapping("/courses/{courseid}")
	public ResponseEntity<Course> deleteCourseByIdHandlet(@PathVariable("courseid") Integer courseid) throws CourseException{
		Course course = crsService.deleteCourse(courseid);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourseHandler(@RequestBody Course crs){
		Course course = crsService.addCourse(crs);
		return new ResponseEntity<>(course,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourseHandler(@RequestBody Course crs) throws CourseException{
		Course course = crsService.updateCourse(crs);
		return new ResponseEntity<>(course,HttpStatus.ACCEPTED);
	}
	
	
	

}
