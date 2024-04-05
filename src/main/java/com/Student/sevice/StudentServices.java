package com.Student.sevice;

import java.util.List;

import com.Student.bo.Student;

public interface StudentServices {

	Student createStudent(Student student);

	List<Student> getstudentList();

Student deleteStudent(long id);

}
