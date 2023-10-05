package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.StudentRowMapper;
import com.example.demo.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private NamedParameterJdbcTemplate db;

	@Override
	public List<Student> getStudents() {
		String sql = "SELECT id, name, phone_number FROM student";
		Map<String, Object> map = new HashMap<>();
		List<Student> students = db.query(sql, map,new StudentRowMapper());
		return students;
	}

	@Override
	public Student getById(Integer studentId) {
		String sql = "SELECT id, name, phone_number FROM student WHERE id = :id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", studentId);
		List<Student> students = db.query(sql, map,new StudentRowMapper());
		if(students.size()>0) {
			return students.get(0);			
		}else {
			return null;
		}
	}

	@Override
	public Integer create(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updeate(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

}
