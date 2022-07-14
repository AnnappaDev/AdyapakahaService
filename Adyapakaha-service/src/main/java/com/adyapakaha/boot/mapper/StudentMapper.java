///package com.adyapakaha.boot.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.adyapakaha.boot.model.ClassDetails;
//import com.adyapakaha.boot.model.Student;
//
//public class StudentMapper implements RowMapper {
//	@Override
//	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Student student = new Student();
//		student.setAge(rs.getString("age"));
//		student.setFirstName(rs.getString("firstName"));
//		student.setLastName(rs.getString("lastName"));
//		student.setGender(rs.getObject("gender_id"));
//		return cd;
//	}
//}
