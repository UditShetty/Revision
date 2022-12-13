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

import com.masai.exceptions.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService stdService;
	
	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId) throws StudentException{
		Student student = stdService.getStudentById(studentId);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentByReportingMsnagerId() throws StudentException{
		List<Student> student = stdService.getAllStudent();
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Student> deleteStudentByIdHandlet(@PathVariable("studentId") Integer studentId) throws StudentException{
		Student student = stdService.deleteStudent(studentId);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student std){
		Student student = stdService.addStudent(std);
		return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student std) throws StudentException{
		Student student = stdService.updateStudent(std);
		return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
	}
	
	
	

}
