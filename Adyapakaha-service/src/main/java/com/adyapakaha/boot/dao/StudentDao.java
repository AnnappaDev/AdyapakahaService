package com.adyapakaha.boot.dao;

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

	@Query(value="SELECT * from Student stud where (stud.first_name like %?1% OR stud.last_name like %?1%) AND stud.standard_id=?2", nativeQuery = true)
	public List<Student> getStudentsBysearchKeyword(String searchKeyword, long id);
	
}
