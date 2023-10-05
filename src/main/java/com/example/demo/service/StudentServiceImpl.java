package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao repo;

	@Override
	public List<Student> getStudents() {
		return repo.getStudents();
	}

	@Override
	public Student getById(Integer studentId) {
		return repo.getById(studentId);
	}

	@Override
	public Integer create(Student student) {
		return repo.create(student);
	}

	@Override
	public void updeate(Student student) {
		repo.update(student);
	}

	@Override
	public void delete(Integer studentId) {
		repo.delete(studentId);
		
	}

}
