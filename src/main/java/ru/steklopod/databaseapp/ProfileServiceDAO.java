package ru.steklopod.databaseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileServiceDAO {

//	@Qualifier("jdbcProfileService")
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getCount_from_users() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USERS", Integer.class);
	}
}
