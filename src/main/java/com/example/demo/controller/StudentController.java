package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;


@RequestMapping("/student")
@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping
	public String create(@RequestBody Student student) {
		Integer id = service.create(student);
		return "Create Sucessed. New StuID is " + id +"." ;
	}
	@GetMapping
	public List<Student> getAll() {
		return service.getStudents();
	}
	@GetMapping("/{studentId}")
	public Student getById(@PathVariable Integer studentId) {
		return service.getById(studentId);
	}
	@PutMapping
	public String update(@RequestBody Student student) {
		service.updeate(student);
		return "update successed.";
	}
	@DeleteMapping("/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		service.delete(studentId);
		return "delete successed.";
	}
}
