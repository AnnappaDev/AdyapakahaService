package com.adyapakaha.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="http://localhost:8100")
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
	
	@GetMapping({"/{id}"})
	public Optional<Student> geStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping({"/getByKeyword/{keyword}/{id}"})
	public List<Student> geStudentByKeyword(@PathVariable String keyword, @PathVariable long id) {
		return studentService.getStudentByName(keyword, id);
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
