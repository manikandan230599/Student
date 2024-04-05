package com.Student.dao;

import java.util.List;

import com.Student.bo.Student;
import com.Student.vo.StudentVo;

public interface StudentDao {

	StudentVo createStudent(StudentVo vo);

	List<StudentVo> getStudentList();

	StudentVo deleteStudent(long id);

}
