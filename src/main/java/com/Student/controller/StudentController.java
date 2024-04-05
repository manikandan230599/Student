package com.Student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.bo.Student;
import com.Student.sevice.StudentServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	StudentServices services;
	
	@PostMapping(value="/create-student")
	public Student CreateStudent(@RequestBody Student student){
		Student bo=new Student();
		bo=services.createStudent(student);
		return bo;
		}

	@GetMapping("/students")
	public List<Student> getStudentList(){
		List<Student> bolist=new ArrayList<>();
		bolist=services.getstudentList();
		return bolist;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteStudent(@PathVariable (name="id") long id) {
		Student bo=new Student();
		bo=services.deleteStudent(id);
		
		
		return true;
		
	}
	
}
