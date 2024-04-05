package com.Student.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Student.bo.Student;
import com.Student.dao.StudentDao;
import com.Student.vo.StudentVo;

@Service
@Transactional
public class StudentServiceImpl  implements StudentServices{

	@Autowired
	StudentDao dao;
	
	
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		StudentVo vo=new StudentVo();
		Student bo=new Student();
		vo.setId(student.getId());
		vo.setName(student.getName());
		vo.setEmailId(student.getEmailId());
		vo.setTotalMarks(student.getTotalMarks());
		
		StudentVo studentVo=dao.createStudent(vo);
		
		bo.setId(studentVo.getId());
		bo.setName(studentVo.getName());
		bo.setEmailId(studentVo.getEmailId());
		bo.setTotalMarks(studentVo.getTotalMarks());
		
		return bo;
	}


	@Override
	public List<Student> getstudentList() {
		List<Student> Bolist=new ArrayList<>();
		List<StudentVo> volist=new ArrayList<>();
		volist=dao.getStudentList();
		 for(StudentVo vo : volist) {
			   Student studentBo = new Student();
			   studentBo.setId(vo.getId());
			   studentBo.setName(vo.getName());
			   studentBo.setEmailId(vo.getEmailId());
			   studentBo.setTotalMarks(vo.getTotalMarks());
			 
			   
			   Bolist.add(studentBo);
		 }
		return Bolist;
	}


	


	@Override
	public Student deleteStudent(long id) {
		// TODO Auto-generated method stub
		Student bos=new Student();
		StudentVo vos=new StudentVo();
		vos=dao.deleteStudent(id);
		bos.setId(vos.getId());
		return bos;
	}

}
