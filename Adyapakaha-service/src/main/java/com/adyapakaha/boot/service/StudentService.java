package com.adyapakaha.boot.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.StudentDao;
import com.adyapakaha.boot.mapper.ClassDetailsMapper;
import com.adyapakaha.boot.model.ClassDetails;
import com.adyapakaha.boot.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");

	public Student createStudent(Student student) {
		return studentDao.save(student);
	}

	public List<Student> getAllStudents() {
		return (List<Student>) studentDao.findAll();
	}

	public Student updateStudent(Student student, Long id) {
		Student updatedstudent = studentDao.findById(id).orElseThrow();
		updatedstudent.setAge(student.getAge());
		updatedstudent.setFirstName(student.getFirstName());
		updatedstudent.setLastName(student.getLastName());
		updatedstudent.setGender(student.getGender());
		updatedstudent.setParentPhno(student.getParentPhno());
		updatedstudent.setPhNo(student.getPhNo());
		updatedstudent.setStd(student.getStd());
		return studentDao.save(updatedstudent);
	}

	public void deleteStudent(Long id) {
		studentDao.deleteById(id);
	}

	public List<ClassDetails> getClasswiseDetails() {
		String sql = "SELECT standard_id," + " COUNT(standard_id) AS stdk_count" + " FROM student "
				+ " WHERE standard_id IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)" + " GROUP BY standard_id";

		return jdbcTemplate.query(sql, new ClassDetailsMapper());

	}

	public List<Student> getStudentByStandard(long id) {
		return studentDao.findByStandardId(id);
	}

	public List<Student> getNonPaidStudentsByStandardwise(long id) {
		return studentDao.getNonPaidStudentsByStandardwise(id);
	}

	public List<ClassDetails> getStudentByNonPaidByClassWise() {
		String sql = "SELECT standard_id," + " COUNT(standard_id) AS stdk_count" + " FROM student "
				+ " WHERE standard_id IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) AND paid = " + 0
				+ " GROUP BY standard_id";

		return jdbcTemplate.query(sql, new ClassDetailsMapper());
	}

	public List<Long> getStudentsByExceededEndDate() {
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return studentDao.getStudentsByExceededEndDate(sdf3.format(timestamp));
	}
	
	public void updateStudentsByExceededEndDate(StringBuffer ids) {
		String sql = "UPDATE Student SET paid = false WHERE  id IN "+ ids;
		System.out.println("spl===="+ sql);
		jdbcTemplate.update(sql); 
		
		System.out.println("ds====="+ ids);
//		studentDao.updateStudentsByExceededEndDate(ids);
	}

}
