package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentDao {
	List<Student> getStudents();
	Student getById(Integer studentId);
	Integer create(Student student);
	void updeate(Student student);
	void delete(Student student);
}
