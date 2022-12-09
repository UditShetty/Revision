package com.masai.service;

import java.util.List;

import com.masai.exceptions.CourseException;
import com.masai.model.Course;

public interface CourseService {
	
	public Course getCourseById(Integer courseId) throws CourseException;
	
	public List<Course> getAllCourse() throws CourseException;
	
	public Course updateCourse(Course course)throws CourseException;
	
	public Course deleteCourse(Integer courseId)throws CourseException;
	
	public Course addCourse(Course course);

}
