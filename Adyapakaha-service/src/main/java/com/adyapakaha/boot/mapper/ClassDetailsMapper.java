package com.adyapakaha.boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.adyapakaha.boot.model.ClassDetails;

public class ClassDetailsMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClassDetails cd = new ClassDetails();
		cd.setStandard(rs.getInt("standard_id"));
		cd.setStrength(rs.getInt("stdk_count"));
		cd.setTitle(rs.getString("title"));
		cd.setImage(rs.getString("image"));
		return cd;
	}

}