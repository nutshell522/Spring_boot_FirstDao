package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	List<Student> getStudents();
	Student getById(Integer studentId);
	Integer create(Student student);
	void updeate(Student student);
	void delete(Student student);
}
