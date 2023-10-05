package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		String sql = "INSERT INTO student (name, phone_number) "
				+ " VALUES "
				+ " (:name, :phone_number);";
		Map<String, Object> map = new HashMap<>();
		map.put("name", student.getName());
		map.put("phone_number", student.getPhoneNumber());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		db.update(sql,new MapSqlParameterSource(map),keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public void update(Student student) {
		String sql = "UPDATE student"
				+ " SET phone_number = :phone_number, name = :name"
				+ " WHERE id = :id ;";
		Map<String, Object> map = new HashMap<>();
		map.put("name", student.getName());
		map.put("phone_number", student.getPhoneNumber());
		map.put("id", student.getId());
		
		db.update(sql, map);
	}

	@Override
	public void delete(Integer studentId) {
		String sql = "DELETE FROM student"
				+ " WHERE id = :id ;";
		Map<String, Object> map = new HashMap<>();
		map.put("id", studentId);
		
		db.update(sql, map);
		
	}

}
