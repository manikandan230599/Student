package com.Student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.Student.bo.Student;
import com.Student.vo.StudentVo;
@Repository
public class StudentDaoImpl implements StudentDao{
	
	@PersistenceContext
	private EntityManager em;
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	

	@Override
	public StudentVo createStudent(StudentVo vo) {
	
		Session session=getSession();
		session.save(vo);
		return vo;
	}


	@Override
	public List<StudentVo> getStudentList() {
Session session= getSession();
CriteriaBuilder cb=session.getCriteriaBuilder();
CriteriaQuery<StudentVo> cr=cb.createQuery(StudentVo.class);
Root<StudentVo> root=cr.from(StudentVo.class);
cr.select(root);
Query<StudentVo> query = session.createQuery(cr);
List<StudentVo> result = query.list();

		return result;
	}

	@Override
	public StudentVo deleteStudent(long id) {
		// TODO Auto-generated method stub
		StudentVo studentVo = new StudentVo();
		Session session = getSession();
		StudentVo vo = session.get(StudentVo.class, id);
		session.delete(vo);
		return studentVo;
	}

}
