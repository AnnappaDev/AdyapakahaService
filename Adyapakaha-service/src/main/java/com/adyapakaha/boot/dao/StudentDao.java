package com.adyapakaha.boot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adyapakaha.boot.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Long>{

	@Query(value="SELECT * from Student stud where stud.standard_id=?1", nativeQuery = true)
	public List<Student> findByStandardId(long id);
	
	@Query(value="SELECT * from Student stud where stud.paid=0 AND stud.standard_id=?1", nativeQuery = true)
	public List<Student> getNonPaidStudentsByStandardwise(long id);

	@Query(value="SELECT id FROM Student WHERE paid = true AND end_date < ?1", nativeQuery = true)
	public List<Long> getStudentsByExceededEndDate(String format);

//	@Query(value="UPDATE Student stud SET stud.paid = false WHERE  stud.id IN (?1)", nativeQuery = true)
//	public void updateStudentsByExceededEndDate(StringBuffer ids);

	
	
}
