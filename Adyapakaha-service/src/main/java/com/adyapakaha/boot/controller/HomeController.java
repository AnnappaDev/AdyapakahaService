package com.adyapakaha.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.ClassDetails;
import com.adyapakaha.boot.model.Student;
import com.adyapakaha.boot.service.StudentService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<ClassDetails> getClassDetails() {
		return (List<ClassDetails>) studentService.getClasswiseDetails();
	}

	@GetMapping({ "/getNonPaidFees" })
	public List<ClassDetails> getStudentByNonPaidByClassWise() {

		return (List<ClassDetails>) studentService.getStudentByNonPaidByClassWise();
	}

	@GetMapping({ "/getByStdNonPaid/{id}" })
	public List<Student> getNonPaidStudentsByStandardwise(@PathVariable long id) {
		StringBuffer ids = new StringBuffer("(");
		List<Long> studs = new ArrayList<Long>();
		studs = studentService.getStudentsByExceededEndDate();
		if(studs.size() > 0) {
			for (int i = 0; i < studs.size(); i++) {
				 System.out.println("studs=====" +studs.get(i));
				 ids.append(studs.get(i));
				 if (i < studs.size() && i < studs.size()-1) {
					 ids.append(",");
				 } 
			 }
			 ids.append(")");
			 System.out.println("ids---222--"+ ids);
			 studentService.updateStudentsByExceededEndDate(ids);	
		}
		return studentService.getNonPaidStudentsByStandardwise(id);
	}

}
