package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.Student;
import com.adyapakaha.boot.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PutMapping({ "/{id}" })
	public Student updateStudent(@RequestBody Student student, @PathVariable long id) {
		return studentService.updateStudent(student, id);
	}

	@DeleteMapping({"/{id}"})
	public void deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
	}
	
	@GetMapping({"/getByStd/{id}"})
	public List<Student> getByStandardId(@PathVariable long id) {
		return studentService.getStudentByStandard(id);
	}
	
	
}
